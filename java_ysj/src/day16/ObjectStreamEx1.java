package day16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ObjectStreamEx1 {

	public static void main(String[] args) {
		//직렬화 / 역직렬화를 이용한 객체를 쓰고 읽는 예제
		Board board = new Board(1, "제목", "내용", "테스트");
		String fileName = "src/day16/objectStreamEx1.txt";
		
		//게시글을 파일에 저장(Out, write, 써줘야 함)
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(board);
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("파일을 쓰는 도중에 에러가 발생했습니다.");
		}
		
		//저장된 파일에서 게시글을 읽어옴
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)) {
			Board tmp = (Board)ois.readObject();
			System.out.println(tmp);
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("파일을 쓰는 도중에 에러가 발생했습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을 수 없습니다.");
		}
	}

}

@Data
@AllArgsConstructor
//직렬화 구현
class Board implements Serializable {
	/* 같은 클래스이어도 serialVersionUID가 다르면 읽어오지 못함 */
	private static final long serialVersionUID = -2004124461323227781L;
	int num;
	String title, contents;
	
	//저장 or 들고오고 싶지 않은 데이터 키워드 : transient
	transient String test;
}