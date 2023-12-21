package day10;

public class StaticEx1 {

	public static void main(String[] args) {

		KiaCar c1 = new KiaCar("모닝");
		KiaCar c2 = new KiaCar("레이");
		KiaCar c3 = new KiaCar("K3");

		//static이 없는 경우
		//KiaCar에서 brand는 static이 아니기 때문에 인스턴스마다 brand를 수정해야 함
		c1.brand = "기아";
		c1.print();
		c2.print();
		c3.print();
		System.out.println();
		
		KiaCar2 c4;
		//인스턴스가 생성되기 전에 static 변수인 brand는 이미 메모리에 올라가 있어서 사용할 수 있다.(인스턴스 없이 사용가능)
		System.out.println(KiaCar2.brand);
		c4 = new KiaCar2("모닝");
		KiaCar2 c5 = new KiaCar2("레이");
		KiaCar2 c6 = new KiaCar2("K3");

		//static이 있는 경우
		//KiaCar2에서 brand는 static이 있기 때문에 모든 인스턴스가 바뀜
		
		//c1.brand = "기아";		//인스턴스를 통해 접근이 가능하지만 
		KiaCar2.brand = "기아"; //static은 클래스명을 통해 접근해야 함
		c4.print();
		c5.print();
		c6.print();
		System.out.println();
		
		System.out.println("대표적인 static변수 Math.PI" + Math.PI);
		
	}

}

//static이 없는 경우
class KiaCar {
	public String brand = "KIA";	//명시적 초기화
	public String name;	//차 이름
	
	public KiaCar(String name) {
		this.name = name;
	}
	
	public void print() {
		System.out.println(brand);
		System.out.println("차 이름 : " + name);
	}
}


//static이 있는 경우
class KiaCar2 {
	public static String brand = "KIA";
	//static이 없는경우
	public String name;	//차 이름
	
	public KiaCar2(String name) {
		this.name = name;
	}
	
	public void print() {
		System.out.println(brand);
		System.out.println("차 이름 : " + name);
	}
}