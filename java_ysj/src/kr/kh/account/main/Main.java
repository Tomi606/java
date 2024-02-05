package kr.kh.account.main;

import java.util.Scanner;

import kr.kh.account.controller.AccountController;
//1번
public class Main {

	private static final int EXIT = 2;
	private static AccountController accountController;
	
	public static void main(String[] args) {
		
		int menu;
		Scanner sc = new Scanner(System.in);
		accountController = new AccountController(sc);
		
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
		}while(menu != EXIT);
	}

	private static void printMenu() {
		System.out.println("[가계부 메뉴]");
		System.out.println("1. 가계부 관리");
		System.out.println("2. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}

	private static void runMenu(int menu) {
		switch(menu) {
		case 1 : 
			accountController.run();
			break;
		case 2 : System.out.println("프로그램 종료");
			break;
		default : System.out.println("잘못된 메뉴입니다.");
		}
	}

}
