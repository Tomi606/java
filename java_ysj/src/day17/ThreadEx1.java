package day17;

public class ThreadEx1 {

	public static void main(String[] args) {
		//추가적인 스레드없이 싱글로 사용한 경우 : 출력 후 출력
		for(int i=0;i<50;i++) {
			System.out.print("-");
		}
		for(int i=0;i<50;i++) {
			System.out.print("+");
		}
		System.out.println();
		
		//멀티 쓰레드로 쓰레드1은 - 출력, 쓰레드2는 출력
		Thread1 t1 = new Thread1();
		t1.start();
		
		//Thtread2 tmp = new Thread2();
		//Thread t2 = new Thread(tmp);
		
		
		Thread t2 = new Thread(new Thread2());
		t2.start();
	}

}

class Thread1 extends Thread {
	//첫번째 스레드 클래스
	@Override
	public void run() {
		for(int i=0;i<50;i++) {
			System.out.print("-");
		}
	}
}

class Thread2 implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<50;i++) {
			System.out.print("+");
		}
	}
	
}