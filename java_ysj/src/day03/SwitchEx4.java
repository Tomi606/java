package day03;

import java.util.Scanner;

public class SwitchEx4 {

	public static void main(String[] args) {

		/*산술 연산자와 두 정수를 입력받아 산술연산자에 맞는 연산 결과를 출력하는 코드를 작성하시오.
		 * ex1) 두 정수와 연산자 입력(예 : 1 + 2) : 1 + 2
		 * 1 + 2 = 3
		 * ex2) 두 정수와 연산자 입력(예 : 1 / 2) : 1 / 2
		 * 1 / 2 = 0.5
		 * ex3) 두 정수와 연산자 입력(예 : 1 ? 2) : 1 ? 2
		 * ?는 산술 연산자가 아닙니다.*/
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 2개와 연산자를 입력하세요. (예 : 1 + 2)");
		int a = sc.nextInt();
		char ch = sc.next().charAt(0);
		int b = sc.nextInt();
		
		//" "를 안넣어주면 ch에 해당하는 산술연산자의 아스키코드로 들어간다.
		switch(ch) {
		case '+' :
			System.out.println(a + " " + ch + " " + b + " = " + (a+b));
			break;
			
		case '-' : 
			System.out.println("" + a + ch + b + " = " + (a-b));
			break;
			
		case '*' : 
			System.out.println(a + " " + ch + " " + b + " = " + (a*b));
			break;
			
		case '/' : 
			System.out.println(a + " " + ch + " " + b + " = " + (a/(double)b));
			break;
			
		case '%' : 
			System.out.println(a + " " + ch + " " + b + " = " + (a%b));
			break;
			
		default :
				System.out.println("없는 연산자 입니다.");
				
		}
		
		sc.close();
	}

}
