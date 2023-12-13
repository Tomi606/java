package day04;

import java.util.Scanner;

public class InfiniteLoopEx2 {

	public static void main(String[] args) {

		//부등호 조심
		Scanner sc = new Scanner(System.in);
		int num;
		//조건식에 사용하는 변수가 증감하지 않아 무한루프가 발생하는 예제
		for(int i=10;i>0; ) {	//증감을 실수로 빼서 
			System.out.print("정수 입력 : ");
			num = sc.nextInt();
			System.out.println("정수 출력 : " + num);
		}
		//i에 따라 조건식 true로 될수도 있기 때문에 이코드가 에러가 발생하지 않음
		System.out.println("프로그램 종료");	//조건식이 true가 아니므로 에러가 나지 않음	
		
		
		//위 코드와 차이는 위에는 무한루프, 이 코드는 무수히 많이 실행
		//i가 증가를 하다가 int 양수 표현범위를 넘어가면, 오버플로우가 발생해서 음수가 되는데 이때 반복문이 종료
		for(int i=10;i>0;i++) {	//증감을 실수로 빼서 
			System.out.print("정수 입력 : ");
			num = sc.nextInt();
			System.out.println("정수 출력 : " + num);
		}

	}

}
