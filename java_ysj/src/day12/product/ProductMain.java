package day12.product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductMain {
	/* 제품을 추가하는 프로그램을 작성하세요
	 * 제품은  Tv, 에어컨, 컴퓨터만 추가 가능
	 * 공통 : 브랜드, 제품코드, 제품명
	 * Tv : 화면크기
	 * 에어컨 : 냉방면적
	 * 컴퓨터 : CPU, 램
	 *  
	 * Tv클래스, 에어컨 클래스, 컴퓨터 클래스
	 * Product 클래스
	 *  
	 * 메뉴
	 * 1. 제품 추가
	 * 2. 제품 확인
	 * 3. 종료
	 * 메뉴 선택 : 1
	 * -----------
	 * 추가할 제품
	 * 1.  TV
	 * 2. 에어컨
	 * 3. 컴퓨터
	 * 제품 선택 : 1
	 * 브랜드 : 삼성
	 * 제품코드 : KQ
	 * 제품명 : 벽걸이형
	 * 화면크기(cm) : 189
	 * 등록이 완료됐습니다.
	 * -----------
	 * 메뉴
	 * 1. 제품 추가
	 * 2. 제품 확인
	 * 3. 종료
	 * 메뉴 선택 : 1
	 * -----------
	 * 추가할 제품
	 * 1.  TV
	 * 2. 에어컨
	 * 3. 컴퓨터
	 * 제품 선택 : 2
	 * 브랜드 : 삼성
	 * 제품코드 : AF
	 * 제품명 : 에어컨 9000
	 * 냉방면적(m2) : 56.9
	 * 등록이 완료됐습니다.
	 * */

	private static Scanner sc = new Scanner(System.in);
	private static Product [] list = new Product[30];
	private static int count = 0;
	
	public static void main(String[] args) {
		
		int menu = 0;
		
		do {
			printMenu();
		try {
			menu = sc.nextInt();
			runMenu(menu);
		} catch(InputMismatchException e) {
			System.out.println("없는 메뉴입니다.");
			return;
		}
		}while(menu != 3);
	}
	
	//런 메뉴
	private static void runMenu(int menu) {
		switch(menu) {
		case 1 : insertProduct();
			break;
			
		case 2 : checkProduct();
			break;
			
		case 3 : System.out.println("프로그램을 종료합니다."); break;
			
		default : throw new InputMismatchException();
		}
	}

	//2. 제품 확인
	private static void checkProduct() {
		for(int i=0;i<count;i++) {
			list[i].print();
		}
	}

	//1. 제품 추가
	private static void insertProduct() {
		printSubmenu();
		int num = sc.nextInt();
		
		System.out.print("브랜드 : ");
		sc.nextLine();
		String brand = sc.nextLine();
		System.out.print("제품코드 : ");
		String code = sc.next();
		System.out.print("제품명 : ");
		sc.nextLine();
		String name = sc.nextLine();
		
		switch(num) {
		case 1 ://tv
			System.out.print("화면크기 : ");
			int size = sc.nextInt();
			Tv tv = new Tv(brand, name, code, size);
			list[count++] = tv;
			break;
			
		case 2 ://에어컨
			System.out.print("냉방면적 : ");
			int area = sc.nextInt();
			Airconditioner aircon = new Airconditioner(brand, name, code, area);
			list[count++] = aircon;

			break;
			
		case 3 ://컴퓨터
			System.out.print("RAM : ");
			int ram = sc.nextInt();
			System.out.print("CPU : ");
			int cpu = sc.nextInt();
			Computer computer = new Computer(brand, code, name, cpu, ram);
			list[count++] = computer;
			break;
			
		default : System.out.println("없는 메뉴입니다.");
		}
	}

	private static void printSubmenu() {
		System.out.println("추가할 제품");
		System.out.println("1. TV");
		System.out.println("2. 에어컨");
		System.out.println("3. 컴퓨터");
		System.out.print("메뉴 선택 : ");
	}

	//메뉴
	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 제품 추가");
		System.out.println("2. 제품 확인");
		System.out.println("3. 종료");
		System.out.println("------------");
		System.out.print("메뉴 선택 : ");
	}

}
