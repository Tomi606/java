package day15.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class StudentProgram implements Program {
	
	private static Scanner sc = new Scanner(System.in);
	private final int EXIT = 4;
	int menu = 0;
	private ArrayList<Student> std = new ArrayList<Student>();
	private static int count = 0;
	
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
			printManageStudent();
			try {
			int case1 = sc.nextInt();
			manageStudent(case1);
			} catch(InputMismatchException e) {
				System.out.println("없는 메뉴입니다.");
				sc.nextInt();
			}
			break;
			
		case 2 : 
			printManageScore();
			try {
			int case2 = sc.nextInt();
			manageScore(case2);
			} catch(InputMismatchException e) {
				System.out.println("없는 메뉴입니다.");
				sc.nextInt();
			}
			break;
			
		case 3 : 
			printView();
			try {
			int case3 = sc.nextInt();
			view(case3);
			} catch(InputMismatchException e) {
				System.out.println("없는 메뉴입니다.");
				sc.nextInt();
			}
			break;
			
		case 4 : System.out.println("프로그램을 종료합니다.");		break;
			
		default : throw new InputMismatchException();
		}
	}
	
	//1. 학생 관리 메뉴
	private void printManageStudent() {
		System.out.println("-학생 관리-");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");
		System.out.print("메뉴 선택 : ");
	}

	private void manageStudent(int case1) {
		switch(case1) {
		//추가
		case 1 : 
			insertStudent();
			break;
			
		//수정
		case 2 : 
			//updateStudent();
			break;
			
		//삭제
		case 3 : 
			break;
			
		default : throw new InputMismatchException();
		}
	}
	
	//학생 추가
	private void insertStudent() {
		System.out.println();
	}

	//2. 성적 관리
	private void printManageScore() {
		System.out.println("-성적 관리-");
		System.out.println("1. 성적 수정");
		System.out.print("메뉴 선택 : ");
	}

	private void manageScore(int case2) {
		switch(case2) {
		case 1 : 
			break;
			
		default : throw new InputMismatchException();
		}
	}
	
	
	//3. 조회
	private void printView() {
		System.out.println("-조회-");
		System.out.println("1. 학생 조회");
		System.out.println("2. 성적 조회");
		System.out.print("메뉴 선택 : ");
	}
	
	private void view(int case3) {
		switch(case3) {
		case 1 : 
			viewStudent();
			int std = sc.nextInt();
			studentMenu(std);
			break;
			
		case 2 : 
			viewScore();
			int score = sc.nextInt();
			scoreMenu(score);
			break;
			
		default : throw new InputMismatchException();
		}
	}
	
	//학생 조회
	private void viewStudent() {
		System.out.println("-학생 조회-");
		System.out.println("1. 전체");
		System.out.println("2. 학년");
		System.out.println("3. 반");
		System.out.println("4. 학생");	//학년, 반, 번호
		System.out.print("메뉴 선택 : ");
	}
	
	private void studentMenu(int std) {
			
		}


	//성적 조회
	private void viewScore() {
		System.out.println("-성적 조회-");
		System.out.println("1. 국어");
		System.out.println("2. 영어");
		System.out.println("3. 수학");
		System.out.print("메뉴 선택 : ");
		}
	
	private void scoreMenu(int score) {
			
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
