package day13;

import java.util.Scanner;

public class StringEx2 {
	/* 문장들을 입력받아 배열에 저장하고, 특정 단어가 들어가 있는 문장들을
			 * 출력하는  프로그램을 작성하세요.
			 * 메뉴
			 * 1. 문장 추가
			 * 2. 검색
			 * 3. 종료
			
			 * 안녕하세요.
			 * 테스트
			 * 만나서 반갑습니다.
			 * 나는 홍길동입니다.
			 * 
			 * 나로 검색
			 * 만나서 반갑습니다.
			 * 나는 홍길동입니다. 가 출력 */
	
	private static Scanner sc = new Scanner(System.in);
	private static String list[] = new String[10];
	private static int count = 0;
	
	public static void main(String[] args) {
		
		
		int menu = 0;
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
		}while(menu != 3);
	}
	
	//runMenu
	private static void runMenu(int menu) {
		switch(menu) {
		case 1 : 
			insertString();
			break;
			
		case 2 : 
			searchString();
			break;
			
		case 3 : System.out.println("프로그램을 종료합니다.");
			break;
			
		default : System.out.println("없는 메뉴입니다.");
		}
	}
	
	

	//1. 문장 추가
	private static void insertString() {
		System.out.print("문장 추가 : ");
		sc.nextLine();
		String str = sc.nextLine();
		
		//없는 문장 추가
		list[count++] = new String(str);
	}

	//2. 검색
	private static void searchString() {
		System.out.print("문장 검색 : ");
		sc.nextLine();
		String search = sc.nextLine();
		
		for(String tmp : list) {
			if(tmp != null && tmp.contains(search)) {
				System.out.println(tmp);
			}
		}
	}
	
	//메뉴
	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 문장 추가");
		System.out.println("2. 검색");
		System.out.println("3. 종료");
		System.out.print("메뉴 선택 : ");
	}

}
