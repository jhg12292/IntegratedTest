package test.part8;

public class Palindrome {

	// palindrome 시작 함수
	public static void solution(String s) {
		// 문장 s 스플릿 후 list 에 담음
		String list[] = s.split("");
		// 최대자릿수
		int greatestNum = 0;
		// 자릿수
		int num = 1;
		// 기준
		int stand = 0;

		// list 길이만큼 반복
		for (int i = 0; i < list.length; i++) {

			while (true) {
				// i-num 의 값과 i+num 의 값이 존재하면 실행
				if ((i - num) > -1 && (i + num) < list.length) {

					if (list[i - num].equals(list[i + num])) {

						if (num > greatestNum) {
							stand = i;
							greatestNum = num;
						}
						num++;
					} else {
						// 자릿수 초기화
						num = 1;
						break;
					}
				} else {
					// 자릿수 초기화
					num = 1;
					break;
				}
			}
		}

		System.out.println((stand + 1) + " 번째 글자 부터 좌우로 " + greatestNum + " 자리까지");
		System.out.println(greatestNum * 2 + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "atopspotaeeatopspotaeeeatopspfotaeetopspot";

		solution(s);
	}

}
