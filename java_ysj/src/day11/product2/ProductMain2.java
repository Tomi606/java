package day11.product2;

import java.util.Scanner;

import day10.word2.Word;

public class ProductMain2 {

	/* 제품을 관리하는 프로그램을 구현하세요.
	 * 메뉴
	 * 1. 제품 입고(추가와 수정이 섞여있는 기능)
	 * 	- 제품을 판매하기 위해 다른 곳에서 제품을 구매
	 * 2. 제품 판매
	 * 	- 입고된 제품을 판매
	 * 3. 제품 수정[가격만 수정(세일)]
	 * 4. 매출 내역 조회(현재 판매 내역)
	 * 5. 종료
	 * */
	
	private static Scanner sc = new Scanner(System.in);
	private static Product[] list = new Product[10];
	private static Product[] saleList = new Product[10];
	
	private static int count = 0;	//배열에 담긴(저장된) 제품 개수
	private static int saleCount = 0;
	
	
	public static void main(String[] args) {

		int menu = 0;
		do {
			printMenu();
			menu = sc.nextInt();
			
			runMenu(menu);
			
		}while(menu != 5);
	}

	private static void runMenu(int menu) {
		switch(menu) {
		case 1 : 
			storeProduct();
			break;
			
		case 2 : 
			saleProduct();
			break;
			
		case 3 : 
			updateProduct();
			break;
			
		case 4 : 
			printSaleList();
			break;
			
		case 5 : System.out.println("프로그램을 종료합니다.");		break;
			
		default : System.out.println("없는 메뉴입니다.");
		}
	}

	
	//4. 매출 내역 조회
	private static void printSaleList() {
		//반복문 : 전체 매출 내역 조회
		for(int i=0;i<saleCount;i++) {
			//판매 제품 정보 출력
			saleList[i].print();
		}
	}

	//3. 제품 수정
	private static void updateProduct() {
		//제품명 입력
		System.out.print("제품명 : ");
		sc.nextLine();
		String name = sc.nextLine();
		
		//제품 할인 가격 입력
		System.out.println("금액 : ");
		int salePrice = sc.nextInt();
		
		//일치하는 제품의 할인 금액을 수정
		//반복문 : 등록된 제품 전체
		for(int i=0;i<count;i++) {
			//제품의 이름과 제품명이 같으면
			if(list[i].equals(name)) {
				//제품의 할인 금액을 수정 후 종료
				list[i].updateSalePrice(salePrice);
				return;
			}
		}
		//일치하는 제품이 없다고 출력
		System.out.println("일치하는 제품이 없습니다.");
	}

	//2. 제품 판매
	private static void saleProduct() {
		//등록 제품 목록을 출력
		//반복문 : 등록된 제품 전체
		for(int i=0;i<count;i++) {
			//제품 정보를 출력
			list[i].print();
		}
		//제품명 출력
		System.out.print("제품명 : ");
		sc.nextLine();
		String name = sc.nextLine();
		
		//판매 개수를 입력
		System.out.print("수량 : ");
		int amount = sc.nextInt();
		
		//기존 제품의 수량을 변경
		//반복문 : 등록된 제품 전체
		int index = -1;
		for(int i=0;i<count;i++) {
			//제품의 제품명과 판매한 제품명이 같으면
			if(list[i].equals(name)) {
				//번지를 index에 저장
				index = i;
			}
		}
		//1. 일치하는 제품이 없으면(index = -1)
		if(index == -1) {
			//메서드 종료
			System.out.println("일치하는 제품이 없습니다.");
			return;
		}
		
		//2. 일치하는 제품이 있을때
		//2-1. 제품 수량이 입력한 제품 수량보다 작으면(현재 제품 수량 < 입력한 제품 수량)
		if(list[index].getAmount() < amount) {
			//수량이 잘못됐다고 출력
			System.out.println("수량을 확인하세요.");
			//메서드 종료
			return;
		}
		
		//2-2. 제품 수량을 변경(정상 수량)
		list[index].updateAmount(-amount);
		//'-'를 붙여서 개수를 감소시킨다.(메소드 추가없이, '-'만 붙여 재사용)
		
		//매출 내역을 위해 판매 제품 리스트에 추가
		//제품 명과 입력된 제품 수량을 이용하여 인스턴스를 생성
		Product tmp = new Product(name, amount, list[index].getBuyPrice(), list[index].getSalePrice());
		//생성된 인스턴스를 판매 제품 리스트에 추가 + 판매 횟수를 1증가
		saleList[saleCount++] = tmp;
		//list[index] 못 쓰는 이유 : '='로 공유하고 있기 때문에 list[index] 수가 바뀌면 왼쪽 수도 바뀜. tmp은 복사하고 없어짐.
		System.out.println("판매가 등록되었습니다.");
	}
	
	//1. 제품 입고
	//1. 제품 입고
	private static void storeProduct() {
		//제품 정보를 입력
		System.out.print("제품명 : ");
		sc.nextLine();	//엔터처리
		String name = sc.nextLine();
		
		System.out.print("수량 : ");
		int amount = sc.nextInt();
		
		System.out.print("구매 가격 : ");
		int buyPrice = sc.nextInt();
		
		System.out.print("판매 가격 : ");
		int price = sc.nextInt();
		
		//일치하는 제품 정보가 있으면 수량을 누적하고
		for(int i=0;i<count;i++) {
			if(list[i].equals(name)) {
				list[i].updateAmount(amount);
				return;
			}
		}
		//없으면 추가 후 count 증가
		list[count++] = new Product(name, amount, buyPrice, price);
		
		//배열이 다 차면 확장
		if(count == list.length) {
			list = expandList(list);
		}
	}
	
	/**
	 * 주어진 list를 확장하는 메서드
	 * @param list 확장할 메서드
	 * @return 주어진 list에 크기 10만큼 늘어난 배열을 반환
	 */
	//제품 배열 증가, 배열이 여러개(제품목록, 판매목록등)라서 하나의 배열로 쓰기위해 수정(재사용)
	//배열 확장하는 코드
	private static Product[] expandList(Product[] list) {
		Product[] tmpList = new Product[list.length + 10];
		//새 단어장에 기존 단어들을 복붙
		System.arraycopy(list, 0, tmpList, 0, list.length);
		//새 단어장을 내 단어장이라고 선언
		return tmpList;
	}
	
	//메뉴
	private static void printMenu() {
		System.out.println("[메뉴]");
		System.out.println("1. 제품 입고");
		System.out.println("2. 제품 판매");
		System.out.println("3. 제품 수정");
		System.out.println("4. 매출 내역 조회");
		System.out.println("5. 종료");
		System.out.print("메뉴 선택 : ");
	}

}
