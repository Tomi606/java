package day13;
//인터페이스 - 기능을 모아놈
public interface Program {
	int num1 = 10;	//변수 앞에 자동으로 final static이 자동으로 추가(상수로만 사용가능하기 때문, 상수는 항상 초기화해야 함)
	final static int num2 = 20;
	//메서드 앞에 public abstract가 자동으로 추가
	void printMenu();
	public void runMenu(int menu);
	public abstract void printExit();	//종료시 안내문구
	void run();	//프로그램 실행
}

abstract class TestA {
	//클래스에서는 final static을 생략하면 멤버변수, 붙여주면 상수
	int num1 = 10;
	final static int num2 = 20;
	//클래스에서는 추상 메서드에 abtract가 자동으로 추가되지 않음
	public abstract void printMenu();
}