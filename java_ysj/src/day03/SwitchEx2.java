package day03;

import java.util.Scanner;

//swich 문 예제
public class SwitchEx2 {

	public static void main(String[] args) {

		//입력받은 정수의 홀짝 판별 예제
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요.");
		int num1 = sc.nextInt();
		int num2 = num1 % 2;
		
		
		switch(num2) {
		case 1 :
			System.out.println("홀수 입니다.");
			break;
			
		default :
			System.out.println("짝수 입니다.");
		}
		
		sc.close();
	}

}

/*
 * switch(num%2) {
		case 1 :
			System.out.println("홀수 입니다.");
			break;
			
		default :
			System.out.println("짝수 입니다.");
		}
		
		sc.close();*/