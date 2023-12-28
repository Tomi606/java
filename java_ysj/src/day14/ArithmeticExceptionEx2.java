package day14;

import java.text.MessageFormat;
import java.util.Scanner;

public class ArithmeticExceptionEx2 {

	public static void main(String[] args) {
		//두 정수와 산술연산자를 입력받아 결과를 출력하는 메서드를 구현하세요.
		//메서드 이용, throws와 throw를 이용
		try {
		Scanner sc = new Scanner(System.in);
		System.out.print("두 정수 입력 : ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		System.out.print("산술연산자 입력 :");
		char opr = sc.next().charAt(0);
		double res = calculate(num1, opr, num2);
		String pattern = "{0} {1} {2} = {3}";
		System.out.println(MessageFormat.format(pattern, num1, opr, num2, res));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static double calculate(int num1, char opr, int num2) 
		throws RuntimeException {	//생략가능
		switch(opr) {
		case '+' : return num1 + num2;
		case '-' : return num1 - num2;
		case '*' : return num1 * num2;
		case '/' : 
			if(num2 == 0) {
				throw new ArithmeticException("0으로 나눌 수 없습니다.");
			}
			return num1 / (double)num2;
		case '%' :
			if(num2 == 0) {
				throw new ArithmeticException("0으로 나눌 수 없습니다.");
			}
			return num1 % num2;
		default : 
			throw new RuntimeException(opr + "는 산술 연산자가 아닙니다.");
		}
	}
}