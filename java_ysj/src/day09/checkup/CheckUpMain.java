package day09.checkup;

import java.util.Scanner;

public class CheckUpMain {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Human human[] = new Human[5];
		
		
		int menu = 0;
		do {
			printMenu();
			menu = sc.nextInt();
			
			switch(menu) {
			//1. 검진사이트 소개
			case 1 : System.out.println("공단검진과 특수검진이 가능한 검진센터 입니다.");		break;
			
			//2. 검진 종류
			case 2 : 
				healthType();
				int type = sc.nextInt();
				healthByHealthType(type);
				break;
				
			//3. 표준 임상수치 검색
			case 3 : 
				standardResult();
				int search = sc.nextInt();
				searchBystandardResult(search);
				break;
				
			//4. 검사결과 확인
			case 4 : 				
				break;
				
			case 5 : System.out.println("사이트를 나갑니다.");	break;
			
			default : System.out.println("없는 메뉴입니다.");	
			}
			
		}while(menu != 5);
	}
/**
 * 메인메뉴
 */
	public static void printMenu() {
		System.out.println();
		System.out.println("[KH 검진센터]");
		System.out.println("1. 검진사이트 소개");
		System.out.println("2. 검진 종류");
		System.out.println("3. 표준 임상수치 검색");
		System.out.println("4. 검사결과 확인");
		System.out.println("5. 사이트 나가기");
		System.out.print("메뉴 선택 : ");
	}
	/**
	 * [검진종류]
	 */
	public static void healthType() {
		System.out.println("[검진 종류]");
		System.out.println("1. 일반 검진");
		System.out.println("2. 특수 검진");
		System.out.println("메뉴 선택 : ");
	}
	/**
	 * 
	 * @param Type 1. 일반검진  2. 특수검진
	 */
	public static void healthByHealthType(int Type) {
		switch(Type) {
		case 1 : 
			System.out.println("[일반 검진]");
			System.out.println("신체계측, 혈압, 시력, 청력(1000Hz), 채혈, 흉부촬영검사, 소변검사(stick 5종), 구강검사를 하는 일반검진 입니다.");
			System.out.println("매 2년마다 1회 실시(비사무직은 매년 실시)");
			break;
			
		case 2 : 
			System.out.println("[특수 검진]");
			System.out.println("일반 검진에서 추가하여 청력(1000~4000Hz), 심전도 검사, 폐활량 검사를 추가로 검사하는 특수검진 입니다.");
			break;
			
		default : System.out.println("없는 메뉴입니다.");	break;
		}
	}
	/**
	 * [표준 임상수지 검색]
	 */
	public static void standardResult() {
		System.out.println("[표준 임상수치 검색]");
		System.out.println("1. 간기능");
		System.out.println("2. 콜레스테롤");
		System.out.println("3. 당뇨검사");
		System.out.print("메뉴 선택 : ");
		System.out.println();
	}
	/**
	 * 
	 * @param search 1. 간기능  2. 콜레스테롤  3. 당뇨검사
	 */
	public static void searchBystandardResult(int search) {
		switch(search) {
		//간기능
		case 1 :
			System.out.println("[간기능]");
			System.out.println("총단백 : 6.0-8.3g/dl");
			System.out.println("알부민 : 3.5-5.2g/dl");
			System.out.println("AST : 0-32IU/L");
			System.out.println("ALT : 0-34IU/L");
			System.out.println("ALP : 40-150IU/L");
			break;
				//콜레스테롤
		case 2 :
			System.out.println("[콜레스테롤]");
			System.out.println("총콜레스테롤 : 120-199mg/dl");
			System.out.println("HDL-콜레스테롤 : 40-60mg/dl");
			System.out.println("LDL-콜레스테롤 : 50-129mg/dl");
			System.out.println("중성지방 : 50-149mg/dl");
			break;
			//당뇨검사
		case 3 :
			System.out.println("[당뇨검사]");
			System.out.println("공복혈당 : 70-99mg/dl");
			System.out.println("당화혈색소 : 4.4-6.4%");
			break;
			}
	}
	
	
	
	
	
}

