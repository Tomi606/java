package day05;

import java.util.Scanner;

public class ReverseNumberEx1_1 {

	public static void main(String[] args) {

		/* 정수를 입력받아 입력받은 정수를 거꾸로 출력하는 코드를 작성하시오.
		 * 예
		 * 입력 : 1234
		 * 출력 : 4321
		 * 예
		 * 입력 : 1200
		 * 출력 : 0021
		 * 
		 * 1234 % 10 => 4
		 * 1234 / 10 => 123
		 * 123 % 10 => 3
		 * 123 / 10 => 12
		 * 12 % 10 => 2
		 * 12 / 10 => 1
		 * 1 % 10 => 1
		 * 1 / 10 => 0
		 * */
		
		//정수를 입력하여 num에 저장
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		int num = sc.nextInt();
		
		//tmp에 num을 복사
		int tmp = num;
		
		//10개 배열 arr를 선언(넉넉하게)
		int arr[] = new int[10];
		
		//추출되어 저장된 갯수를 의미하는 count 변수를 선언
		int count = 0;
		
		//반복문(tmp가 0이 아닐때까지)
		while(tmp != 0) {
		//tmp를 10으로 나눈 나머지를 배열에 저장 : count 번지에 저장 + count를 1증가
		arr[count++] = tmp % 10;		
			
		//tmp를 10으로 나눈 값을 tmp에 저장(tmp가 0이 될때까지 반복)
		tmp /= 10;
		}
		//반복문을 이용하여 arr에 값을 0번지부터 count개 만큼 출력
		System.out.print("결과 : ");
		for(int i = 0;i<count;i++) {
			System.out.print(arr[i]);
		}
		
		sc.close();
	}

}
