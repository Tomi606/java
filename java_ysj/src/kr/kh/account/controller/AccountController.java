package kr.kh.account.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import kr.kh.account.model.vo.Category;
import kr.kh.account.model.vo.Item;
import kr.kh.account.model.vo.Type;
import kr.kh.account.service.AccountService;
import kr.kh.account.service.AccountServiceImp;
//2번
public class AccountController {
	
	private Scanner sc;
	//controller는 service에게 일을 시킴, 하지만 모두 service에게 시키는 건 아님
	private AccountService accountService;
	
	//Scanner을 무분별하게 만드는 것을 방지하기 위해 만듦.
	public AccountController (Scanner sc) {
		if(sc == null) {
			sc = new Scanner(System.in);
		}
		this.sc = sc;
		accountService = new AccountServiceImp();
	}

	public void run() {
		int menu;
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
		}while(menu != 5);
	}

	private void printMenu() {
		System.out.println("[가계부]");
		System.out.println("1. 내역 입력");
		System.out.println("2. 내역 수정");
		System.out.println("3. 내역 삭제");
		System.out.println("4. 내역 조회");
		System.out.println("5. 이전");
		System.out.print("메뉴 선택 : ");
	}

	private void runMenu(int menu) {
		switch(menu) {
		case 1 : insertAccount();
			break;
		case 2 : updateAccount();
			break;
		case 3 : deleteAccount();
			break;
		case 4 : selectAccount();
			break;
		case 5 : System.out.println("이전으로 돌아갑니다.");
			break;
		default : System.out.println("없는 메뉴입니다.");
		}
	}

	private void selectAccount() {
		System.out.println("날짜를 입력하세요(yyyy-MM-dd 또는 yyyy-MM 또는 yyyy) : ");
		String date = sc.next();
		List<Item> itemList = accountService.getItemListByDate(date);
		if(itemList == null || itemList.size() == 0) {
			System.out.println("조회할 내역이 없습니다.");
			return;
		}
		for(Item tmp : itemList) {
			System.out.println(tmp);
		}
	}

	private void deleteAccount() {
		System.out.println("날짜를 입력하세요(yyyy-MM-dd) : ");
		String date = sc.next();
		List<Item> itemList = accountService.getItemListByDate(date);
		
		if(itemList == null || itemList.size() == 0) {
			System.out.println("수정할 내역이 없습니다.");
			return;
		}
		for(Item item : itemList) {
			System.out.println(item);
		}
		System.out.print("삭제할 내역 번호를 선택하세요 : ");
		int it_num = sc.nextInt();
		//입력한 내역 변호가 잘못된 값인지 확인
		if(!itemList.contains(new Item(it_num))) {
			System.out.println("잘못된 내역 번호입니다.");
			return;
		}
		if(accountService.deleteItem(it_num)) {
			System.out.println("내역을 삭제했습니다.");
		} else {
			System.out.println("내역을 삭제하지 못했습니다.");
		}
	}

	private void updateAccount() {
		System.out.print("날짜를 입력하세요(yyyy-MM-dd) : ");
		String date = sc.next();
		//service에게 리스트 요청
		List<Item> itemList = accountService.getItemListByDate(date);
		//list가 비었거나 사이즈가 0일 때
		if(itemList == null || itemList.size() == 0) {
			System.out.println("수정할 내역이 없습니다.");
			return;
		}
		//수정할 내역이 있으면 수정 가능한 내역을 출력
		for(Item item : itemList) {
			System.out.println(item);
		}
		System.out.print("내역 번호를 선택하세요 : ");
		int it_num = sc.nextInt();
		//입력한 내역 변호가 잘못된 값인지 확인
		if(!itemList.contains(new Item(it_num))) {
			System.out.println("잘못된 내역 번호입니다.");
			return;
		}
		try {
			//item에는 기본키를 제외한 나머지가 들어가 있다.
			Item item = inputItem();
			item.setIt_num(it_num);
			if(accountService.updateItem(item)) {
				System.out.println("내역 수정이 완료되었습니다.");
			} else {
				System.out.println("내역을 수정하지 못했습니다.");
			}
		} catch (ParseException e) {
			System.out.println("날짜를 잘못 입력하여 내역을 수정하지 못했습니다.");
		}
	}

	private Item inputItem() throws ParseException {
		//수입/지출 선택
		List<Type> typeList = accountService.getTypeList();
		for(int i=0;i<typeList.size();i++) {
			System.out.print(typeList.get(i).getTy_name());
			if( i != typeList.size() - 1) {
				System.out.print("/");
			}
		}
		System.out.print(" 중 하나를 입력하세요.");
		String type = sc.next();
		
		//카테고리 선택 - type을 통해 카테고리를 가져옴
		List<Category> categoryList = accountService.getCategoryList(type);
		for(Category category : categoryList) {
			System.out.println(category);
		}
		//분류가 안뜸*** 이유 : MySQL을 실행하지 않고 자바를 실행해서
		System.out.println("분류를 선택하세요 : ");
		int categoryNum = sc.nextInt();
		//날짜
		System.out.println("날짜를 입력하세요(yyyy-MM-dd) : ");
		String date = sc.next();
		//금액
		System.out.println("금액을 입력하세요 : ");
		int money = sc.nextInt();
		//내용
		sc.nextLine();
		System.out.println("내용을 입력하세요 : ");
		String content = sc.nextLine();
														//type : 수입/지출
		return new Item(categoryNum, date, money, content, type);
	}
	
	private void insertAccount() {
		try {
			Item item = inputItem();
			if(accountService.insertItem(item)) {
				System.out.println("내역을 추가했습니다.");
			} else {
				System.out.println("내역을 추가하지 못했습니다.");
			}
		} catch (ParseException e) {
			System.out.println("날짜 형식이 잘못됐습니다.");
		}
	}
}
