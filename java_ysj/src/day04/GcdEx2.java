package day04;

public class GcdEx2 {
//Gcd : 최대공약수 약자
	public static void main(String[] args) {

		/* 두 정수의 공약수를 출력하는 코드를 작성하시오.
		 * 약수 : 나누어서 떨어지는 수
		 * 공약수 : 공통으로 있는 약수
		 * 12의 약수 : 1, 2, 3, 4, 6, 12
		 * 8의 약수 : 1, 2, 4, 8
		 * 8과 12의 공약수 : 1, 2, 4
		 * 공약수가 출력되도록 코드 작성 
		 * 반복횟수 : i 는 1부터 num1까지
		 * 규칙성 : i 가 num1의 약수이고, i 가 num2의 약수이면 i 를 출력
		 * 		=>num1을 i 로 나누었을때 나머지가 0과 같고,
		 * 		  num2를 i 로 나누었을때 나머지가 0과 같다면 i 를 출력
		 * 반복문 종료 후 : 없음 */
		
		int num1 = 8, num2 = 12;
		int i;
		System.out.print(num1 + " 과 " + num2 + "의 공약수는 ");
		//i 가 num1,2의 약수일 동안
		for(i=1;i<=num1 && i<=num2; i++) {
			//num1,2를 i 로 나누었을때 나머지가 0이 될때의 i 를
			if(num1%i==0 && num2%i==0) {
				//i(약수)를 출력
				System.out.print((i==1?"" : ", ") + i);
				System.out.print(" 입니다.");
			}
		}
	}

}
