package day03;

import java.util.Scanner;

public class LoopEx1 {

	public static void main(String[] args) {

		//문자를 입력받아 입력받은 문자를 출력하고, q 를 입력하면 종료하는 예제
		//->증감식 쓸필요 X, 제약없음
		
		Scanner sc = new Scanner(System.in);
		char ch = 'a';
		
		//식을 생략하면 무한 루프
		for( ;ch!='q'; ) {
			System.out.print("입력 : ");
			ch = sc.next().charAt(0);
			System.out.println("문자 : " + ch);
		}
		
		sc.close();
	}

}
