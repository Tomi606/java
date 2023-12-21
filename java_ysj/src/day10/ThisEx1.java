package day10;

public class ThisEx1 {

	public static void main(String[] args) {

		Point pt1 = new Point();
		pt1.print();
		Point pt2 = new Point(1,2);
		pt2.print();
		
	}

}

//점을 나타내는 Point 클래스
class Point {
	//멤버변수는 자동으로 기본값으로 초기화 되있음
	private int x,y;

	//getter and setter(다른 클래스에서 가져가서 사용)
	public int getX() {
		//여기서 this는 생략 가능
		//x가 다른 변수와 착각할 일이 없기 때문
		return x;
	}

	public void setX(int x) {	//매개변수 x 와 멤버변수 x의 이름이 같다. this를 안붙이면 다 매개변수로 인식
		//여기서는 this를 반드시 써야 함
		//멤버변수 x와 매개변수 x를 구별하기 위해
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	//생성자
	public Point(int x, int y) {
		//super(); 가 생략
		//this(x); &재귀 생성자가 되어 무한루프에 빠짐
		this.x = x;
		this.y = y;
		System.out.println("매개변수 2개 생성자");
	}
	
	//기본 생성자
	public Point() {
		//this()는 항상 첫라인에 와야함(아니면 에러, 공백은 상관X)
		this(0,0);	//x=0, y=0으로 초기화 하기 위해 있는 생성자를 호출
		System.out.println("기본 생성자");
	}
	
	public Point(int x) {
		//this(); &재귀 생성자가 되어 무한루프에 빠짐
		this.x=x;
		
	}
	public void print() {
		System.out.println("(" + x + ", " + y + ")");
	}
}