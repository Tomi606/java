package day12.product2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductMain {
	
	static Scanner sc = new Scanner(System.in);
	static Product [] list = new Product[30];
	static int count = 0;
	
	public static void main(String[] args) {
		
		int menu = 0;
				
		do {
			printMenu();
		try {
			menu = sc.nextInt();
			runMenu(menu);
		} catch(InputMismatchException e) {
			System.out.println("없는 메뉴입니다.");
		}
		}while(menu != 3);
	}
	
		//런 메뉴
		private static void runMenu(int menu) {
			switch(menu) {
			case 1 : insertProduct();
				break;
				
			case 2 : printProduct();
				break;
				
			case 3 : System.out.println("프로그램을 종료합니다."); break;
				
			default : throw new InputMismatchException();
			}
		}
 
		//1. 제품 추가
		private static void insertProduct() {
			//제품 목록 출력
			printProductTitle();
			//공통 정보
			int select = sc.nextInt();
			System.out.print("브랜드 : ");
			sc.nextLine();
			String brand = sc.nextLine();
			System.out.print("제품명 : ");
			String title = sc.nextLine();
			System.out.print("제품코드 : ");
			String code = sc.next();
			
			//제품마다 추가 정보 입력
			switch(select) {
			case 1 : //tv
				System.out.print("화면크기 : ");
				int size = sc.nextInt();
				list[count++] = new Tv(brand, code, title, size);
				break;
				
			case 2 : //에어컨
				System.out.print("냉방면적 : ");
				double area = sc.nextDouble();
				list[count++] = new Aircon(brand, code, title, area);
				break;
				
			case 3 : //노트북
				System.out.print("CPU : ");
				int cpu = sc.nextInt();
				System.out.print("RAM : ");
				int ram = sc.nextInt();
				list[count++] = new Notebook(brand, code, title, cpu, ram);
				break;
				
			default : System.out.println("잘못된 제품입니다.");
					return;
			}
			System.out.println("등록이 완료되었습니다.");
		}
		
		private static void printProductTitle() {
			System.out.println("추가할 제품");
			System.out.println("1. TV");
			System.out.println("2. 에어컨");
			System.out.println("3. 컴퓨터");
			System.out.println("---------");
			System.out.print("메뉴 선택 : ");			
		}

		
		
		//2. 제품 확인
		private static void printProduct() {
			if(count == 0) {
				System.out.println("등록된 제품이 없습니다.");
				return;
			}
			
			for(int i=0;i<count;i++) {
				list[i].print();
			}
		}

		//메뉴
		private static void printMenu() {
			System.out.println("메뉴");
			System.out.println("1. 제품 추가");
			System.out.println("2. 제품 확인");
			System.out.println("3. 종료");
			System.out.println("---------");
			System.out.print("메뉴 선택 : ");
		}

}
