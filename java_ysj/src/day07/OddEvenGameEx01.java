package day07;

import java.util.Scanner;

public class OddEvenGameEx01 {

	public static void main(String[] args) {

		//반복문 : 프로그램 종료를 선택하기 전까지 반복
		int menu;
		Scanner sc = new Scanner(System.in);
		do {
			//메뉴 출력 : 메소드
			
			//메뉴 선택
			menu = sc.nextInt();
			System.out.println("------------------");
			//선택한 메뉴에 따른 기능 실행
			switch(menu) {
			//새게임(메소드)
			case 1 : 
				break;
				
				//기록확인(메소드)
			case 2 : 
				break;
				
				//프로그램 종료
			case 3 : System.out.println("프로그램 종료"); 
			break;
			
			default : System.out.println("잘못된 메뉴선택");
			}
			
		}while(menu != 3);
		sc.close();
	}
		/* 기능 : 새게임
		 * 매개변수 : int user
		 * 리턴타입 : int
		 * 메소드명 : newGame
		 * */
		public static int newGame() {
			int winCount = 0;
			int loseCount = 0;
			int r = (int)(Math.random()*9 + 1);
			Scanner sc = new Scanner(System.in);
			int user = sc.nextInt();
			if(user==r) {
				System.out.println("성공!");
				winCount++;
			} else {
				System.out.println("실패!");
				loseCount++;
			}
			return user;
		}
			
		/* 기능 : 기록확인
		 * 매개변수 : int record
		 * 리턴타입 : void
		 * 메소드명 : record*/
		public static void record() {
			
		}
		}


