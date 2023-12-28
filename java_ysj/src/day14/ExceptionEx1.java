package day14;

public class ExceptionEx1 {

	public static void main(String[] args) {
		int num1 = 1, num2 = 0;
		
		try {
		//ArithmeticException 발생 : 0으로 나누어서
		System.out.println(num1 / num2);
		}
		//ArithmeticException의 부모인 RuntimeException이 위에 오면 안됨.(catch는 위에서부터 확인하니까)
		/*catch(RuntimeException e) {	
		}*/
		catch(ArrayIndexOutOfBoundsException e) {	//Arith와 형제 클래스(조상 X)
			System.out.println("잘못된 번지 입니다.");
		}
		catch(ArithmeticException e) {	//ArithmeticException의 조상 클래스 RuntimeException
			System.out.println("0으로 나누면 안됩니다.");
		}catch(Exception e) {	//모든 예외처리 클래스 조상
			System.out.println("모든 예외를 처리합니다.");
		}
		System.out.println("프로그램을 종료합니다.");
	}

}
