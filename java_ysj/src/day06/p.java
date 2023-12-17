package day06;

import java.util.Scanner;

public class p {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int maxStudent = 30;
		int kor[] = new int[maxStudent];
		int math[] = new int[maxStudent]; 
		int eng[] = new int[maxStudent];
		int subject, student, score;
		int menu = 0, submenu = 0;
		
		do {
			System.out.println("메뉴");
			System.out.println("1. 성적수정");
			System.out.println("2. 성적조회");
			System.out.println("3. 프로그램 종료");
			System.out.print("메뉴 선택 : ");
			menu = sc.nextInt();
			System.out.println();
			
			switch(menu) {
			//1. 성적수정
			case 1 :
				System.out.println("--성적수정--");
				System.out.println("1. 국어");
				System.out.println("2. 영어");
				System.out.println("3. 수학");
				System.out.print("과목 선택 : ");
				subject = sc.nextInt();
				System.out.print("학생 선택 : ");
				student = sc.nextInt();
				System.out.print("성적 입력 : ");
				score = sc.nextInt();
				System.out.println();

				
				switch(subject) {
				case 1 : kor[student-1] = score;	break;
				case 2 : eng[student-1] = score;	break;
				case 3 : math[student-1] = score;	break;
				
				}
					break;
					
			//2. 성적조회(submenu)
			case 2 :
				System.out.println("--성적조회--");
				System.out.println("1. 과목별조회");
				System.out.println("2. 학생별조회");
				System.out.print("선택 : ");
				submenu = sc.nextInt();
				System.out.println();

				
				switch(submenu) {
				//1. 과목별조회
				case 1 : 
					System.out.println("--과목별조회--");
					System.out.println("1. 국어");
					System.out.println("2. 영어");
					System.out.println("3. 수학");
					System.out.print("과목 선택 : ");
					subject = sc.nextInt();
					System.out.println();

					switch(subject) {
					case 1 : 
						for(int i=0;i<maxStudent;i++) {
							System.out.println((i+1)+"번 : " + kor[i]);
							System.out.println();
						}
						break;
						
					case 2 : 
						for(int i=0;i<maxStudent;i++) {
							System.out.println((i+1)+"번 : " + eng[i]);
							System.out.println();

						}
						break;
						
					case 3 : 
						for(int i=0;i<maxStudent;i++) {
							System.out.println((i+1)+"번 : " + math[i]);
							System.out.println();
						}
					}
					break;
				
				//2. 학생별조회
				case 2 : 
					System.out.println("--학생별조회--");
					System.out.print("학생 선택 : ");
					student = sc.nextInt();
					System.out.println();

					//해당학생의 성적
					System.out.println(student + "번 학생의 점수");
					System.out.println("국어 : " + kor[student-1]);
					System.out.println("영어 : " + eng[student-1]);
					System.out.println("수학 : " + math[student-1]);
					System.out.println();
				}
				break;
			
			//3. 프로그램 종료
			case 3 : System.out.println("프로그램을 종료합니다.");	break;
				
			default : System.out.println("없는 메뉴입니다.");
					System.out.println();
					break;
			}
			
		}while(menu != 3);
	}

}
