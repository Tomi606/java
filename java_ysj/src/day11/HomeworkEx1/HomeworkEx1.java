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
			break;
			
		case 2 :
			manageScore();
			break;
			
		case 3 : System.out.println("프로그램을 종료합니다.");	break;
			
		default : System.out.println("없는 메뉴입니다.");
		}
	}


	


	//1. 학생 관리
	private static void manageStudent() {

		
	}

	//2. 성적 관리
	private static void manageScore() {

		
	}
	
	//메뉴
	private static void printMenu() {
		System.out.println("[고등학생 학생 및 성적 관리 시스템");
		System.out.println("1. 학생 관리");
		System.out.println("2. 성적 관리");
		System.out.println("3. 프로그램 종료");
		System.out.print("메뉴 입력 : ");
	}

}
