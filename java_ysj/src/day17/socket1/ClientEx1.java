package day17.socket1;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientEx1 {

	public static void main(String[] args) {
		//서버의 ip, port 번호 설정
		String ip = "192.168.30.189";
		int port = 5001;
		Scanner sc = new Scanner(System.in);
		//1. ip와 port를 이용해 소켓 생성 및 대기
		try(Socket socket = new Socket(ip, port)) {
			//2. 작업
			System.out.println("클라이언트 연결 성공");
			//서버로 보냄(out)
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			//서버에서 채팅 내역을 가져옴
			
			//채팅 내역을 조회
			
			while(true) {
			System.out.print("내용(종료는 -1을 입력) : ");
			String str = sc.nextLine();
			oos.writeUTF(str);
			oos.flush();//한줄 입력하고 밀어주는 기능(없으면 -1 끝날때 다 나옴)
			if(str.equals("-1")) {
				break;
				}
			}
			oos.close();
			
		} catch (UnknownHostException e) {
			System.out.println("연결할 수 없습니다.");
		} catch (IOException e) {
			System.out.println("예외 발생");
		}
	}

}
