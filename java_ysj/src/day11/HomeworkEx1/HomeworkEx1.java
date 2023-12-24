package day11.HomeworkEx1;

import java.util.Scanner;

/* 고등학생 성적 관리 시스템
 * 메뉴
 *	1. 학생 관리
 * 	- 학생 추가 : 동일한 학생(학년, 반, 번호가 같은)이 있으면 안됨
 * 	- 학생 수정
 * 	- 학생 삭제
 * 
 * 2. 성적 관리
 * 	-성적 추가 : 과목과 점수를 입력
 * 	-성적 수정
 * 	-성적 삭제
 * 3. 프로그램 종료
 * 
 * - Student 클래스
 * - Subject 클래스
 * 
 * 	- 쉬운 버전 : 과목명, 총점
 * 	- 어려운 버전 : 과목명, 성적(중간, 기말, 수행평가, 총점)
 * 	*/
public class HomeworkEx1 {

	private static Scanner sc = new Scanner(System.in);
	private static Student student[] = new Student[10];
	private static int countStudent = 0;
	
	private static Subject subject[] = new Subject[5];
	private static int countSubject = 0;
	
	public static void main(String[] args) {

		int menu = 0;
		do {
			printMenu();
			menu = sc.nextInt();
			
			runMenu(menu);
		}while(menu != 3);
	}


	private static void runMenu(int menu) {
		switch(menu) {
		case 1 :
			manageStudent();
			int student = sc.nextInt();
			runManageStudent(student);
			break;
			
		case 2 :
			manageScore();
			int score = sc.nextInt();
			runManageScore(score);
			break;
			
		case 3 : System.out.println("프로그램을 종료합니다.");	break;
			
		default : System.out.println("없는 메뉴입니다.");
		}
	}
	
	
	//성적 관리
	private static void runManageScore(int score) {
		switch(score) {
		case 1 : 
			break;
			
		case 2 : 
			break;
			
		case 3 : 
			break;
			
		default : System.out.println("없는 메뉴입니다.");
		}
	}

	
	
	
	
	//학생 관리
	private static void runManageStudent(int student) {
		switch(student) {
		case 1 : 
			storeStudent();
			break;
			
		case 2 : 
			updateStudent();
			break;
			
		case 3 : 
			deleteStudent();
			break;
			
		default : System.out.println("없는 메뉴입니다.");
			
		}
	}

	//3. 학생 삭제
	private static void deleteStudent() {
		System.out.println("삭제할 학생 학년, 반, 번호, 이름 : ");
		int grade = sc.nextInt();
		int classNum = sc.nextInt();
		int num = sc.nextInt();
		sc.nextLine();
		String name = sc.nextLine();
		
		int index = -1;
		for(int i=0;i<countStudent;i++) {
			if(grade == student[i].getGrade() && classNum == student[i].getClassNum() && 
					num == student[i].getNum() && name == student[i].getName()) {
				index = i;
				break;
			}
		}
		
		if(index == -1) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		
		countStudent--;
		
		if(index == countStudent) {
			return;
		}
		
		Student[] tmplist = new Student[student.length];
		System.arraycopy(student, 0, tmplist, 0, student.length);
		System.arraycopy(tmplist, index+1, student, index, countStudent-index);
		
	}


	//2. 학생 수정(이름)
	private static void updateStudent() {
		System.out.println("수정할 학생 이름 : ");
		sc.nextLine();
		String name = sc.nextLine();
		
		System.out.println("수정한 이름 : ");
		String updateName = sc.nextLine();
		
		for(int i=0;i<countStudent;i++) {
			if(student[i].equals(name)) {
				student[i].updateName(updateName);
				student[i].showStudentInfo();
			}
		}
	}


	//1. 학생 추가 - 동일한 학생(학년, 반, 번호가 같은)이 있으면 안됨
	private static void storeStudent() {
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		
		System.out.print("반 : ");
		int classNum = sc.nextInt();
		
		System.out.print("번호 : ");
		int num = sc.nextInt();
		
		System.out.print("이름 : ");
		sc.nextLine();
		String name = sc.nextLine();
		
		//동일인 있을때 배열에 안넣음
		
		
		//없을시 배열에 넣음 + 학생 출력
		student[countStudent++] = new Student(grade, classNum, num, name);
		for(int i=0;i<countStudent;i++) {
			student[i].showStudentInfo();
		}
		
		//배열 확장
		if(countStudent == student.length) {
			student = expandList(student);
		}
	}

	//배열 확장 코드
	private static Student[] expandList(Student[] student) {
		Student[] tmplist = new Student[student.length + 10];
		System.arraycopy(student, 0, tmplist, 0, student.length);
		return tmplist;
	}

	//학생 관리
	private static void manageStudent() {
		System.out.println("[학생 관리]");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");
		System.out.print("메뉴 선택 : ");
		
	}

	//성적 관리
	private static void manageScore() {
		System.out.println("[성적 관리]");
		System.out.println("1. 성적 추가");
		System.out.println("2. 성적 수정");
		System.out.println("3. 성적 삭제");
		System.out.print("메뉴 선택 : ");
	}
	
	//메뉴
	private static void printMenu() {
		System.out.println("[고등학생 학생 및 성적 관리 시스템]");
		System.out.println("1. 학생 관리");
		System.out.println("2. 성적 관리");
		System.out.println("3. 프로그램 종료");
		System.out.print("메뉴 입력 : ");
	}

}
