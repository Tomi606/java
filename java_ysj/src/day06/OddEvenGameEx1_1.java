package day06;
//홀짝 게임
import java.util.Scanner;

public class OddEvenGameEx1_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//아래 코드를 현재 금액이 0이 될때까지 반복하도록 수정
		
		//2. num가 1~100사이의 랜덤한 수를 생성하는 코드 작성
		int min=1, max=100;
		int totalMoney = 10000;	//초기 자금
		
		do {//num이 밖에 있으면 한 숫자만 나온다.
			int num = (int)(Math.random()*(max-min+1)+min);
						
			//5. 사용자가 게임에 투입할 금액을 입력하는 코드(1~현재 금액까지)
			System.out.print("배팅금액(1~"+totalMoney+") : ");
			int money = sc.nextInt();
			
			//7. 입력받은 money 가 totalMoney보다 크면 totalMoney로 수정
			//money = money > totalMoney ? totalMoney : money;
			if(money > totalMoney) {
				totalMoney = money;	//money 를 totalMoney로 넣어줌
			}
			
			//3. 사용자가 0 또는 1을 입력받는 코드 작성 0:짝수, 1:홀수
			System.out.print("0(짝수) 또는 1(홀수)을 입력하세요 : ");
			int user = sc.nextInt();
			
			//1. 정수 num 가 주어졌을때 홀수인지 짝수인지 판별하는 예제
			if(num%2==0) {
				System.out.println(num+"은 짝수");
			}else {
				System.out.println(num+"은 홀수");
				
			}
			
			//4. 사용자가 입력한 값이 맞았는지 틀렸는지를 출력하는 코드
			if(user == num%2) {
				System.out.println("정답");
			}else {
				System.out.println("틀렸습니다");
			}
			
			//6. 승이면 배팅금액을 주고, 패이면 배팅금액을 차감
			if(user == num%2) {
				totalMoney += money;
				System.out.println("총금액은 " + totalMoney);
				System.out.println("================");
			} else {
				totalMoney -= money;
				System.out.println("총금액은 " + totalMoney);
				System.out.println("================");

				
			}
			
			if(totalMoney == 0) {
				System.out.println("G A M E  O V E R");
				System.out.println("================");
			}
			
		}while(totalMoney!=0);
		
		
			 sc.close();
		
	}
}
