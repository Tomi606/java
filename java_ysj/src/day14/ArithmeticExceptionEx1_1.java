package day14;

import java.util.Scanner;

public class ArithmeticExceptionEx1_1 {

	public static void main(String[] args) {
		//두 정수와 산술 연산자를 입력받아 산술연산하는 코드를 작성하세요.
		//던, 0으로 나눌 때 예외처리를 적용
		
		Scanner sc = new Scanner(System.in);
		System.out.print("두 정수 입력 : ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		System.out.print("산술연산자 입력 :");
		char ch = sc.next().charAt(0);
		
		switch(ch) {
		case '+' : System.out.println("" + num1 + ch + num2 + " = " + (num1 + num2));
			break;
			
		case '-' : System.out.println("" + num1 + ch + num2 + " = " + (num1 - num2));
			break;
		
		case '*' : System.out.println("" + num1 + ch + num2 + " = " + (num1 * num2));
			break;
			
		case '/' : try {
			System.out.println("" + num1 + ch + num2 + " = " + (num1 / num2));}
					catch (ArithmeticException e) {
						System.out.println("0으로 나누면 안됩니다!!!");
					}
			break;
			
		case '%' : System.out.println("" + num1 + ch + num2 + " = " + (num1 % num2));
			break;
			
		default : System.out.println("없는 연산자 입니다.");
		}
	}
}
