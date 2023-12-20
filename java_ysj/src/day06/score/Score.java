package day06.score;

import java.util.Scanner;

public class Score {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int maxStudent = 30;
		int kor[] = new int[maxStudent];
		int eng[] = new int[maxStudent];
		int math[] = new int[maxStudent];
		
		int num = 0,subject = 0, score = 0;	//학생, 과목
		int view = 0;	//조회
		int menu = 0;
		do {
			//메뉴
			System.out.println("메뉴");
			System.out.println("1. 성적수정");
			System.out.println("2. 성적조회");
			System.out.println("3. 프로그램 종료");
			System.out.print("메뉴 선택 : ");
			menu = sc.nextInt();
			
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
				num = sc.nextInt();
				System.out.print("성적 입력 : ");
				score = sc.nextInt();
				//성적입력
				switch(subject) {
				case 1 : kor[num-1] = score;	break;
				case 2 : eng[num-1] = score;	break;
				case 3 : math[num-1] = score;	break;
				}
				break;
				
			//2. 성적조회
			case 2 : 
				System.out.println("--성적조회--");
				System.out.println("1. 과목별조회");
				System.out.println("2. 학생별조회");
				System.out.print("선택 : ");
				view = sc.nextInt();
				int i = 0;
				switch(view) {
				//1. 과목별조회
				case 1 :
					System.out.println("--과목별조회--");
					System.out.println("1. 국어");
					System.out.println("2. 영어");
					System.out.println("3. 수학");
					System.out.println("과목 선택 : ");
					subject = sc.nextInt();
					switch(subject) {
					case 1 : 
						for(i=0;i<kor.length;i++) {
							if(kor[i] != 0) {	//입력된 번호만 보고싶을때
								System.out.println((i+1) + "번 : " + kor[i] + "점");
							}
						}
						break;
					case 2 : 
						for(i=0;i<eng.length;i++) {
							System.out.println((i+1) + "번 : " + eng[i] + "점");
						}
						break;
					case 3 : 
						for(i=0;i<math.length;i++) {
							System.out.println((i+1) + "번 : " + math[i] + "점");
						}
						break;
					default : System.out.println("잘못된 과목입니다.");
					}
					
					
					break;
					
				//2. 학생별조회
				case 2 : 
					System.out.println("--학생별조회--");
					System.out.println("학생 선택 : ");
					num = sc.nextInt();
						System.out.println(num + "번 학생 성적");
						System.out.println("국어 : " + kor[num-1]);
						System.out.println("영어 : " + eng[num-1]); 
						System.out.println("수학 : " + math[num-1]); 
					break;
				}
				break;
				
			case 3 : System.out.println("프로그램을 종료합니다.");
				break;
				
				default : System.out.println("잘못된 메뉴입니다.");
				
			}
			
			
		}while(menu != 3);
		
	}

}
