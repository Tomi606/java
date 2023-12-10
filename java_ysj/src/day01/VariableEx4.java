package day01;
//논리형(boolean) 변수 선언 예제
public class VariableEx4 {
	
	public static void main(String []args) {
		
		boolean isEven = true;
		System.out.println(isEven);
		
		//아래 코드는 논리형 변수가 이런식으로 사용한 예제
		isEven = 3%2==0;
		System.out.println("3 is Even number? " + isEven);
		
		isEven = 4%2==0;
		System.out.println("4 is Even number? " + isEven);
		
	}

}
