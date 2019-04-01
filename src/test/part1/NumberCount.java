package test.part1;

public class NumberCount {
	
	// 문자열로 처리 1
	public static void test1(int num, int max) {
		long start = System.currentTimeMillis();
		
		String total = "";
		
		for(int i = 1; i <= max; i++){
			total += i;
		}
		
		System.out.println((total + " ").split(Integer.toString(num)).length - 1);
		
		long end = System.currentTimeMillis();
		
		System.out.println("실행 시간 : " + (end - start) / 1000.0 + " sec");
	}
	
	// 문자열로 처리 2
	public static void test2(int num, int max) {
		long start = System.currentTimeMillis();
		
		int count = 0;
		
		for(int i = 1; i <= max; i++){
			count += ((i + " ").split(Integer.toString(num)).length - 1);
		}
		
		System.out.println(count);
		
		long end = System.currentTimeMillis();
		
		System.out.println("실행 시간 : " + (end - start) / 1000.0 + " sec");
	}
	
	// 숫자로 처리
	public static void test3(int num, int max) {
		long start = System.currentTimeMillis();
		
		int count = 0;
		
		for(int i = 1; i <= max; i++){
		    for(int j = i; j > 0; j /= 10){
		        if(j % 10 == num){
		            count++;
		        }
		    }
		}
		
		System.out.println(count);
		
		long end = System.currentTimeMillis();
		
		System.out.println("실행 시간 : " + (end - start) / 1000.0 + " sec");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 8;
		int max = 10000;
		
		test1(num, max);
		test2(num, max);
		test3(num, max);
	}

}
