package day10;

public class StaticEx2 {

	public static void main(String[] args) {
		//1
		System.out.println(sum1(1,2));
		
		//2
		//System.out.println(sum2(1,2)); //에러발생
		StaticEx2 ex = new StaticEx2();
		System.out.println(ex.sum2(1, 2));
	}
	
	//1. 클래스 메서드 - 인스턴스없이 호출 가능
	public static int sum1(int num1, int num2) {
		return num1 + num2;
	}
	/* 클래스 메서드 안에서
	 * 클래스 변수를 사용할 수 있다
	 * 객체 메서드를 직접 호출X(객체 생성 후는 가능)
	 * 클래스 메서드는 객체가 */
	
	//2. 인스턴스(객체) 메서드 - static이 없기때문에 인스턴스가 반드시 필욘
	public int sum2(int num1, int num2) {
		return num1 + num2;
	}
	
	//인스턴스(객체) 메서드 : static X, 1과2 사용가능
	public void test() {
		System.out.println(sum1(1,2));
		System.out.println(sum2(1,2));
	}
}
