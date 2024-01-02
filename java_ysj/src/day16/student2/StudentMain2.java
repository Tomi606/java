package day16.student2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentMain2 {
	/* 다음 프로그램을 가진 프로그램을 만드세요.(세이브 앤 로드 기능 - 클래스에 시리얼넘버를 넣어서 오브젝트 클래스 사용)
	 * - 학생 관리 프로그램
	 * - 기능
	 * 	1. 학생 추가
	 * 	2. 학생 조회(전체)
	 * 	3. 종료
	 * - 학생은 학년, 반, 번호, 이름을 가진다. 
	 * - 저장 기능과 불러오기 기능을 통해 학생 정보들을 유지 */

	static Scanner sc = new Scanner(System.in);
	static List<Student> list = new ArrayList<Student>();
	
	public static void main(String[] args) {
		int menu = 0;
		String fileName = "src/day16/student2/list.txt";
		load(fileName);
		
		do {
			try {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
			}catch(Exception e) {
				System.out.println("없는 메뉴입니다.");
			}
		}while(menu != 3);
		
		save(fileName);
	}

	//세이브가 되어야 로드를 할 수 있기 때문에 이거먼저 구현
	private static void save(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(list);
		} catch (IOException e) {
			System.out.println("저장을 실패했습니다.");
		}
		
	}

	private static void runMenu(int menu) {
		switch(menu) {
		case 1 : insertStudent();
			break;
		
		case 2 : searchStudent();
			break;
			
		case 3 : System.out.println("프로그램을 종료합니다.");
			break;
			
		default : throw new RuntimeException();
		}
	}

	private static void searchStudent() {
		list.stream().forEach(s->System.out.println(s));
	}

	private static void insertStudent() {
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		System.out.print("반 : ");
		int classNum = sc.nextInt();
		System.out.print("번호 : ");
		int num = sc.nextInt();
		System.out.print("이름 : ");
		sc.nextLine();
		String name = sc.nextLine();
		
		Student tmp = new Student(grade, classNum, num, name);
		
		//list 배열에 tmp 인스턴스가 없으면 list에 넣어라
		if(!list.contains(tmp)) {
			list.add(tmp);
			System.out.println("학생 등록 완료");
			return;
		}
		//있으면 이미 등록됬다고 알림		
		else {
		System.out.println("이미 등록된 학생입니다.");
		}
	}

	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 조회");
		System.out.println("3. 종료");
		System.out.println("---------");
		System.out.print("메뉴 선택 : ");
	}

	private static void load(String fileName) {
		try (FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)) {
			list = (List<Student>)ois.readObject();
			System.out.println("학생 정보를 불러왔습니다.");
		} catch (Exception e) {
			System.out.println("불러오기를 실패했습니다.");
		}
	}
	
	

}

