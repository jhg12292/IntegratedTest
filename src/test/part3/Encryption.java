package test.part3;

public class Encryption {

	public static void getEncryption(int inputNum, String inputStr) {
		long start = System.currentTimeMillis();

		// 입력 숫자의 범위가 1~26을 넘어가는지 검사
		if (inputNum >= 1 && inputNum <= 26) {
			// 입력 문자열 길이만큼 배열 길이 초기화
			char[] inputWords = new char[inputStr.length()];
			char[] outputWords = new char[inputStr.length()];

			// 입력 문자열을 캐릭터형 으로 변환하여 분할 저장
			inputWords = inputStr.toCharArray();

			// 배열 길이 만큼 반복
			for (int i = 0; i < inputWords.length; i++) {
				// 캐릭터의 아스키코드 구함
				int ascNum = (int) inputWords[i];
				// 아스키코드 65~90 까지(대문자 A~Z)
				if (ascNum >= 65 && ascNum <= 90) {
					// ascNum + inputNum 값이 대문자 값을 넘어간다면 26만큼 뺀 숫자를 더하여 저장
					if (ascNum + inputNum > 90) {
						outputWords[i] = (char) (ascNum + (inputNum - 26));
					} else {
						outputWords[i] = (char) (ascNum + inputNum);
					}
				}
				// 아스키코드 97 ~ 122 까지(소문자 a ~ z)
				else if (ascNum >= 97 && ascNum <= 122) {
					// ascNum + inputNum 값이 소문자 값을 넘어간다면 26만큼 뺀 숫자를 더하여 저장
					if (ascNum + inputNum > 122) {
						outputWords[i] = (char) (ascNum + (inputNum - 26));
					} else {
						outputWords[i] = (char) (ascNum + inputNum);
					}
				}
				// 그외 나머지
				else {
					// 변환 없이 그대로 저장
					outputWords[i] = (char) ascNum;
				}
			}
			// 캐릭터 배열을 문자열로 변환후 화면에 출력
			System.out.println(String.valueOf(outputWords));
		} else {
			System.out.println("Wrong inputNumber");
		}

		long end = System.currentTimeMillis();

		System.out.println("실행 시간 : " + (end - start) / 1000.0 + " sec");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int inputNum = 3;
		String inputStr = "Hello World!";

		getEncryption(inputNum, inputStr);
	}

}
