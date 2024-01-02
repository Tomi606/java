package day16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamEx1 {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("src/day16/fileEx1.txt");
			for(int i=0;i<3;i++) {
				int num = fis.read();	//read가 byte 단위로 하나씩 읽어옴. int(정수)로 읽어 오기 때문
				System.out.print((char)num);	//char로 형변환을 해줘야 함
			}
			fis.close();
		}
		//fileEx1.txt가 없을때 catch
		catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} 
		//fis.close() 에러로 추가
		catch (IOException e) {
			System.out.println("파일을 닫을 수 없습니다.");
		}
	}

}
