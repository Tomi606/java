package day13;
//다른 인스턴스 같은 인터페이스 사용
public class InterfaceEx2 {

	public static void main(String[] args) {
		print(new Product());	//인스턴스를 만들지 않고 출력(1회용)
		print(new Student());
	}

	public static void print(Print p) {
		p.print();
	}
}

interface Print {
	void print();
}

class Product implements Print {

	String name = "TV";
	String code = "TV001";
	
	@Override
	public void print() {
		System.out.println("제품명 : " + name);
		System.out.println("제품코드 : " + code);
	}
	
}

class Student implements Print {

	int grade = 1, classNum = 1, num = 1;
	String name = "홍길동";
	
	@Override
	public void print() {
		System.out.println(grade + "학년 " + classNum + "반 " + num + "번 " + name);
	}
	
	
}