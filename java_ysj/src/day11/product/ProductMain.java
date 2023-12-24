package day11.product;

import java.util.Scanner;

public class ProductMain {

	private static Scanner sc = new Scanner(System.in);
	private static Product list[] = new Product[10];
	private static int count = 0;	//배열에 있는 물품개수
	
	private static Product saleList[] = new Product[10];
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
			
		case 5 : System.out.println("시스템을 종료합니다.");	break;
			
		default : System.out.println("없는 메뉴입니다.");
		}
	}
	
	//4. 매출 내역 조회
	private static void printSaleList() {
		for(int i=0;i<saleCount;i++) {
			saleList[i].print();
		}
	}

	//3. 제품 수정(가격만 수정)
	private static void updateProduct() {
		System.out.print("제품명 : ");
		sc.nextLine();
		String name = sc.nextLine();
		
		System.out.print("할인 가격 : ");
		int salePrice = sc.nextInt();
		
		for(int i=0;i<count;i++) {
			if(list[i].equals(name)) {
				list[i].updateSalePrice(salePrice);
				return;
			}
		}
		System.out.println("일치하는 제품이 없습니다.");
	}

	//2. 제품 판매
	private static void saleProduct() {
		for(int i=0;i<count;i++) {
			list[i].print();
		}
		
		System.out.print("제품명 : ");
		sc.nextLine();
		String name = sc.nextLine();
		
		System.out.print("수량 : ");
		int amount = sc.nextInt();
		
		//기존 제품의 이름과 동일한 제품이면
		int index = -1;
		for(int i=0;i<count;i++) {
			if(list[i].equals(name)) {
				index = i;
			}
		}
		
		//일치 X
		if(index == -1) {
			System.out.println("일치하는 제품이 없습니다.");
			return;
		}
		
		//일치 O(현재 개수보다 더 많은 개수이면)
		if(list[index].getAmount() < amount) {
			System.out.println("수량을 확인하세요.");
			return;
		}
		
		//일치 O(사려는 개수만큼 뺌)
		list[index].updateAmount(-amount);
		Product tmp = new Product(name, amount, list[index].getBuyPrice(), list[index].getSalePrice());
		saleList[saleCount++] = tmp;
		System.out.println("판매가 등록되었습니다.");
	}

	//1. 제품 입고(추가와 수정기능)
	private static void storeProduct() {
		System.out.print("제품명 : ");
		sc.nextLine();
		String name = sc.nextLine();
		
		System.out.print("수량 : ");
		int amount =sc.nextInt();
		
		System.out.print("구매 가격 : ");
		int buyPrice = sc.nextInt();
		
		System.out.println("판매 가격 : ");
		int price = sc.nextInt();
		
		//일치하는 제품(수량증가)
		for(int i=0;i<count;i++) {
			if(list[i].equals(name)) {
				list[i].updateAmount(amount);
				return;
			}
		}
		
		//없는 제품(list에 추가)
		list[count++] = new Product(name, amount, buyPrice, price);
		
		//배열 확장
		if(count == list.length) {
			list = expandList(list);
		}
	}

	//배열 확장 코드
	private static Product[] expandList(Product[] list) {
		Product[] tmplist = new Product[list.length + 10];
		System.arraycopy(list, 0, tmplist, 0, list.length);
		return tmplist;
	}

	//메뉴
	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 제품 입고");
		System.out.println("2. 제품 판매");
		System.out.println("3. 제품 수정");
		System.out.println("4. 매출 내역 조회");
		System.out.println("5. 종료");
		System.out.print("메뉴 선택 : ");
	}

}
