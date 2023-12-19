package day08;

public class MethodEx1 {

	public static void main(String[] args) {
		//재귀메소드를 이용하여 스택 오버플로우가 발생하는 예제
		recursive();
		
	}

	public static void recursive() {
		System.out.println("재귀 메소드 입니다.");
		recursive();	//다시 재귀함수를 부름, 메소드 호출 스택이 꽉찰때 까지(StackOverflowError)
	}
}

