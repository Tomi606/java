package day06;

import java.awt.geom.GeneralPath;
import java.util.Scanner;

public class ArithmeticEx1_3 {

	public static void main(String []args) {
				
		/* 랜덤으로 산수(+, -, *) 문제를 생성하여 맞추는 게임
		 * 단, 숫자 범위는 1~99
		 * 1 + 2 = 3(3이 입력된 값)
		 * 정답입니다.
		 */
		
		Scanner sc = new Scanner(System.in);
		//랜덤 숫자생성
		int num1 = (int)(Math.random()*99 + 1);	//각자 넣어야 다른 랜덤 수가 입력됨
		int num2 = (int)(Math.random()*99 + 1);	//int r을 만들어서 r을 대입하면 같은 랜덤 수가 입력됨
		
		//랜덤 연산자 생성(char)
		String opr = "+-*";
		
		//연산자 뽑아서 스위치문
		for(int i=0;i<opr.length();i++) {	//for 문이 있어서 break 문을 빠져나와도 다음 연산자가 나옴
			opr.charAt(i);
			
			switch(i) {
			case 0 : 
				System.out.print(num1 + " + " + num2 + " = ");
				int answer = sc.nextInt();
				if(answer == (num1+num2)) {
					System.out.println("정답입니다");
				} else {
					System.out.println("땡!!!");
				}
				break;
				
			case 1 : 
				System.out.print(num1 + " - " + num2 + " = ");
				answer = sc.nextInt();
				if(answer == (num1-num2)) {
					System.out.println("정답입니다");
				} else {
					System.out.println("땡!!!");
				}
				break;
				
			case 2 : 
				System.out.print(num1 + " * " + num2 + " = ");
				answer = sc.nextInt();
				if(answer == (num1*num2)) {
					System.out.println("정답입니다");
				} else {
					System.out.println("땡!!!");
				}
				break;
			}
		}
		sc.close();
	}
}
