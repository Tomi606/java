package day15;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapEx2 {

	private static Scanner sc = new Scanner(System.in);
	private static Map<String, String> join = new HashMap<String, String>();
	private static Set<String> search = join.keySet();
	
	public static void main(String[] args) {
		/* 회원을 관리하는 프로그램을 작성하세요. 
		 * 메뉴
		 * 1. 회원가입(put)
		 * 	- 아이디와 비번만 입력 받음
		 * 	- 이미 가입된 회원인지 체크(containsKey)
		 * 2. 회원검색(get)
		 * 	- 아이디를 입력해서 회원 정보를 조회
		 * 3. 종료
		 * */
		
		int menu;
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
			
		}while(menu != 3);
	}

	//메뉴선택
	private static void runMenu(int menu) {
		switch(menu) {
		case 1 :
			printJoin();
			break;
			
		case 2 :
			printSearch();
			break;
			
		case 3 : System.out.println("프로그램 종료"); break;
		
		default : System.out.println("없는 메뉴입니다.");
		}
	}

	//2.회원검색(get)
	private static void printSearch() {
		for(String tmp : search) {
			String pw = join.get(tmp);
			System.out.println(tmp + ", " + pw);
		}
	}

	//1.회원가입(put)
	private static void printJoin() {
		System.out.print("아이디 : ");
		sc.nextLine();
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		join.put(id, pw);
		System.out.println("---가입 완료---");
		System.out.println();
	}

	//메뉴
	private static void printMenu() {
		System.out.println("1. 회원가입");
		System.out.println("2. 회원검색");
		System.out.println("3. 종료");
		System.out.print("메뉴 선택 : ");
	}

}
