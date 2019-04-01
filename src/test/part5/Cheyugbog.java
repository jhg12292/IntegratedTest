package test.part5;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Cheyugbog {

	// scan 선언및 초기화
	private static Scanner scan = null;

	// 게임 관련 데이터 선언및 초기화
	private static int totalStudent;
	private static ArrayList<String> listLost;
	private static ArrayList<String> listExtra;

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
		String list[] = s.split(",");
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

	// 총 학생수 입력받는 함수
	public static void getTotalStudent() {
		// inputValue값을 입력받음
		scan = new Scanner(System.in);
		String inputValue = scan.nextLine();

		// 공백제거
		inputValue = inputValue.replaceAll(" ", "");

		// input값 유효성 검사
		if (isStringInt(inputValue) == false || Integer.parseInt(inputValue) < 2 || Integer.parseInt(inputValue) > 30) {
			System.out.println("2 ~ 30 까지 자연수만 입력 가능 합니다.");
			System.out.print("총 학생수를 올바르게 입력하세요. : ");
			getTotalStudent();
		} else {
			totalStudent = Integer.parseInt(inputValue);

			System.out.print("체육복을 도난당한 학생들을 입력하세요. : ");
			getLostStudent();
		}
	}

	// 체육복을 도단당한 학생들을 입력받는 함수
	public static void getLostStudent() {
		// inputValue값을 입력받음
		scan = new Scanner(System.in);
		String inputValue = scan.nextLine();

		// 공백제거
		inputValue = inputValue.replaceAll(" ", "");

		listLost = new ArrayList<String>(Arrays.asList(inputValue.split(",")));

		boolean flag = true;

		for (int i = 0; i < listLost.size(); i++) {
			if (isStringInt(listLost.get(i)) == false) {
				flag = false;
				break;
			}
		}

		// listLost값 유효성 검사
		if (listLost.size() < 2 || listLost.size() > totalStudent || isStringValid(inputValue) == true || flag == false) {
			System.out.println("최소 2명 ~ 최대 " + totalStudent + "명 까지 입력 가능. ','로 복수 구분. 중복 번호 X. 자연수만 입력가능.");
			System.out.print("체육복을 도난당한 학생들을 올바르게 입력하세요. : ");
			getLostStudent();
		} else {
			System.out.print("여분의 체육복을 가져온 학생들을 입력하세요. : ");
			getExtraStudent();
		}
	}

	// 여분의 체육복이 있는 학생들을 입력받는 함수
	public static void getExtraStudent() {
		// inputValue값을 입력받음
		scan = new Scanner(System.in);
		String inputValue = scan.nextLine();

		// 공백제거
		inputValue = inputValue.replaceAll(" ", "");

		listExtra = new ArrayList<String>(Arrays.asList(inputValue.split(",")));

		boolean flag = true;

		for (int i = 0; i < listExtra.size(); i++) {
			if (isStringInt(listExtra.get(i)) == false) {
				flag = false;
				break;
			}
		}

		// listExtra값 유효성 검사
		if (listExtra.size() < 1 || listExtra.size() > totalStudent || isStringValid(inputValue) == true || flag == false) {
			System.out.println("최소 1명 ~ 최대 " + totalStudent + "명 까지 입력 가능. ','로 복수 구분. 중복 번호 X. 자연수만 입력가능.");
			System.out.print("여분의 체육복을 가져온 학생들을 올바르게 입력하세요. : ");
			getExtraStudent();
		} else {
			reserveCheyugbog();
		}
	}

	// 채육복을 대여하는 함수
	public static void reserveCheyugbog() {
		// 도난당한 학생중에 여분을 가져온 학생이 있으면 두 리스트에서 제거
		for (int i = 0; i < listLost.size(); i++) {
			int a = Integer.parseInt(listLost.get(i));
			
			for (int j = 0; j < listExtra.size(); j++) {
				int b = Integer.parseInt(listExtra.get(j));
				
				if (a == b) {
					listLost.remove(i);
					listExtra.remove(j);
					i--;
					j--;
				}
			}
		}

		// 도난당한 학생중에 여분을 빌려올수 있으면 두 리스트에서 제거
		for (int i = 0; i < listLost.size(); i++) {
			int a = Integer.parseInt(listLost.get(i));
			
			for (int j = 0; j < listExtra.size(); j++) {
				int b = Integer.parseInt(listExtra.get(j));
				
				if (a - 1 == b || a + 1 == b) {
					listLost.remove(i);
					listExtra.remove(j);
					i--;
					j--;
				}
			}
		}

		System.out.println("체육수업에 참여하는 총 학생 수 : " + (totalStudent - listLost.size()));

		if (scan != null) {
			scan.close();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("총 학생수를 입력하세요. : ");

		getTotalStudent();
	}

}
