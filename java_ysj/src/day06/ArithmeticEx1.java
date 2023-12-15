package day06;

import java.util.Scanner;

public class ArithmeticEx1 {

	public static void main(String[] args) {

		/* 랜덤으로 산수(+, -, *) 문제를 생성하여 맞추는 게임
		 * 단, 숫자 범위는 1~99
		 * 1 + 2 = 3(3이 입력된 값)
		 * 정답입니다.
		 * 
		 * 2 * 3 = 5(5가 입력된 값)
		 * 틀렸습니다.*/
		
		Scanner sc = new Scanner(System.in);
		
		//숫자 랜덤
		int num1 = (int)(Math.random()*(99-1+1)+1);
		int num2 = (int)(Math.random()*(99-1+1)+1);
		
		//연산자 랜덤
		int arith = (int)(Math.random()*(3-1+1)+1);
		
		switch(arith) {
		
		case 1 :
			System.out.print(num1 + " + " + num2 + " = ");
			int answer = sc.nextInt();
			if(answer == (num1+num2)) {
				System.out.println("정답입니다.");
			}else {
				System.out.println("틀렸습니다.");
			}
			break;
			
		case 2 :
			System.out.print(num1 + " - " + num2 + " = ");
			answer = sc.nextInt();
			if(answer == (num1-num2)) {
				System.out.println("정답입니다.");
			}else {
				System.out.println("틀렸습니다.");
			}
			break;
			
		default :
			System.out.print(num1 + " * " + num2 + " = ");
			answer = sc.nextInt();
			if(answer == (num1*num2)) {
				System.out.println("정답입니다.");
			}else {
				System.out.println("틀렸습니다.");
			}
			break;
		}
		
		sc.close();
	}

}


