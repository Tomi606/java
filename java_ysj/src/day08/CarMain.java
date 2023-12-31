package day08;

import java.util.Scanner;

public class CarMain {

	public static void main(String[] args) {
		
		/* Scanner : 클래스명
		 * sc : 인스턴스명
		 * Scanner(System.in) : 표준입력을 이용하여 초기화 하는 생성자
		 * Scanner("123\nabc") : 문자열을 이용하여 초기화 하는 생성자
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner("123\nabc"); */

		/* Car : 클래스명
		 * car : 인스턴스명
		 * new : 인스턴스를 생성하는 연산자
		 * Car() : 생성자, 멤버변수를 초기화 */
		Car car = new Car();
		car.turn();	//시동을 켬
		car.print();
		car.turnLight(-1);	//좌측 깜박이 킴
		car.print();
		car.turnLight(1);	//우측 깜박이 킴
		car.print();
		car.turnLight(0);	//깜박이 끄기
		car.print();
		for(int i=0;i<10;i++) {	//속력 10
			car.speedUp();
		}
		car.print();
		
		System.out.println("===zip===");
		Car zip = new Car();
		zip.turn();
		zip.turn();
		for(int i=0;i<100;i++) {			
			zip.speedUp();
		}
		zip.turnLight(1);
		zip.print();
	}

}
