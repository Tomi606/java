package day04;

public class PrimeNumberEx1 {

	public static void main(String[] args) {

		/* 2부터 100사이에 모든 소수를 출력하는 코드를 작성하시오.
		 * 소수 판별 예제 이용 (3일차 : ForPrimeNumberEx1 참고) 
		 * 반복횟수 : num은 2부터 100까지 1씩 증가
		 * 규칙성 : num가 소수이면 num을 출력*/

		int i, count;
		//소수판별예제 구현
		for(int num = 2; num<=100; num++) {	//소수판별예제를 for 문에 집어넣음
			for(i=1, count=0;i<=num;i++) {
			if(num%i==0) {
				count++;
			}
		}
		if(count==2) {
			System.out.print(num + " ");
		}
	}
		
	}
}


