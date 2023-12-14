package day04;

import java.util.Scanner;

public class UpDownGamePractice {

	public static void main(String[] args) {

		//up down game
		/* 1. 새 게임
		 * 2. 최고기록
		 * 3. 시스템 종료 */
		
		Scanner sc = new Scanner(System.in);
		
		int menu = 0, num, count, bestCount = -1;
		int min =1, max=100;
		
		//메뉴
		do {
			System.out.println("==========");
			System.out.println("1. 새 게임");
			System.out.println("2. 최고기록");
			System.out.println("3. 시스템 종료");
			System.out.println("==========");
			System.out.print("메뉴 선택 : ");
			menu = sc.nextInt();
			System.out.println();
			
		switch(menu) {
		
		//1. 새게임(업다운 실행)
		case 1 : 
			count=0;	//게임 시작시 초기화(안해주면 누적됨)
			int r = (int)(Math.random()*(max-min+1)+min);
			System.out.println("랜덤 숫자 : " +r);	//게임실행시 주석
			
			do {
				System.out.print("숫자 입력 : ");
				num = sc.nextInt();
			
				if(num>r) {
				System.out.println("down");
				System.out.println();
				count++;
			}
			else if(num<r) {
				System.out.println("up");
				System.out.println();
				count++;
			}
			else {
				System.out.println("정답");
				System.out.println();
				count++;
				
				if(bestCount==-1 || count<bestCount) {
					bestCount = count;
					break;
				}
			}	
			}while(num != r);
			
			
		//2. 최고기록
		case 2 : 
			if(bestCount == -1) {
				System.out.println("현재 최고기록이 없습니다.");
				System.out.println();
				break;
			}
			System.out.println("현재 최고기록은 "+bestCount+"점 입니다.");
			System.out.println();
			break;
			
		//3. 시스템 종료
		case 3 :
			System.out.println("시스템을 종료합니다.");
			break;
			
		default :
			System.out.println("잘못 입력하였습니다.");
			System.out.println();
			break;
		}
		
		}while(menu != 3);
	}

}
