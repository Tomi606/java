package day05;

import java.util.Scanner;

public class ThirtyOneEx1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//31을 부르면 진다
		int count = 0;
		
		while(count < 31) {
			//com
			//랜덤으로 1~3개의 숫자를 부른다
			int com = (int)(Math.random()*3 + 1);
			int end = com + count;
			end = end>=31? 31 : end;
			
			//현재숫자부터 랜덤으로 생성된 숫자입력
			System.out.print("com : ");
			for(int i=count+1;i<=end;i++) {
				System.out.print(i + " ");
			}
			System.out.println();
			
			count = end;
			if(count==31) {
				System.out.println("유저 승");
				break;
			}
				
			//user
			//정수 1~3 중 하나를 쳐서 숫자를 부른다
			System.out.print("정수 입력 : ");
			int user = sc.nextInt();
			
			end = user + count;
			end = end>=31? 31 : end;
			
			System.out.print("사용자 : ");
			for(int i=count+1;i<=end;i++) {
				System.out.print(i + " ");
			}
			System.out.println();
			
			count=end;
			if(count==31) {
				System.out.println("컴퓨터 승");
				break;
			}
			
		}
		
	}

}
