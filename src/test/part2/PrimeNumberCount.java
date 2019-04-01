package test.part2;

/* 소수판별법 = x를 2 부터 √x 까지의 자연수로 나누어 본다.
 * 나누어 떨어지면 소수가 아님.
 */

public class PrimeNumberCount {

	public static void getPrimeNumberCount(int num) {
		long start = System.currentTimeMillis();

		// 유일한 짝수인 소수 2의 count
		int count = 1;

		// 3 부터 num 까지 홀수반복
		for (int i = 3; i <= num; i = i + 2) {
			// √i
			double sqrt = Math.sqrt(i);
			boolean isPrime = true;

			// 3 부터 √i 까지 홀수반복
			for (int j = 3; j <= sqrt; j = j + 2) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime) {
				// System.out.println(i);
				count++;
			}
		}

		System.out.println("소수 총 갯수 : " + count);

		long end = System.currentTimeMillis();

		System.out.println("실행 시간 : " + (end - start) / 1000.0 + " sec");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 10000000;

		getPrimeNumberCount(num);
	}

}
