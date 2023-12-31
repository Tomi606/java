package day12;

public class AbstractEx1 {

	public static void main(String[] args) {
		//추상 클래스 예제
		//AA 추상 클래스는 추상메서드가 없지만 추상 클래스를 이용하여 인스턴스를 생성할 수 없음
		//AA aa1 = new AA();	에러 발생
		
		//추상 클래스의 인스턴스를 만들려면 익명 클래스를 이용하거나(AA() {}; 부분이 1회용 클래스)
		AA aa1 = new AA() {};
		
		//추상 클래스를 상속받은 일반 클래스를 생성해서 인스턴스를 생성(업캐스팅)
		//CA 인스턴스를 부모클래스의 aa2에 저장하는 업캐스팅을 통해 인스턴스 생성
		AA aa2 = new CA();
		
		DA da1 = new DA();
		da1.print();
	}

}

abstract class AA {
	int num=0;
}

abstract class AB {
	int num=1;
	public abstract void print();	//{}대신 ;만 
}

class CA extends AA {
	
}

//추상메서드가 있어서 extends 에러 남
class DA extends AB {
	//오버라이딩함
	@Override
	public void print() {
		System.out.println("num : " + num);
	}
	
}