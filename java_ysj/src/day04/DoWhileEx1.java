package day04;

import java.util.Scanner;

public class DoWhileEx1 {

	public static void main(String[] args) {

		//q 를 입력하기 전까지 문자를 입력하면 입력받은 문자를 출력하는 예제
		
		Scanner sc = new Scanner(System.in);
		char ch;	//초기화 안함
		
		do {	//조건식 전에 ch 를 받아서 do 식을 실행하기 때문에 ch 를 위에서 초기화 하지 않음
			System.out.print("입력 : ");
			ch = sc.next().charAt(0);
			System.out.println("문자 : " + ch);
		}while(ch != 'q');
	}

}

//왜 무한루프?
/*
Scanner sc = new Scanner(System.in);
char ch = sc.next().charAt(0);	//처음입력받고, 이 값으로 계속 확인해서 무한루프
do {
	System.out.print("입력 : ");
	System.out.println(ch);	//여기서 계속 확인
	System.out.println("출력 : " + ch);
}while(ch != 'q');*/
