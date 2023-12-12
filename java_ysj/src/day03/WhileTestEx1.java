package day03;

public class WhileTestEx1 {

	public static void main(String[] args) {

		/* 1부터 5까지 출력되는 코드를 작성하시오.
		 * 출력예시
		 * 1
		 * 2
		 * 3
		 * 4
		 * 5*/
		
		int i = 1;
		while(i<6) {
			System.out.println(i);
			i++;
		}
		/* 반복횟수 : i가 1부터(=초기화) 5까지 1씩 증가
		 * 규칙성 : i를 콘솔에 출력
		 * 반복문 종료 후 : 없음*/		
		
		/*while(i<6) {
			System.out.println(i++);
		}
		*/
		
		i = 1;
		System.out.println(i++);
		System.out.println(i++);
		System.out.println(i++);
		System.out.println(i++);
		System.out.println(i++);
	}
	


}
