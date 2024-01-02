package day16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamEx1 {

	public static void main(String[] args) {
		
		FileInputStream fis1 = null;
		FileOutputStream fos1 = null;
		String fileName = "src/day16/fileEx3.txt";
		
		//byte 단위 기반 정석 코드
		try {
			fos1 = new FileOutputStream(fileName);
			fis1 = new FileInputStream(fileName);
			
			String str = "Hello";
			for(int i=0;i<str.length();i++) {
				fos1.write(str.charAt(i));
			}
			for(int i=0;i<str.length();i++) {
				int ch= fis1.read();		//ch는 정수이기 때문에
				System.out.print((char)ch);	//char로 형변환
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(fileName + "파일을 찾을 수 없습니다.");
		} catch (IOException e) {	//fos1.write(str.charAt(i)); 로 추가
			System.out.println("파일 작업 중 예외 발생");
		} finally {	//finally에 close()를 넣어줘야 함
			try {
				fos1.close();
				fis1.close();
			} catch (IOException e) {
				System.out.println("파일을 닫을 수 없습니다.");
			}	
		}
	}
}
