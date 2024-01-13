package day18.socket1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import lombok.AllArgsConstructor;

@AllArgsConstructor
//클라이언트 클래스는 소켓을 가짐, 오브젝트 인,아웃풋 스트림을 사용하려면 "소켓.겟 인아웃풋 스트림"을 사용해서
public class Client {
	private Socket socket;
	/*
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
			}
		}); */
	
	//람다식 이용(이용안하면 Runnable 생성해서 오버라이드로 run 메서드 생성해야 함.(위))
	public void receive() {	//받는 메서드
		Thread t = new Thread(()->{
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(socket.getInputStream()); //한줄로 만듦
				while(true) {
					String str = ois.readUTF();	//읽어옴
					if(str.equals("-1")) {		//str(문자열)이 -1이면 break
						break;
					}
					System.out.println(str);
				}
				System.out.println("읽기 기능이 정상 종료됩니다.");
			} catch (Exception e) {
				System.out.println("예외가 발생해서 읽기 기능을 종료합니다.");
			}
		});
		t.start();	//쓰레드 실행
		
		
	}
	
	//보내는 메서드
	public void send() {
		Thread t = new Thread(()-> {
			ObjectOutputStream oos = null;
			try{
				oos = new ObjectOutputStream(socket.getOutputStream());
				Scanner sc = new Scanner(System.in);
				while(true) {
					String str = sc.nextLine();
					oos.writeUTF(str);
					oos.flush();	//마지막 문장들 밀어주기
					if(str.equals("-1")) {
						break;
					}
				}
				System.out.println("보내기 기능이 정상 종료됩니다.");
			} catch (IOException e) {
				System.out.println("예외가 발생해서 보내기 기능을 종료합니다.");
			}
		});
		t.start();	//send 메서드 안에서 시작
	}
	
}
