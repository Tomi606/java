package day07;

import java.util.Scanner;

public class OddEvenGameManual {

	public static void main(String[] args) {

		/* 다음 기능을 가진 프로그램을 작성하시오. 메소드 사용
		 * --------------
		 * 메뉴
		 * 1. 새게임
		 * 2. 결과조회
		 * 3. 프로그램 종료
		 * 메뉴선택 : 1
		 * --------------
		 * 선택(홀:1, 짝:0) : 1
		 * 3 홀입니다.
		 * 성공!(틀리면 실패!)
		 * --------------
		 *  메뉴
		 * 1. 새게임
		 * 2. 결과조회
		 * 3. 프로그램 종료
		 * 메뉴선택 : 2
		 * --------------
		 * 결과 : 1승 0패
		 * --------------
		 *  메뉴
		 * 1. 새게임
		 * 2. 결과조회
		 * 3. 프로그램 종료
		 * 메뉴선택 : 3
		 * --------------
		 * 프로그램 종료*/
		
		//반복문 : 프로그램 종료를 선택하기 전까지 반복
		int menu;
		Scanner sc = new Scanner(System.in);
		int win = 0, lose = 0;
		do {
			//메뉴 출력 : 메소드
			printMenu();
			//메뉴 선택
			menu = sc.nextInt();
			System.out.println("------------------");
			//선택한 메뉴에 따른 기능 실행
			switch(menu) {
			//새게임(메소드)
			case 1 : 
				//승이면 true, 패면 false만 오게 만듦
				boolean result = newGame();	
				if(result) {
					System.out.println("승!");
					win++;
				}else {
					System.out.println("패!");
					lose++;
				}
				break;
				
			//기록확인(메소드)
			case 2 : 
				printRecord(win, lose);
				break;
				
			//프로그램 종료
			case 3 : System.out.println("프로그램 종료"); 
				break;
			
			default : System.out.println("잘못된 메뉴선택");
			}
			//메뉴 선택
		
			//선택한 메뉴에 따른 기능 실행
			
		}while(menu != 3);
		
		sc.close();
	}

		/* 기능 : 메뉴를 출력하는 메소드
		 * 매개변수 : 없음
		 * 리턴타입 : 없음
		 * 메소드명 : printMenu */
		public static void printMenu() {
			System.out.println("--------------");
			System.out.println("메뉴");
			System.out.println("1. 새 게임");
			System.out.println("2. 결과 조회");
			System.out.println("3. 프로그램 종료");
			System.out.print("메뉴 선택 : ");
		}
		
		/* 기능 : 랜덤으로 숫자를 생성하고, 정수(홀,짝)를 입력받아
		 * 		 홀짝을 맞추고 승패를 알려주는 메소드 
		 * 매개변수 : 없음
		 * 리턴타입 : 승(true)/패(false) -> boolean
		 * 메소드명 : newGame */
			public static boolean newGame() {
			//랜덤으로 정수 생성
			int r = random(1, 100);
			//정수를 입력 받음(0,1)
			Scanner sc = new Scanner(System.in);
			System.out.print("선택(홀:1, 짝:0) : ");
			int user = sc.nextInt();
			System.out.println(r + " " + (r%2==0?"짝" : "홀") + "입니다.");
			//판별
			return r % 2 == user;
		}
			
		/* 기능 : 승 홋수와 패 횟수가 주어지면 a승 b패로 출력하는 메소드 
		 * 매개변수 : 승 횟수, 패 횟수 -> int win, int lose
		 * 리턴타입 : 없음
		 * 메소드명 : printRecord
		 * */
			
		public static void printRecord(int win, int lose) {
			System.out.println(win + "승 " + lose + "패");
		}
		
		/* 기능 : min ~ max 사이의 랜덤한 수를 생성해서 알려주는 메소드
		 * 매개변수 : 최소값과 최댓값 -? int min, int max
		 * 리턴타입 : 생성된 랜덤한 수 -> 정수 -> int
		 * 메소드명 : random */
		public static int random(int min, int max) {
			if(max < min) {	//맥스값이 민값보다 작을때
				int tmp = max;
				max = min;
				min = tmp;
			}
			return (int)(Math.random()*(max-min+1)+min);
		}
}