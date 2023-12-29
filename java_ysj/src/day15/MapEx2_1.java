package day15;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapEx2_1 {

	private static Scanner sc = new Scanner(System.in);
	private static Map<String, String> map = new HashMap<String, String>();
	private static Set<String> search = map.keySet();
	
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
		
		int menu = 0;
		do {
			printMenu();
			try {
			menu = sc.nextInt();
			runMenu(menu);	//**2. 밑에 코드를 출력해줌
			}catch (InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				sc.nextLine();	//잘못 입력된 값을 문자열로 가져와서 버림(전에 입력했던거 비워줌)
			}
			
		}while(menu != 3);
	}

	//메뉴선택
	private static void runMenu(int menu) {
		switch(menu) {
		case 1 :
			insertMember();
			break;
			
		case 2 :
			searchMember();
			break;
			
		case 3 : System.out.println("프로그램 종료"); break;
		
		default : throw new InputMismatchException();	//**1. 오류가 발생하면
		}
	}

	//1. 회원가입
	private static void insertMember() {
		//아이디를 입력
		System.out.print("아이디 : ");
		String id = sc.next();
		
		//map에 아이디가 있는지 확인
		//있으면 이미 있는 아이디라고 출력하고 메서드 종료
		if(map.containsKey(id)) {	//if(map.get(id) != null)
			System.out.println("이미 가입된 아이디입니다.");
			return;
		}
		
		//없으면 비번 입력(이줄까지 왔다는건 위에서 걸러져서 왔다는 뜻)
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		//map에 추가
		map.put(id, pw);
	}

	//2.회원검색
	private static void searchMember() {
		//아이디 입력
		System.out.print("아이디 : ");
		String id = sc.next();
		
		//아이디, 비번을 출력
		//비번을 가져옴
		String pw = map.get(id);
		
		//가져온 비번이 null이면 없는 회원이라고 출력
		if(pw == null) {
			System.out.println("등록되지 않은 아이디 입니다.");
			return;
		}
		
		//아니면 아이디, 비번을 출력
		System.out.println("아이디 : " + id + ", 비번 : " + pw);
	}

	//메뉴
	private static void printMenu() {
		System.out.println("1. 회원가입");
		System.out.println("2. 회원검색");
		System.out.println("3. 종료");
		System.out.print("메뉴 선택 : ");
	}

}
