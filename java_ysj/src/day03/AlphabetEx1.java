package day03;

public class AlphabetEx1 {

	public static void main(String[] args) {

		/* a 부터 z 까지 반복문을 이용하여 출력하는 코드를 작성하시오.
		 * 반복횟수 : ch는 a 부터 z 까지 1씩 증가
		 * 규칙성 : ch 를 출력 */
		
		//아스키코드
		for(char a=97; a<123; a++) {
			
			System.out.println(a);
		}
		
		System.out.println("=============");
		char ch;
		for(ch = 'a'; ch<='z'; ch++) {
			
			System.out.print(ch + (ch == 'z'? "\n" : ", "));
		}
	}

}
