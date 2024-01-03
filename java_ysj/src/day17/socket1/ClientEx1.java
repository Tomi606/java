package day17.socket1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientEx1 {

	public static void main(String[] args) {
		//서버의 ip, port 번호 설정
		String ip = "192.168.30.189";
		int port = 5001;
		
		//1. ip와 port를 이용해 소켓 생성
		try(Socket socket = new Socket()) {
			//2. 연결 요청
			socket.connect(new InetSocketAddress(ip, port));
			//3. 작업
			System.out.println("연결 성공");
		} catch (UnknownHostException e) {
			System.out.println("연결할 수 없습니다.");
		} catch (IOException e) {
			System.out.println("예외 발생");
		}
	}

}
