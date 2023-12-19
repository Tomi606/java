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
		}
		
		Scanner sc = new Scanner(System.in);
		int menu, subject, num, submenu= 0;	//num = 학생번호
		//반복문 : 프로그램 종료를 선택하지 않으면 반복
		do {
			printMenu();
		menu = sc.nextInt();
		switch(menu) {
		//성적수정
		case 1 : 
			printSubject();
			subject = sc.nextInt();
			switch(subject) {
			case 1 : 
				System.out.print("국어 : ");
				break;
			case 2 : 
				break;
			case 3 : 
				break;
			default : System.out.println("없는 과목입니다.");
			}
			break;
			
		//성적조회
		case 2 : 
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
	
	/*
	 * 기능 : 학생 배열이 주어지면 정보를 입력받아 학생성적을 출력하는 메소드
	 * 매개변수 : 학생배열 -> Student []std
	 * 리턴타입 : void
	 * 메소드명 : printScore */
	public static void printScore() {
		
	}
	
	
	/*
	 * 기능 : 학생 배열을 주고 학색 번호를 입력받아 번호에 맞는 학생 성적을 출력하는 메소드
	 * 매개변수 : 학생배열 -> Student []std
	 * 리턴타입 : void
	 * 메소드명 : printScoreByNum */
	public static void printScoreByNum(Student [] std) {
		System.out.println("학생 번호 : ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(Student stds : std) {
			if(stds.num == num) {
				stds.printScore();
				return;
			}
		}
		//없는 학생번호이면 없는 학생이라고 출력
		System.out.println("일치하는 학생이 없습니다.");
	}
	
	/*
	 * 기능 : 학생 배열을 주고 조회할 과목을 입력받아 과목에 맞는 성적을 출력하는 메소드
	 * 매개변수 : 학생배열 -> Student []std
	 * 리턴타입 : void
	 * 메소드명 : printScoreBySubject */
	public static void printScoreBySubject(Student [] std) {
		//과목 입력
		System.out.println("과목(국어 : 1, 영어 : 2, 수학 : 3) : ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		//반복문 : 학생전체
		for(Student stds : std) {
			switch(num) {
			case 1 : System.out.println("번호 : " + stds.num + ", 국어 : " + stds.kor);
				break;
			case 2 : System.out.println("번호 : " + stds.num + ", 영어 : " + stds.eng);
				break;
			case 3 : System.out.println("번호 : " + stds.num + ", 수학 : " + stds.math);
				break;
			default : System.out.println("잘못된 과목입니다.");
			}
		}

		}

	
	//성적수정
	public static void printSubject() {
		
	}
	
	
	//성적조회
	public static void printSubmenu() {
		System.out.println("--성적조회--");
		System.out.println("1. 과목별조회");
		System.out.println("2. 학생별조회");
		System.out.print("선택 : ");
		
	}
	
	/* 기능 : 학생들 정보가 주어지고 추가정보를 입력하면 학생 성적을 수정하는 메소드 
	 * 매개변수 : 학생들 정보 -> Student [] std
	 * 리턴타입 : 없음 -> void
	 * 메소드명 : updateScore */
	public static void updateScore(Student[] std) {
		Scanner sc = new Scanner(System.in);
		//과목을 선택
		System.out.println("--성적수정--");	
		System.out.println("1. 국어");
		System.out.println("2. 영어");
		System.out.println("3. 수학");
		System.out.print("과목 선택 : ");
		int subject = sc.nextInt();
		//학생번호를 선택
		System.out.println("학생 : ");
		int num = sc.nextInt();
		//성적 입력
		System.out.println("성적 : ");
		int score = sc.nextInt();
		//반복문 : 학생전체
		for(Student stds : std) {
			//입력한 학생번호와 일치하는 학생정보를 찾아서 해당하는 과목에 맞는 성적을 수정
			if(stds.num != num) {
				continue;
			}
			//일치하는 학생이 있을때
			switch(subject) {
			case 1 : stds.setKor(score);	return;
			case 2 : stds.setEng(score);	return;
			case 3 : stds.setMath(score);	return;					
			}
		}
		//과목 또는 학생 번호가 잘못되면 뜨는 안내문 출력
		System.out.println("과목 또는 학생 번호가 잘못됐습니다.");
			
	}
	
	
}
