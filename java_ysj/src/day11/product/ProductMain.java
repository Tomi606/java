package day11.product;

import java.util.Scanner;

public class ProductMain {

	private static Scanner sc = new Scanner(System.in);
	private static Product list[] = new Product[10];
	private static int count = 0;	//배열에 저장된 제품 개수
	private static int productCount = 1;	//제품 수량
	private static String product;	//제품명
	private static int price;		//가격
	private static int totalPrice;	//총 매출

	public static void main(String[] args) {

		/* 제품을 관리하는 프로그램을 구현하세요.
		 * 메뉴
		 * 1. 제품 입고(추가와 수정이 섞여있는 기능)
		 * 	- 제품을 판매하기 위해 다른 곳에서 제품을 구매
		 * 2. 제품 판매
		 * 	- 입고된 제품을 판매
		 * 3. 제품 수정[가격만 수정(세일 등)]
		 * 4. 매출 내역 조회(현재 판매 내역)
		 * 	-일자별로 조회
		 * 5. 종료
		 * 
		 * 제한사항
		 * -판매할땐 1개씩 팜
		 * */
		
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
			plusProduct();
			break;
			
		case 2 : 
			sellProduct();
			break;
			
		case 3 : 
			updateProduct();
			break;
			
		case 4 : 
			totalProductSellPrice();
			break;
			
		case 5 : System.out.println("프로그램을 종료합니다.");		break;
			
		default : System.out.println("없는 메뉴입니다.");
		}
	}

	//4. 매출 내역 조회
	private static void totalProductSellPrice() {
		System.out.println("총 매출은 " + totalPrice + "원 입니다.");
	}

	//3. 제품 수정(가격)
	private static void updateProduct() {
		System.out.print("수정할 제품 : ");
		product = sc.next();
		System.out.print("수정 가격 : ");
		price = sc.nextInt();
		for(int i=0;i<count;i++) {
			if(list[i].equals(product)) {
				list[i].update(price);
			}
		}
		//수정목록 확인용 코드
		for(int i=0; i<count;i++) {
			System.out.println(product + " " + price + "원");
		}
		System.out.println("가격 수정이 완료되었습니다.");
	}

	//2. 제품 판매
	//물품의 개수 감소 : productCount--;
	//product의 price만큼 매출 증가(누적) -> 메소드?
	private static void sellProduct() {
		int index = -1;
		System.out.print("판매된 제품 : ");
		product = sc.next();
		for(int i=0;i<count;i++) {
			if(list[i].equals(product)) {
			System.out.println(product + "가 판매되었습니다.");	productCount--;
			System.out.println(price + "원 받았습니다.");
			totalPrice += price;
			}
		}
		//일치하는 단어X
		if(index == -1) {
			System.out.println("없는 제품입니다.");
			return;
		}
		//수량이 0개 일때
		if(productCount == 0) {
			System.out.println("제품의 수량이 없습니다.");
		}
	}

	//1. 제품 입고
	//1. 제품 입고
	//제품을 배열에 추가하는 기능	*제품 수량? = productCount
	private static void plusProduct() {
		System.out.print("제품명 : ");
		product = sc.next();
		System.out.print("가격(원) : ");
		price = sc.nextInt();
		
		Product tmp = new Product(product, price, productCount);
		list[count++] = tmp;
		productCount++;
		
		if(count == list.length) {
			expandProductList();
		}
	}
	//배열 증가 코드
	//제품 리스트 배열 늘리는 코드
	private static void expandProductList() {
		Product[] tmpList = new Product[list.length + 10];
		System.arraycopy(list, 0, tmpList, 0, count);
		list = tmpList;
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