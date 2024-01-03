package day17.student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import program.Program;

public class StudentProgram implements Program {
	private Scanner sc = new Scanner(System.in);
	private StudentManager sm = new StudentManager();
	private final int EXIT = 3;
	private String fileName = "src/day17/student/studentList.txt";
	
	@Override
	public void run() {
		int menu = 0;
		//반복문 시작 전에 load
		load(fileName);
		do {
			printMenu();
			try {
			menu = sc.nextInt();
			runMenu(menu);
			} catch (InputMismatchException e) {
				System.out.println("없는 메뉴입니다.");
				sc.nextLine();
			}
		}while(menu != EXIT);
		//반복문이 끝난 후 save
		save(fileName);
	}

	private void save(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(sm.getList());
			System.out.println("저장하기를 성공 했습니다.");
		} catch (FileNotFoundException e) {
			//폴더 경로가 잘 못된 경우
			System.out.println("지정된 위치에 파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("저장에 실패했습니다.");
		}
	}

	private void load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)) {
			sm.setList((ArrayList<Student>)ois.readObject());
			System.out.println("불러오기에 성공 했습니다.");
			} catch (FileNotFoundException e) {
				System.out.println("파일을 찾을 수 없습니다.");
				
			} catch (ClassNotFoundException e) {
				System.out.println("클래스를 찾을 수 없습니다.");
				
			}catch (IOException e) {
				System.out.println("불러오기에 실패했습니다.");
			} 	
	}

	@Override
	public void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 조회");
		System.out.println("3. 종료");
		System.out.println("---------");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1 : insertStudent();
			break;
		
		case 2 : sm.printAll();
			break;
			
		case 3 : System.out.println("프로그램을 종료합니다.");
			break;
			
		default : throw new RuntimeException();
		}
	}

	private void insertStudent() {
		//학생정보입력
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		System.out.print("반 : ");
		int classNum = sc.nextInt();
		System.out.print("번호 : ");
		int num = sc.nextInt();
		System.out.print("이름 : ");
		sc.nextLine();
		String name = sc.nextLine();
		
		//학생객체생성
		Student std = new Student(grade, classNum, num, name);
		
		//추가해서 성공하면 성공알림, 실패하면 실패알림
		if(sm.insertStudent(std)) {
			System.out.println("학생을 추가했습니다.");
			return;
		}
		System.out.println("이미 등록된 학생입니다.");
	}

}
