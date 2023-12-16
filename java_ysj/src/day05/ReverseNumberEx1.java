package day05;

import java.util.Scanner;

public class ReverseNumberEx1 {

	public static void main(String[] args) {

		/* 정수를 입력받아 입력받은 정수를 거꾸로 출력하는 코드를 작성하시오.
		 * 예
		 * 입력 : 1234
		 * 출력 : 4321
		 * 예
		 * 입력 : 1200
		 * 출력 : 0021
		 * 
		 * 1234 % 10 => 4
		 * 1234 / 10 => 123
		 * 123 % 10 => 3
		 * 123 / 10 => 12
		 * 12 % 10 => 2
		 * 12 / 10 => 1
		 * 1 % 10 => 1
		 * 1 / 10 => 0
		 * */

		int i;
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		String num = sc.nextLine();
		
		for(i=num.length()-1;i>=0;i--) {
			System.out.print(num.charAt(i) + " ");	//문자열로 받아서 문자로 출력
		}
	}

}


