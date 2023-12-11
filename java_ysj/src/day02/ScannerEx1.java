package day02;

import java.util.Scanner;

public class ScannerEx1 {

	//콘솔 창에서 정수, 실수, 문자, 문자열을 입력받는 예제
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//정수 입력받는 예제
		System.out.print("정수를 입력하세요 : ");
		int num1 = sc.nextInt();
		System.out.println("입력받은 정수 : " + num1);
		
		//실수 입력받는 예제
		System.out.print("실수를 입력하세요 : ");
		double num2 = sc.nextDouble();
		System.out.println("입력받은 실수 : " + num2);
		
		//문자열 입력받는 예제
		//한 단어를 입력받는 예제
		System.out.print("한 단어를 입력하세요 : ");
		String str1 = sc.next();
		System.out.println("입력받은 단어 : " + str1);	//여러 단어를 쳐도 앞 단어만 가져옴
		
		//한 줄을 입력받는 예제
		System.out.print("한 줄을 입력하세요 : ");
		sc.nextLine(); //실수 다음에 입력한 엔터를 처리!(키보드 엔터 처리과정에서 발생하는 에러)
		String str2 = sc.nextLine();
		System.out.println("입력받은 문장 : " + str2);
		
		//문자를 입력받는 예제
		System.out.print("문자를 입력하세요 : ");
		//"문자열".charAt(인덱스) : 인덱스 번째에 있는 문자를 가져옴, 문장의 앞 단어만 가져옴
		char ch = sc.next().charAt(1);
		System.out.println("입력받은 문자 : " + ch);
		
		sc.close();
	}

}
