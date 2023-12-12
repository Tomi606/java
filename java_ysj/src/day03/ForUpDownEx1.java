package day03;

import java.util.Scanner;

public class ForUpDownEx1 {

	public static void main(String[] args) {

		/* 숫자 업다운 게임을 작성하시오.
		 * 랜덤으로 생성된 숫자를 맞추는 게임, 1~100
		 * 예시
		 * 랜덤으로 생성된 숫자 : 30
		 * 정수 : 50
		 * Down! 출력
		 * 정수 : 20
		 * Up! 출력
		 * 정수 : 30
		 * 정답!
		 * */
		Scanner sc = new Scanner(System.in);
		
		//랜덤 수 생성
		int min = 1, max = 100;
		int Random = (int)(Math.random() * (max-min+1) + min);
		System.out.println("랜덤 숫자 : "+Random);	//테스트를 하기위해 보이게 함
		int a = min - 1;	//입력한 수의 범위 때문에 min 에서 범위를 맞춤(만약 min 값이 음수이면 0을 대입하면 X)
		
		//반복문 : 조건식만 입력(정수)
		for( ;a!=Random; ) {	//a와 Random이 같지 않을때! 반복
			System.out.print("입력 : ");
			a = sc.nextInt();
			
			if(a>Random) {
				System.out.println("Down!");
			} else if(a<Random) {
				System.out.println("Up!");
			}else {
				System.out.println("정답!");
			}
			//break; 또는 조건식을 쓰지않고 정답이면 break 문을 타고 끝낼 수 있다.
		}
		
	}

}
