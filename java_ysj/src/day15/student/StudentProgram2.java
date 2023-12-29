package day15.student;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentProgram2 implements Program {
	
	private static Scanner sc = new Scanner(System.in);
	private final int EXIT = 4;
	int menu = 0;
	private List<Student> list = new ArrayList<Student>();
	
	
	@Override
	public void run() {	//메인 메소드(메뉴 출력)
		do {
		printMenu();
		try {
		menu = sc.nextInt();
		runMenu(menu);
		} catch(InputMismatchException e) {
			System.out.println("없는 메뉴입니다.");
			sc.nextLine();	//잘못된 값 비워줌.
		}
		}while(menu != EXIT);
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1 : 
			studentManager();
			break;
			
		case 2 : 
			manageScore();
			break;
			
		case 3 : 
			printView();
			break;
			
		case 4 : System.out.println("프로그램을 종료합니다.");		break;
			
		default : throw new InputMismatchException();
		}
	}
	
	//1. 학생 관리
	private void studentManager() {
		printStudentMenu();
		int menu = sc.nextInt();
		runStudentMenu(menu);
	}

	private void printStudentMenu() {
		System.out.println("-학생 관리-");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");
		System.out.print("메뉴 선택 : ");
	}

	private void runStudentMenu(int menu) {
		switch(menu) {
		case 1 : 
			insertStudent();
			break;
			
		case 2 : 
			break;
			
		case 3 : 
			break;
			
		default : throw new InputMismatchException();
		}
	}

	//학생 추가
	//이미 등록된 학생은 추가 X(학년, 반, 번호가 같을 경우)
	private void insertStudent() {
		//학년, 반, 번호, 이름을 입력
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		System.out.print("반 : ");
		int classNum = sc.nextInt();
		System.out.print("번호 : ");
		int num = sc.nextInt();
		System.out.print("이름 : ");
		sc.nextLine();
		String name = sc.nextLine();
		
		//입력받은 정보로 인스턴스를 생성 std
		Student std = new Student(grade, classNum, num, name);
		
		//std가 리스트에 있는지 확인해서 없으면 추가
		//contains는 Objects.equals(a,b)를 호출해서 a와 b의 클래스가 같으면
		//a.equals(b)를 이용하여 있는지 없는지 확인
		if(!list.contains(std)) {	//list 배열에 std 인스턴스와 같은 학생이 없으면
			list.add(std);			//추가
			System.out.println("학생 등록 완료");
			return;
		}
		
		//있으면 이미 등록됐다고 알림
		System.out.println("이미 등록된 학생입니다.");
	}

	//2. 성적 관리
	private void manageScore() {
		
	}

	//3. 조회
	private void printView() {
		
	}

	//메뉴
	@Override
		public void printMenu() {
			System.out.println("메뉴");
			System.out.println("1. 학생 관리");
			System.out.println("2. 성적 관리");
			System.out.println("3. 조회");
			System.out.println("4. 종료");
			System.out.print("메뉴 선택 : ");
		}
}
