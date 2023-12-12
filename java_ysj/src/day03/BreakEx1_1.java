package day03;

import java.util.Scanner;

public class BreakEx1_1 {

	public static void main(String[] args) {

		//문자를 입력해서 입력한 문자를 출력하고, q 를 입력하면 종료하는 예제
		
		Scanner sc = new Scanner(System.in);
		
		char ch = 'a';
		while(true) {	//무한루프
			System.out.print("문자 입력 : ");
			ch = sc.next().charAt(0);
			System.out.println("문자 : " + ch);
			
			if(ch=='q') {	//if문 없이 혼자 브레이크잇으면 하나치고 끝남
				break;	//q일때 브레이크 문
			}
		}
		sc.close();
	}

}
