package day06;

import java.util.Scanner;

public class ArithmeticEx1_2 {

	public static void main(String[] args) {

		/* 랜덤으로 산수(+, -, *) 문제를 생성하여 맞추는 게임
		 * 단, 숫자 범위는 1~99
		 * 1 + 2 = 3(3이 입력된 값)
		 * 정답입니다.
		 * 
		 * 2 * 3 = 5(5가 입력된 값)
		 * 틀렸습니다.*/
		int min=1, max=99;
		//정수1을 랜덤으로 생성 1~99
		int num1 = (int)(Math.random()*(99-1+1)+1);
		//정수2를 랜덤으로 생성 1~99
		int num2 = (int)(Math.random()*(99-1+1)+1);
		//정수3(연산자)를 랜덤으로 생성 1~3
		int oprNum = (int)(Math.random()*3);	//str의 length에 넘어가기 때문에 +1은 안붙인다
		
		Scanner sc = new Scanner(System.in);
		int user, answer = 0;
		
		String str = "+-*";
		char opr = str.charAt(oprNum);
		
		System.out.print("" + num1 + opr + num2 + " = ");
		user = sc.nextInt();
		
		//정답을 계산(switch)
		switch(opr) {
		case '+' : answer = num1 + num2;	break;	
		case '-' : answer = num1 - num2;	break;	
		case '*' : answer = num1 * num2;	break;	
		default : System.out.println("잘못된 연산자 입니다.");
		}
		
		
		//정답 확인
		if(user == answer) {
			System.out.println("정답");
		}else {
			System.out.println("틀림");
		}
		
		
		sc.close();
	}

}


