package day08;

import java.util.Scanner;

public class StudentProgram {

	/* day06 - ScoreManual
	 * 다음 기능을 가진 성적 관리 프로그램을 작성하세요. 
	 * -1반의 성적을 관리
	 * -최대 5명
	 * -성적은 번호순으로 관리
	 * -성적은 국어, 영어, 수학 성적을 관리
	 */
	

	public static void main(String[] args) {
		//학년, 이름은 생략하고 반은 1반으로 고정 
		//번호는 각각 1번부터 5번으로 저장
		Student std[] = new Student[5];
		for(int i=0;i<std.length;i++) {
			std[i] = new Student();
			//std[i].classNum = 1;
			//std[i].num = i+1;
		}
		//학생 번호 수정
		int count = 1;
		//향상된 for문을 이용하여 std를 다른 인스턴스로 교체하는 건 안되지만
		//std의 멤버변수를 바꾸는 건 가능
		for(Student stds : std) {
			stds.classNum = 1;
			stds.num = count++;
			stds.printInfo();
		}
		
		Scanner sc = new Scanner(System.in);
		int menu, score, num, submenu= 0;	//num = 학생번호
		//반복문 : 프로그램 종료를 선택하지 않으면 반복
		do {
			printMenu();
		menu = sc.nextInt();
		switch(menu) {
		//성적수정
		case 1 : 
			printSubject();
			score = sc.nextInt();
			break;
			
		//성적조회
		case 2 : 
			printSubmenu();
			submenu = sc.nextInt();
			break;
			
		//프로그램 종료
		case 3 : System.out.println("프로그램 종료");	break;
		default : System.out.println("없는 메뉴입니다.");
		}
			//선택한 메뉴에 따른 기능 실행
		
		}while(menu != 3);
		//프로그램 종료를 출력
	}
	//메뉴
	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 성적수정");
		System.out.println("2. 성적조회");
		System.out.println("3. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
		}
	
	//성적수정
	public static void printSubject() {
		System.out.println("--성적수정--");
		System.out.println("1. 국어");
		System.out.println("2. 영어");
		System.out.println("3. 수학");
		System.out.print("과목 선택 : ");	
	}
	
	//성적조회
	int submenu = 0;
	public static void printSubmenu() {
		System.out.println("--성적조회--");
		System.out.println("1. 과목별조회");
		System.out.println("2. 학생별조회");
		System.out.print("선택 : ");
		submenu = sc.nextInt();
		switch(submenu) {
		case 1 : 
			
		}
	}
	
	
}
