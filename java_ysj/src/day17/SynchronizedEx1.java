package day17;

import lombok.AllArgsConstructor;
import lombok.Data;

public class SynchronizedEx1 {

	public static void main(String[] args) {
		//하나의 통장을 2명이 사용, 1명은 atm, 1명은 폰뱅크
		BankBook bb = new BankBook(0, null);
		Customer c1 = new Customer(bb, "홍길동");
		Customer c2 = new Customer(bb, "고길동");
		
		Thread t1 = new Thread(()->{
			c1.run();
		});
				
		Thread t2 = new Thread(()->{
			c2.run();
		});
				
		t1.start();
		t2.start();
	}

}
@AllArgsConstructor
class Customer extends Thread {
	private BankBook bankBook;
	private String name;
	
	@Override
	public void run() {
		System.out.println("입금 중 : " + name);
		bankBook.deposit(10000);
	}
}

@Data
@AllArgsConstructor
//통장
class BankBook {
	private int balance;
	private String name;
	
	//입금, **synchronized -> 누가 사용하고 있으면 기다린다
	public synchronized void deposit(int money) {
		this.balance += money;
		
		try {
			//2초 동안 현재쓰레드를 일시중지
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("이름 : " + this.name);
		System.out.println("잔액 : " + this.balance);
	}
}