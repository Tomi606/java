package day02;

import java.util.Scanner;

public class TestEx3 {

	public static void main(String[] args) {

		//정수를 입력받아 0인지, 양수인지, 음수인지 판별하는 코드를 작성하시오.
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num == 0) {
			System.out.println("0 입니다.");
		} else if(num > 0) {
			System.out.println(num + "은 양수 입니다.");
		} else {
			System.out.println(num + "은 음수 입니다.");
		}
		
		sc.close();
	}
	

}
