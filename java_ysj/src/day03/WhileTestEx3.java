package day03;

public class WhileTestEx3 {

	public static void main(String[] args) {

		/* 1에서 10사이의 모든 짝수를 순서대로 출력하는 코드를 작성하시오.
		 * 2
		 * 4
		 * 6
		 * 8
		 * 10
		 * */
		
		int i = 1;
		while(i<11) {
			if(i%2==0) {
				System.out.println(i);
			}
			i++;
		}
	}

}
