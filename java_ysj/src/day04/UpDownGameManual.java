package day04;

import java.util.Scanner;

public class UpDownGameManual {

	public static void main(String[] args) {

		/* Up Down 게임을 구현하시오. 
		 * - 다음과 같은 메뉴를 가져야 합니다.
		 * 1. 새게임
		 * 2. 최고기록 확인
		 * 3. 프로그램 종료
		 * 
		 * -새게임은 업다운 게임을 시작
		 * 	-랜덤으로 생성된 수를 맞추는 게임
		 * 	-맞췄을 때 맞춘 횟수를 출력하고 메뉴로 돌아감
		 * -최고기록 확인은 업다운 게임을 하면서 맞춘 횟수 중 가장 적은 횟수를 알려줌 */
		
		Scanner sc = new Scanner(System.in);
		int menu; //메뉴 
		int count, bestCount = -1;	//여기서 count를 초기화하면 누적이됨. 게임 플레이 횟수, 최고기록
		//-1을 하는 이유? -1일경우 게임이력이 없습니다 라고 출력(플레이했을때 나올수 없는 수)
		int r;	//랜덤 수
		int num;	//입력한 정수
		int min = 1, max = 100;	//랜덤 수 범위
		//1. 반복문
		do {
			//메뉴출력
			System.out.println("================");
			System.out.println("[Up Down Game]");
			System.out.println("1. 새게임");
			System.out.println("2. 최고기록 확인");
			System.out.println("3. 프로그램 종료");
			System.out.println("================");
			System.out.print("메뉴 선택 : ");
			//메뉴선택
			menu = sc.nextInt();
			//선택한 메뉴에 따라 기능을 실행
			switch(menu) {
			//1번메뉴 선택
			case 1 : 
				//업다운 게임을 실행
				//랜덤 수 생성
				r = (int)(Math.random() * (max - min + 1) + min);
				System.out.println("랜덤 숫자 : " + r);
				//반복문
				count = 0;	//초기화
				do {
					//정수 입력
					System.out.println("입력 : ");
					num = sc.nextInt();	
					//입력횟수를 1증가
					//입력한 정수와 랜덤한 수 비교후 Up/Down/정답 출력
					if(num<r) {
						System.out.println("Up!");
						count++;
					}else if(num>r) {
						System.out.println("Down!");
						count++;
					}else {
						System.out.println("정답!");
						count++;
					}
				}while(num != r);
				//현재기록 출력
				System.out.println("기록 : " + count);
				//게임이 끝났으면 현재 횟수가 최고기록 횟수보다 좋으면
				if(bestCount == -1 || count < bestCount) {
					//최고 기록횟수를 현재횟수로 수정
					bestCount = count;
				}
				break;
			//2번메뉴 선택
			case 2 : 
				//최고기록을 출력
				if(bestCount == -1) {
					System.out.println("플레이한 기록이 없습니다.");
					break;
				}	//else 안써도 됨
				System.out.println("최고 기록 : " + bestCount);
				break;
			//3번메뉴 선택
			case 3 : 
				//프로그램 종료
				System.out.println("프로그램 종료");				
				break;
			}
		}while(menu != 3);
	}
}
