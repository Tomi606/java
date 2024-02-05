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
		case 2 : //updateAccount();
			break;
		case 3 : //deleteAccount();
			break;
		case 4 : //selectAccount();
			break;
		case 5 : System.out.println("이전으로 돌아갑니다.");
			break;
		default : System.out.println("없는 메뉴입니다.");
		}
	}

	private void insertAccount() {
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
		
		try {
			Item item = new Item(categoryNum, date, money, content);
			if(accountService.insertItem(item, type)) {
				System.out.println("내역을 추가했습니다.");
			} else {
				System.out.println("내역을 추가하지 못했습니다.");
			}
		} catch (ParseException e) {
			System.out.println("날짜 형식이 잘못됐습니다.");
		}
	}
}
