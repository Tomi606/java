package day08;

import java.util.Scanner;

public class StudentProgram1 {

	/* day06 - ScoreManual
	 * 다음 기능을 가진 성적 관리 프로그램을 작성하세요. 
	 * -1반의 성적을 관리
	 * -최대 5명
	 * -성적은 번호순으로 관리
	 * -성적은 국어, 영어, 수학 성적을 관리
	 */
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		//5명 학생 배열
		Student std[] = new Student[5];
		for(int i=0;i<std.length;i++) {
			std[i] = new Student();
			std[i].classNum = 1;
			std[i].num = i + 1;
			//std[i].printInfo();
		}
		
		int menu = 0;
		//메뉴(반복문)
		do {
			//메뉴
			printMenu();
			menu = sc.nextInt();
			
			switch(menu) {
			//1. 성적수정
			case 1 :
				updateScore(std);
				break;
			
			//2. 성적조회
			case 2 :
				printScore(std);
				break;
				
			//3. 프로그램 종료
			case 3 : System.out.println("프로그램을 종료합니다.");	break;
				
			default : System.out.println("잘못된 메뉴입니다.");	break;
			}
			
		}while(menu != 3);
		
	}
	
	//메뉴
	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 성적수정");
		System.out.println("2. 성적조회");
		System.out.println("3.프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
	
	//1. 성적수정
	public static void updateScore(Student [] std) {
		System.out.println("--성적수정--");
		System.out.println("1. 국어");
		System.out.println("2. 영어");
		System.out.println("3. 수학");
		System.out.print("과목 선택 : ");
		Scanner sc = new Scanner(System.in);
		int subject = sc.nextInt();
		
		System.out.print("학생 선택 : ");
		int num = sc.nextInt();
		
		System.out.print("성적 입력 : ");
		int score = sc.nextInt();
		
		for(Student stds : std) {
			if(stds.num != num) {
				continue;
			}
			
			switch(subject) {
			case 1 : stds.setKor(score);	return;
			case 2 : stds.setEng(score);	return;
			case 3 : stds.setMath(score);	return;
			default : System.out.println("없는 과목입니다.");
			}
		}
		System.out.println("과목 또는 학생 번호가 잘못되었습니다.");
	}
	
	//2. 성적조회
	public static void printScore(Student [] std) {
		System.out.println("--성적조회--");
		System.out.println("1. 과목별조회");
		System.out.println("2. 학생별조회");
		System.out.print("선택 : ");
		Scanner sc = new Scanner(System.in);
		int submenu = sc.nextInt();
		
		switch(submenu) {
		//1. 과목별조회
		case 1 : 
			System.out.println("1. 국어");
			System.out.println("2. 영어");
			System.out.println("3. 수학");
			System.out.println("과목 선택 : ");
			int subject = sc.nextInt();
			//국 영 수 성적조회 1~5번
			for(Student stds : std) {
			switch(subject) {
			case 1 : System.out.println(stds.num + "번 : " + stds.kor);
				break;
			case 2 : System.out.println(stds.num + "번 : " + stds.eng);
				break;
			case 3 : System.out.println(stds.num + "번 : " + stds.math);
				break;
			default : System.out.println("잘못된 과목입니다.");
				}
			}
			break;
			
		//2. 학생별조회
		case 2 : 
			System.out.print("학생 선택 : ");
			int num = sc.nextInt();
			for(Student stds : std) {
				if(stds.num == num) {
					stds.printScore();
				}
			}
			break;
		}
		
	}
}
