package day02;
//산술 연산자 예제
public class ArithmeticOperatorEx1 {

	public static void main(String[] args) {

		int num1 = 1, num2 = 2;
		System.out.println(num1 + " + " + num2+ " = " + (num1 + num2));	//괄호를 쳐줘야 인식함
		System.out.println(num1 + " - " + num2+ " = " + (num1 - num2));
		System.out.println(num1 + " * " + num2+ " = " + (num1 * num2));
		System.out.println(num1 + " / " + num2+ " = " + (num1 / num2));	//정수 / 정수 = 정수
		System.out.println(num1 + " / " + num2+ " = " + (num1 / (double)num2));	//정수 / 실수 = 실수
		System.out.println(num1 + " % " + num2+ " = " + (num1 % num2));
		//나누기(/)와 나머지(%) 연산자의 특징은 0으로 나눌 수 없다. 예외가 발생할 수 있다.
		
		num2 = 0;
		//정수, 0은 예외 발생
		//System.out.println(num1 + " / " + num2+ " = " + (num1 / num2));
		//실수, 0.0은 예외가 발생하지 않고, Infinity로 계산 된다.
		System.out.println(num1 + " / " + num2+ " = " + (num1 / (double)num2));

	}

}
 