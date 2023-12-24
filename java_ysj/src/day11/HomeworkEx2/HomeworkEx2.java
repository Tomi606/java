package day11.HomeworkEx2;

import java.util.Scanner;

/* 두 정수와 산술 연산자를 입력받아 결과를 출력하는 코드를 작성하세요.
 * 메서드를 생성 */

public class HomeworkEx2 {

	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Operator opr = new Operator();
		
		System.out.println("두 정수 입력 : ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		System.out.println("산술 연산자(+, -, *, /, %) 입력 : ");
		char ch = sc.next().charAt(0);
		
		switch(ch) {
		case '+' : opr.plus(num1, ch, num2);	break;
			
		case '-' : opr.subtract(num1, ch, num2);break;
			
		case '*' : opr.times(num1, ch, num2);	break;
			
		case '/' : opr.divide(num1, ch, num2);	break;
			
		case '%' : opr.remain(num1, ch, num2);	break;
			
		default : System.out.println("없는 산술 연산자 입니다.");
		}
	}
}
