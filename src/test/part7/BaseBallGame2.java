package test.part7;

import java.util.ArrayList;

public class BaseBallGame2 {
	// 비교값이 들어가는 listAll 전역변수 선언
	private static ArrayList<String> listAll;

	// 문자열에 중복이 있는지 체크하는 함수
	public static boolean isStringValid(String s) {
		String list[] = s.split("");
		boolean flag = false;

		// 중복이 있다면 true 반환, 없으면 false 반환
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

	// 게임 데이터 초기화 함수
	public static void initGame() {
		// 비교값이 들어가는 listAll 초기화
		listAll = new ArrayList<String>();

		// listAll 에 100 부터 999 까지 모든 수를 담는다.
		for (int i = 100; i <= 999; i++) {
			String s = String.valueOf(i);

			// 단 0이 포함된 수와 중복된 숫자가 포함된 수는 제외한다. 최종적으로 listAll 에 123 ~ 987 의 504개가 들어감
			if (s.indexOf("0") == -1) {
				if (!isStringValid(s)) {
					listAll.add(s);
				}
			}
		}
	}

	// listA(비교값), listB(입력값) 를 비교하여 strike, ball 갯수를 반환하는 함수
	public static int[] compare(String listA[], String listB[]) {
		int strikeCount = 0;
		int ballCount = 0;

		for (int i = 0; i < listA.length; i++) {
			// 같은자리(i)에 같은 문자열이면 strikeCount 증가
			if (Integer.parseInt(listA[i]) == Integer.parseInt(listB[i])) {
				strikeCount++;
			} else {
				for (int j = 0; j < listB.length; j++) {
					// 같은 문자열이 있으면 ballCount 증가
					if (Integer.parseInt(listA[i]) == Integer.parseInt(listB[j])) {
						ballCount++;
					}
				}
			}
		}

		int result[] = { strikeCount, ballCount };

		return result;
	}

	// 게임 시작 함수
	public static void playGame(int[][] array) {
		// 게임 데이터 초기화
		initGame();

		// 입력값의 배열 수 만큼 반복
		for (int i = 0; i < array.length; i++) {
			// 입력값, 스트라이크, 볼
			int number = array[i][0];
			int strike = array[i][1];
			int ball = array[i][2];

			// 비교값 listAll 전체를 반복
			for (int j = 0; j < listAll.size(); j++) {
				// 비교값을 스플릿 하여 listA 담음
				String listA[] = listAll.get(j).split("");
				// 입력값을 스플릿 하여 listB 담음
				String listB[] = String.valueOf(number).split("");

				// 비교값과 입력값을 비교하여 결과값 을 가져옴
				int result[] = compare(listA, listB);

				// 입력값의 strike, ball 과 결과값의 strike, ball를 비교하여 다르면 비교값을 listAll 에서 제거
				if (strike != result[0] || ball != result[1]) {
					listAll.remove(j);
					j--;
				}
			}
		}

		// 최종결과 listAll의 size
		System.out.println(listAll.size());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[][] array = { { 143, 1, 1 } };
		int[][] array = { { 123, 1, 1 }, { 356, 1, 0 }, { 327, 2, 0 }, { 489, 0, 1 } };

		playGame(array);
	}

}
