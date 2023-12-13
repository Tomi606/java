package day04;

import java.util.Scanner;

public class UpDownGame {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int menu;
		int count, bestCount = -1;
		
		do {
			System.out.println("[Up Down Game]");
			System.out.println("1. 새게임");
			System.out.println("2. 최고기록 확인");
			System.out.println("3. 프로그램 종료");
			System.out.print("메뉴 선택 : ");
			menu = sc.nextInt();
			
		//1. 새게임
		if(menu == 1) {
			int min = 1, max = 100;
			int r = (int)(Math.random() * (max - min + 1) + min);
			System.out.println("랜덤 숫자 : " + r);	//게임시는 주석처리
			int num = min - 1;
		
		for( ;num != r; ) {
			System.out.print("숫자를 입력 : ");
			num = sc.nextInt();		
			count = 0;
			
			if(num<r) {
				System.out.println("Up!");
				count++;
			}else if(num>r) {
				System.out.println("Down!");
				count++;
			}else {
				System.out.println("정답!");
			}
			if(bestCount == -1 || count<bestCount) {
				bestCount = count;
				break;
			}
		}
	}
		//2. 최고기록 확인
		if(menu == 2) {
			System.out.println("현재 최고기록은 " + bestCount + "점 입니다.");
			
		}
		
			}while(menu != 3);
		System.out.println("프로그램 종료");
		
	}

}
