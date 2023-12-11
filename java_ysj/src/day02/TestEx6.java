package day02;

import java.util.Scanner;

public class TestEx6 {

	public static void main(String[] agrs) {
		
		/*산술 연산자와 두 정수를 입력받아 산술연산자에 맞는 연산 결과를 출력하는 코드를 작성하시오.
		 * ex1) 두 정수와 연산자 입력(예 : 1 + 2) : 1 + 2
		 * 1 + 2 = 3
		 * ex2) 두 정수와 연산자 입력(예 : 1 / 2) : 1 / 2
		 * 1 / 2 = 0.5
		 * ex3) 두 정수와 연산자 입력(예 : 1 ? 2) : 1 ? 2
		 * ?는 산술 연산자가 아닙니다.*/
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("두 정수와 연산자 입력 (예 : 1 + 2) : ");
		int num1 = sc.nextInt();
		char oper = sc.next().charAt(0);
		int num2 = sc.nextInt();
		
		if(oper == '+') {
			System.out.println(num1 + " " + oper + " " + num2 + " = " + (num1 + num2));
		}else if(oper == '-') {
			System.out.println(num1 + " " + oper + " " + num2 + " = " + (num1 - num2));
		}else if(oper == '*') {
			System.out.println(num1 + " " + oper + " " + num2 + " = " + (num1 * num2));
		}else if(oper == '/') {
			System.out.println(num1 + " " + oper + " " + num2 + " = " + ((double)num1 / num2));
		}else if(oper == '%') {
			System.out.println(num1 + " " + oper + " " + num2 + " = " + (num1 % num2));
		}else {
			System.err.println(oper +"는 산술연산자가 아닙니다.");
		}
		
		sc.close();
	}
}

