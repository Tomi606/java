package day17.socket2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientEx2 {

	public static void main(String[] args) {
		//서버의 ip, port 번호 설정
		String ip = "192.168.30.189";
		int port = 5001;
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = null;
		
		//1. ip와 port를 이용해 소켓 생성 및 대기
		try(Socket socket = new Socket(ip, port)) {
			//2. 작업
			System.out.println("클라이언트 연결 성공");
			//클라이언트가 보낸 문자열을 읽어와서 콘솔에 출력하는 쓰레드
			Thread receiveThread = new Thread(()-> {
				try {//상대방이 채팅을 보내면 서버에 보내는 스레드
					ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					while(true) {						
						String str = ois.readUTF();
						if(str.equals("-1")) {
							break;
						}
						System.out.println(str);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("클라이언트 : 받는 기능 종료");

			});
			receiveThread.start();
			
			//문자열을 입력받아 클라이언트에 전송하는 쓰레드
			Thread sendThread = new Thread(()-> {
				try(ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {
					while(true) {
						String str = sc.nextLine();
						oos.writeUTF(str);
						oos.flush();
						if(str.equals("-1")) {
							break;
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("클라이언트 : 보내는 기능 종료");
			});
			sendThread.start();

		} catch (UnknownHostException e) {
			System.out.println("연결할 수 없습니다.");
		} catch (IOException e) {
			System.out.println("예외 발생");
		}
		
		System.out.println("클라이언트 : 메인 기능 종료");
	}

}
