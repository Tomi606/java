package day04;

import java.util.Scanner;

public class RockPaperScissorsExManual {

	public static void main(String[] args) {

		/* 다음 기능을 가진 가위, 바위, 보 프로그램을 작성하시오.
		 * 1. 새게임
		 * 2. 기록 확인
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
		int random;
		char user, com;	//사용자, 컴퓨터가 낸 가위 바위 보
		int win = 0, draw = 0, lose = 0;
		
		do {
			//메뉴 출력
			System.out.println("---------------");
			System.out.println("[가위 바위 보 게임]");
			System.out.println("1. 새 게임");
			System.out.println("2. 기록 확인");
			System.out.println("3. 프로그램 종료");
			System.out.println("---------------");
			System.out.print("메뉴 선택 : ");
			//메뉴 선택
			menu = sc.nextInt();
			//선택한 메뉴에 맞는 기능 실행
			switch(menu) {
			case 1 :
				//랜덤으로 1~3사이의 숫자 생성
				random = (int)(Math.random()*(3) + 1); //3=3+1-1
				//1이면 r, 2이면 p, 3이면 s로 판별
				com = (random == 1? 'R' :( random == 2? 'P' : 'S'));
				//사용자가 r,p,s 중 하나 입력
				System.out.print("가위(S), 바위(R), 보(P) 입력 : ");
				user = sc.next().charAt(0);
				//사용자가 낸 가위바위보와 컴퓨터가 낸 가위바위보를 비교
				//비김
				if(user == com) {
					System.out.println("유저 : "+user+" VS 컴퓨터 : "+com);
					System.out.println("draw");
					draw++;
				}
				//승
				else if((user == 'R' && com == 'S') 
						|| (user == 'S' && com == 'P')
						|| (user == 'P' && com == 'R')) {
					System.out.println("유저 : "+user+" VS 컴퓨터 : "+com);
					System.out.println("win");
					win++;
				}
				//패
				else {
					System.out.println("유저 : "+user+" VS 컴퓨터 : "+com);
					System.out.println("lose");
					lose++;
				}
				break;
				
			case 2 : 
				//승 무 패 기록 출력
				System.out.println(win+"승 " +draw+"무 "+lose+"패");
				break;
				
			case 3 : System.out.println("프로그램 종료");
				break;
				
			default : 
				System.out.println("잘못된 메뉴를 선택했습니다.");
			}
		}while(menu != 3);
	}

}
