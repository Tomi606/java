package day05;

import java.util.Scanner;

public class ThirtyOneEx1 {

	public static void main(String[] args) {

		/* 사용자와 컴퓨터가 돌아가면서 최대 3개의 숫자를 부르고,
		 * 31을 입력한 사용자 또는 컴퓨터가 지는 게임 
		 * 예
		 * com : 1 2 3
		 * 정수 : 2(user가 2입력)
		 * user : 4 5
		 * com : 6
		 * 정수 : 3(user가 3입력)
		 * user : 7 8 9
		 * . . .
		 * com : 31 */
		
		int min = 1, max = 3;
		int num = 1; //사용자의 갯수
		int r; //컴퓨터의 갯수
		
		//end가 31이 되지않을 동안
		while(num != 31) {
			
		//com
		//1~31까지 순서대로 부르되, 1~3개씩만 말할 수 있다.
			System.out.print("com : "/* + 1 2 3*/);
		r = (int)(Math.random()*(max-min+1)+min);
		
		switch(r) {
		case 1 :
			num++;
			System.out.println(num);
			break;
		case 2 : 
			for(int i=1;i<=r;i++) {				
				System.out.print(num++ +" ");
			}
			break;
		case 3 : 
			for(int i=1;i<=r;i++) {				
				System.out.print(num++ +" ");
			}
		}
		
		//user
		Scanner sc = new Scanner(System.in);
		System.out.print("\n정수 : ");
		num = sc.nextInt();	
		
		switch(num) {
		case 1 :
			
			break;
		case 2 : 
			break;
		case 3 : 
			break;
		default : 
			System.out.println("3개 초과로 적을 수 없습니다.");
		}
		}
	}

}
