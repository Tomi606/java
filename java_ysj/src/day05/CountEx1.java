package day05;

import java.util.Scanner;

public class CountEx1 {

	public static void main(String[] args) {

		/* 1에서 9사이의 정수를 5개 입력받아 각 숫자가 몇개씩 입력 됬는지 출력하는 코드를 작성하시오. 
		 * 1 2 3 1 2
		 * 1 : 2
		 * 2 : 2
		 * 3 : 1
		 * 4 : 0
		 * 5 : 0
		 * 6 : 0
		 * 7 : 0
		 * 8 : 0
		 * 9 : 0
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		int arr[] = new int[5];
		int min=1,max=9;
		int count = 0;	//몇개 입력됬는지 출력
		
		for(int i=0;i<5;i++) {
			int r = (int)(Math.random()*(max-min+1)+min);
			arr[i] = r;
			System.out.print(arr[i]+ " ");
			
		}
		
		//1~9가 몇개인지 count
		
		//i가 몇 count개인지 출력
		for(int i=1;i<=9;i++) {
			switch(i) {
		case 1 :
			System.out.println("1 : " +count);
			
		}
		}
		
		
		
	}

}
