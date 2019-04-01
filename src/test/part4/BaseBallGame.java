package test.part4;

import java.util.Scanner;

public class BaseBallGame {
	// scan 선언및 초기화
	private static Scanner scan = null;

	// 게임 관련 데이터 선언및 초기화
	private static int listA[] = new int[5];
	private static int totalCount = 0;

	// 문자열이 숫자인지 체크하는 함수
	// 숫자면 true 반환, 문자열이면 false 반환
	public static boolean isStringInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	// 문자열에 중복이 있는지 체크하는 함수
	// 중복이 있다면 true 반환, 없으면 false 반환
	public static boolean isStringValid(String s) {
		String list[] = s.split("");
		boolean flag = false;

		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < i; j++) {
				if (list[i].equals(list[j])) {
					flag = true;
					break;
				}
			}
		}
		return flag;
	}

	// 입력값 받는 함수
	public static void getInputValue() {
		// inputValue값을 입력받음
		scan = new Scanner(System.in);
		String inputValue = scan.next();

		// input값 유효성 검사
		if (inputValue.length() != 5 || isStringInt(inputValue) == false || isStringValid(inputValue) == true) {
			System.out.print("5자리의 올바른 숫자를 중복되지 않게 입력하세요 : ");
			getInputValue();
		} else {
			
			playBaseBall(inputValue);
		}
	}

	// 0~9 랜덤 숫자 리스트 생성 함수
	public static void makeRandomNumber() {
		for (int i = 0; i < listA.length; i++) {
			// 리스트에 랜덤값 삽입
			listA[i] = (int) (Math.random() * 10);

			// 리스트 중복 검사
			for (int j = 0; j < i; j++) {
				// 중복있다면 i를 줄여서 반복
				if (listA[i] == listA[j]) {
					i--;
					break;
				}
			}
		}
	}

	// 게임 실행 함수
	public static void playBaseBall(String s) {
		// totalCount가 0이면 makeRandomNumber() 실행
		if (totalCount == 0) {
			makeRandomNumber();
		}

		// totalCount 증가
		totalCount++;

		// 입력문자열을 listB에 나누어 담음
		String listB[] = s.split("");

		// strikeCount, ballCount 초기화
		int strikeCount = 0;
		int ballCount = 0;

		for (int i = 0; i < listA.length; i++) {
			// 같은자리(i)에 같은 문자열이면 strikeCount 증가
			if (listA[i] == Integer.parseInt(listB[i])) {
				strikeCount++;
			} else {
				for (int j = 0; j < listB.length; j++) {
					// 같은 문자열이 있으면 ballCount 증가
					if (listA[i] == Integer.parseInt(listB[j])) {
						ballCount++;
					}
				}
			}
		}

		// strikeCount값이 5면 게임 종료
		if (strikeCount == 5) {
			System.out.println("결과 : " + totalCount + " 번 만에 정답을 맞추셨습니다.");
			if (scan != null) {
				scan.close();
			}
		} else if (ballCount == 0 && strikeCount == 0) {
			System.out.println("결과 : Out");
			System.out.println("");
			System.out.print("숫자 5자리를 입력하세요 : ");
			getInputValue();
		} else {
			System.out.println("결과 : " + ballCount + " Ball, " + strikeCount + " Strike");
			System.out.println("");
			System.out.print("숫자 5자리를 입력하세요 : ");
			getInputValue();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("숫자 5자리를 입력하세요 : ");
		getInputValue();
	}

}
