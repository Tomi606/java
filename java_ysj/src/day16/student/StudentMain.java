package day16.student;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

public class StudentMain {
	/* 다음 프로그램을 가진  프로그램을 만드세요.
	 * - 학생 관리 프로그램
	 * - 기능
	 * 	1. 학생 추가
	 * 	2. 학생 조회(전체)
	 * 	3. 종료
	 * - 학생은 학년, 반, 번호, 이름을 가진다. 
	 * - 저장 기능과 불러오기 기능을 통해 학생 정보들을 유지 */

	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Student> list = new ArrayList<Student>();
	
	public static void main(String[] args) {
		
		String fileName = "src/day16/studentFile.txt";
		int menu = 0;
		
		//load(fileName);
		do {
			printMenu();
			try {
			menu = sc.nextInt();
			runMenu(menu);
		} catch(InputMismatchException e) {
			System.out.println("없는 메뉴입니다.");
			sc.nextLine();
			System.out.println();
		}
		}while(menu != 3);
		//save(fileName);
	}

	private static void runMenu(int menu) {
		switch(menu) {
		case 1 : insertStudent();
			break;
		
		case 2 : searchStudent();
			break;
			
		case 3 : System.out.println("프로그램을 종료합니다.");
			break;
			
		default : throw new InputMismatchException();
		}
	}

	//2. 학생 조회
	private static void searchStudent() {
		for(Student tmp : list) {
			tmp.print();
		}
	}

	//1. 학생 추가
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
		
		//std 배열에 tmp 인스턴스가 없으면 std에 넣어라
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

}

@Data
@AllArgsConstructor
class Student implements Serializable {

	private static final long serialVersionUID = 8250394517997101201L;
	int grade, classNum, num;
	String name;
	
	//출력
	public void print() {
		System.out.println(grade + "학년 " + classNum + "반 " + num + "번 " + name);
	}
	
	
}