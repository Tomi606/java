package day03;

public class WhileTestEx3_1 {

	public static void main(String[] args) {

		/* 1에서 10사의 모든 짝수를 순서대로 출력하는 코드를 작성하시오.
		 * 2
		 * 4
		 * 6
		 * 8
		 * 10
		 * */
		
		/* 방법 1
		 * 반복횟수 : i는 2부터 10까지 2씩 증가
		 * 규칙성 : i를 출력
		 * */
		int i = 2;
		while(i<11) {
			System.out.println(i);
			i+=2;
		}
		System.out.println();
		
		/* 방법 2
		 * 반복횟수 : j는 1부터 10까지 2씩 증가
		 * 규칙성 : j가 짝수이면 j를 출력
		 * */
		int j = 1;
		while(j<11) {
			if(j%2==0) {
				System.out.println(i);
			}
			j++;
		}
		System.out.println();

		/* 방법 3
		 * 반복횟수 : k는 1부터 5까지 1씩 증가
		 * 규칙성 : 2*k를 출력
		 * */
		int k = 1;
		while(k<6) {//k<n/2
			System.out.println(k*2);
			k++;
		}
	}

}
