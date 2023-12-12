package day03;
//while 문 예제
public class WhileEx1 {

	public static void main(String[] args) {

		//Hello World 5번 출력
		
		int i = 0;								//초기화
		while(i<5) {							//조건식 : i가 5가 될때 거짓이 된다.
			System.out.println("Hello World!");	//실행문
			i++;								//증감식
		}
	}

}
