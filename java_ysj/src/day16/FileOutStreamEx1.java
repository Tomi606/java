package day16;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutStreamEx1 {

	public static void main(String[] args) {
		/* FileOutputStream은 파일이 없으면 생성한 후 출력해 줌
		 * FileIntputStream은 파일이 없으면 예외가 발생 */
		FileOutputStream fos = null;
		String fileName = "src/day16/fileEx2.txt";
		
		try {
			fos = new FileOutputStream(fileName);
			for(int i=0;i<26;i++) {
				fos.write((char)('A' + i));	//file2.txt 에 자동으로 출력됨
			}
			fos.close();
		} catch (FileNotFoundException e) {
			System.out.println(fileName + "을 찾을 수 없습니다.");
		}//실행했는데 위의 메세지가 출력안된다. -> 새로고침하면 자동으로 생성됨
		catch (IOException e) {
			 System.out.println("파일을 닫을 수 없습니다.");
		}
		
	}

}
