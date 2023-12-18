package day06;

import java.util.Arrays;
import java.util.Scanner;

public class HomeworkManual {

	public static void main(String[] args) {

		/* 숫자 야구게임을 구현하세요.
		 * - 1~9사이의 중복되지 않은 3개의 수를 랜덤으로 선택해서 해당 숫자를 맞추는 게임(로또)
		 * - S : 숫자가 있고, 위치가 같은경우
		 * - B : 숫자가 있지만, 위치가 다른경우
		 * - O : 일치하는 숫자가 하나도 없는경우
		 * -3S가 되면 게임 종료
		 * 
		 * 예시
		 * 랜덤으로 생성된 숫자 : 3 9 1
		 * 입력 : 1 2 3
		 * 결과 : 2B
		 * 입력 : 4 5 6
		 * 결과 : O
		 * 입력 : 7 9 8
		 * 결과 : 1S
		 * 입력 : 3 1 9
		 * 결과 : 1S 2B
		 * 입력 : 3 9 1
		 * 결과 : 3S
		 * 정답입니다.
		 * 
		 * 현재 1등입니다. 이름을 기록하세요.
		 * 이름 : YSJ
		 * 
		 * 메뉴
		 * 1. 새게임
		 * 2. 기록확인
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 2
		 * --기록--
		 * 1. YSJ : 5회
		 * */
		
		//반복문 : 프로그램 종료를 선택하기 전까지 반복
			//메뉴를 출력
		
			//메뉴를 선택
		
			//메뉴 선택에 따른 기능 실행
		
		int menu;
		Scanner sc = new Scanner(System.in);
		int records[] = new int[5];	//2. 기록확인에 쓸 기록배열
		String names[] = new String[5];
		int rankCount = 0;	//현재 몇명이 등록되있는지 확인
		
		//records를 가장 큰값으로 초기화
		for(int i=0;i<records.length;i++) {
			records[i] = Integer.MAX_VALUE;	//정수에서 가장 큰값으로 초기화
		}
		
		do {	//반복문 : 프로그램 종료를 선택하기 전까지 반복

			//메뉴를 출력
			System.out.println("메뉴");
			System.out.println("1. 새게임");
			System.out.println("2. 기록확인");
			System.out.println("3. 프로그램 종료");
			System.out.print("메뉴 선택 : ");			
			//메뉴를 선택
			menu = sc.nextInt();
			//메뉴 선택에 따른 기능 실행
			switch(menu) {
			//1. 새게임
			case 1 : 
				int min=1, max=9;
				int com[] = new int[3];	//3개 출력
				int count = 0;	//저장된 갯수만큼
				int recordCount = 0;
				//랜덤으로 중복되지 않는 3개의 수 생성
				while(count < com.length) {
					
					//랜덤수 생성
					int r = (int)(Math.random()*(max-min+1)+min);
					
					//중복확인(0번부터 시작)
					int i;
					for(i=0;i<count;i++) {
						if(com[i]==r) {
								break;
						}
					}
					
					//중복되지 않으면 저장 후 count++
					if(i==count) {
						com[count++] = r;
					}
				}
				
				//3개 숫자 출력, 게임시 주석 처리
				for(int i=0;i<com.length;i++) {
					System.out.print(com[i]+" ");
				}
				System.out.println();
				
				//반복문 : 맞출때까지 = strike 개수가 3개 미만일 경우 반복(strike가 3개일때 종료), 최소 1번은 실행
				int s,b;
				int user[] = new int[com.length];
				do {
					//중복되지 않은 숫자 3개를 입력받음
					count=0;
					System.out.print("입력 : ");
					while(count < user.length) {
						int input = sc.nextInt();
						int i;
						for(i=0;i<count;i++) {
							if(user[i]==input) {	//중복되면 빠져나옴
									break;
							}
						}
						//중복되지 않으면 저장 후 count++
						if(i==count) {	//중복되지 않은 것
							user[count++] = input;
						}
					}
					//스트라이크와 볼의 개수를 같이 계산(반복문), 0으로 초기화(안하면 누적됨)
					s=0;
					b=0;
					for(int i=0;i<com.length;i++) {
						for(int j=0;j<user.length;j++) {
							if(com[i]==user[j]) {	//수가 같고
								if(i == j) {	//위치도 같으면
									s++;
								}else {			//위치는 다르면
									b++;
								}
							}
						}
					}
					//스트라이크와 볼의 개수에 따른 결과를 출력
					if(s != 0) {
						System.out.print(s + "S");
					}
					if(b != 0) {
						System.out.print(b + "B");
					}
					if(s == 0 && b ==0) {
						System.out.print("O");
					}
					System.out.println();
					recordCount++;
				}while(s < 3);
				//정답입니다. 를 출력(게임 끝)
				System.out.println("정답입니다!");
				//기록을 비교하여 등수에 들면 추가
				//기록이 5개 등록안된 경우나 마지막 기록이 내 기록보다 큰경우
				String name;
				if(rankCount < 5 || records[rankCount -1] > recordCount) {
					records[4] = recordCount;	//마지막에 붙여줌
					//이름때문에 사용 X,	Arrays.sort(records); = 오름차순 정리
					System.out.println("이름 : ");
					name = sc.next();
										
					rankCount = rankCount < 5 ? rankCount + 1 : rankCount;
					int index = 0;
					//현재 기록이 들어갈 위치를 찾음
					for(int i=0;i<rankCount;i++) {
						if(recordCount < records[i]) {
							index = i;
							break;
						}
					}
					//이전 기록들을 뒤로 한칸 씩 민다.
					for(int i = rankCount - 1; i > index; i--) {	//5등은 그냥 덮어쓰기해서 밀필요 X
						records[i] = records[i-1];
						names[i] = names[i-1];
					}
					records[index] = recordCount;
					names[index] = name;
				}
					break;
			
			//2. 기록확인
			case 2 : 
				if(rankCount == 0) {
					System.out.println("기록이 없습니다.");
				} else  {
					for(int i=0;i<rankCount;i++) {
						System.out.println(i+1 + "등 : " + records[i] + "회 - " + names[i]);
					}
				}
				break;
			
			//3. 프로그램 종료
			case 3 : System.out.println("프로그램을 종료합니다.");	break;
				
			//4. 잘못된 메뉴
			default : System.out.println("잘못된 메뉴입니다.");	//밑에는 아무것도 없어서 안붙임
			}
			
		}while(menu != 3);
		sc.close();
	}

}
