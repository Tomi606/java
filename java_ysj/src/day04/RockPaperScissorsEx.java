package day04;

import java.util.Scanner;

public class RockPaperScissorsEx {

	public static void main(String[] args) {

		/* 다음 기능을 가진 가위, 바위, 보 프로그램을 작성하시오.
		 * 1. 새게임
		 * 2. 기록
		 * 3. 프로그램 종료
		 * 
		 * -새게임
		 * 	-컴퓨터가 랜덤으로 내는 가위, 바위, 보와 내가 입력한 가위, 바위, 보를
		 * 	 비교하여 이기면 승, 지면 패, 비기면 무로 기록함
		 * 	-바위 : r, 보 : p, 가위 : s
		 * -기록
		 * 	-승 무 패를 순서대로 출력 */
		Scanner sc = new Scanner(System.in);
		int menu;
		int r = 1, p = 2, s = 3;
		int userWin = 0, userLose = 0, userDraw = 0;
		
		do {
			System.out.println("[가위 바위 보 게임]");
			System.out.println("1. 새게임");
			System.out.println("2. 기록");
			System.out.println("3. 프로그램 종료");
			System.out.println("메뉴 선택 : ");
			menu = sc.nextInt();
			
			switch(menu) {
			//1. 새 게임
			case 1 : 
				int min = 1, max = 3;
				int com = (int)(Math.random()*(max-min+1)+min);
				int user = sc.nextInt();
				if(com == 1) {
					if(user == 1) {
						System.out.println("draw");
						userDraw++;
					} else if(user == 2) {
						System.out.println("win");
						userWin++;
					} else {
						System.out.println("lose");
						userLose++;
					}
				}
					
				
				
			}
		}while(menu != 3);
	}

}
