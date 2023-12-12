package day03;

public class ForEx2 {

	public static void main(String[] args) {

		/* 1에서 10사이에 짝수들의 합을 구하는 코드를 작성하시오. */
		
		/* 반복횟수 : i는 1부터 10까지 1씩 증가
		 * 규칙성 : i를 2로 나누었을때 나머지가 0과 같다면
		 * 		  sum = sum + i를 출력
		 * 반복문 종료 후 : sum을 출력
		 * */
		//초기화에 i를 선언하면 i는 반복문 밖에서 사용할 수 없다. 사용하려면 재선언을 해야함.
		int sum = 0;
		for(int i=1;i<11;i++) {
			if(i%2==0) {
				sum += i;
			}
		}
		System.out.println(sum);	//for문 바깥에 있어야함	
	}
}
