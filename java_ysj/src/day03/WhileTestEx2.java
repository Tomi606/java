package day03;

public class WhileTestEx2 {

	public static void main(String[] args) {

		/* 5부터 1까지 거꾸로 출력하는 코드를 작성하시오.
		 * 5
		 * 4
		 * 3
		 * 2
		 * 1 */
		
		/* 반복횟수 : i가 5부터 1까지 1씩 감소
		 * 규칙성 : i를 콘솔에 출력
		 * 반복문 종료 후 : 없음*/
		
		int i = 5;
		while(i>0) {
			System.out.println(i--);
		}
	}

}
