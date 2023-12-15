package day06;
//홀짝 게임
import java.util.Scanner;

public class OddEvenGameEx1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//2. num가 1~100사이의 랜덤한 수를 생성하는 코드 작성
		int min=1, max=100;
		int num = (int)(Math.random()*(max-min+1)+min);
		int totalMoney = 10000;	//초기 자금
		
		int useMoney = 0;
		//5. 사용자가 게임에 투입할 금액을 입력하는 코드(1~현재 금액까지)		
		if(useMoney>0) {
			System.out.print("투입할 금액을 입력 : ");			
			useMoney = sc.nextInt();
		} else{
			System.out.println("잔액이 부족합니다.");
		}
		
		//3. 사용자가 0 또는 1을 입력받는 코드 작성 0:짝수, 1:홀수
		System.out.print("0(짝수) 또는 1(홀수)을 입력하세요 : ");
		int user = sc.nextInt();
		
		//1. 정수 num가 주어졌을때 홀수인지 짝수인지 판별하는 예제
		if(num%2==0) {
			System.out.println(num+"은 짝수");
		}else {
			System.out.println(num+"은 홀수");

		}
		
		//4. 사용자가 입력한 값이 맞았는지 틀렸는지를 출력하는 코드
		/* 유저가 홀수선택
		 * -랜덤이 홀수가 나오면 정답
		 * -아니면 틀림
		 * 유저가 짝수선택
		 * -랜덤이 짝수가 나오면 정답
		 * -아니면 틀림*/
		switch(user) {
		
		case 0 : 
			if(user==num%2) {	//짝수를 0으로 정한이유
				System.out.println("정답");
			}
			else {
				System.out.println("틀렸습니다");
			}
			break;
			
		case 1 : 
			if(user==num%2) {	//홀수를 1으로 정한이유
				System.out.println("정답");
			}
			else {
				System.out.println("틀렸습니다");
			}
			break;
			
			/*
			 * if(user == num%2) {
			 * 	System.out.println("정답");
			 * }else {
			 * 	System.out.println("틀렸습니다");
			 * }*/
		}
		sc.close();
		
	}
}
