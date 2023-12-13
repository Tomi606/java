package day04;
//중첩 반복문
public class MultipleTableEx1 {

	public static void main(String[] args) {

		/* 구구단 2단부터 9단까지 출력하는 코드를 작성하시오.
		 * 반복횟수 : a 은 2부터 9까지 1씩 증가
		 * 규칙성 : a 단을 출력 */
		int a;
		int c = 9;
		for(a=2;a<=c;a++) {
			System.out.println("["+a+"단]");
			for(int i=1;i<=9;i++) {
				System.out.println(a + " X " + i + " = " + (a*i));
			}
			System.out.println();
		}
		
		//2단 출력하는 코드를 작성하시오.
		int b = 2;
		for(int i=1;i<=c;i++) {
			System.out.println(b + " X " + i + " = " + (b*i));
		}
	}

}
