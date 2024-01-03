package day17.socket1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx1 {

	public static void main(String[] args) {
		//1. 서버의 포트번호 정함
		int port = 5001;
		
		ServerSocket serverSocket = null;
		
		try {
			//2. 서버용 소켓 객체 생성
			serverSocket = new ServerSocket(port);
			
			//3. 대기
			//4. 요청 수락 후 소켓 객체 생성
			Socket socket = serverSocket.accept();
			
			//5. 작업
			System.out.println("연결 성공");
			
			//이미 포트 번호를 사용하고 있는 경우(서버가 끝나지 않았는데 계속 열 경우)
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
