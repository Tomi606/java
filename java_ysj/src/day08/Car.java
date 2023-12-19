package day08;

/* 자동차
 * -정보
 * 	-무게, 브랜드, 분류(소,중,대), 색상, 바퀴 종류, 차명, 연식
 * 
 * -기능
 * 	-가속(엑셀),감속(브레이크), 시동(on/off) */

public class Car {

	//-정보 : 멤버변수
		//-무게 : 단위는 톤, 브랜드, 분류, 색상, 바퀴, 차명, 연식
	double weight;
	String brand;
	//분류 -> 0:소형, 1:중형, 2:대형, 3:화물, 4:세단
	String category;
	int color;		//색상값 : 0xff0000 -> 16진수로 표현
	String Color;	//문자열로 표현
	String [] tires;	//바퀴는 여러개니까 배열
	String carName;
	int year;
	boolean power; //시동이 켜져있는지 꺼져있는지 나타내는 멤버변수
	int speed;	   //현재 속력
	boolean leftLight;	//왼쪽 깜박이
	boolean rightLight;	//오른쪽 깜박이
	
	//-기능 : 메소드
		//-가속(엑셀),감속(브레이크), 시동(on/off), 깜빡이(좌,우 / 켜기,끄기)
	
	//시동 켜기 / 끄기
	//시동이 꺼져있으면 켜짐, 시동이 켜져있으면 꺼짐
	public void turn() {	//매개변수 X, 이미 위에서 boolean power로 선언(이미 알고있어서 매개변수로 넣어줄 필요없다)
		power = !power;		//꺼져있으면 켜지고, 켜져있으면 꺼짐
		if(power) {
			System.out.println("시동이 켜졌습니다.");
		}else {
			System.out.println("시동이 꺼졌습니다.");
		}
	}
	
	//가속
	public void speedUp() {
		speed++;
	}
	//감속
	public void speedDown() {
		speed--;
	}
	
	//좌측|우측 깜박이 켜기/끄기, 위:우측(1)-가운데(0)-아래:좌측(-1)
	public void turnLight(int direction) {
		switch(direction) {
		case 1 : rightLight = true; leftLight = false; break;
		case -1 : rightLight = false; leftLight = true; break;
		case 0 : rightLight = false; leftLight = false; break;
		}
	}
	
	//자동차 현재 상태를 출력하는 메소드
	public void print() {
		System.out.println("--------------");
		System.out.println("시동 : " + power);
		System.out.println("속력 : " + speed);
		System.out.println("좌깜 : " + leftLight);
		System.out.println("우깜 : " + rightLight);
		System.out.println("--------------");
	}
}
