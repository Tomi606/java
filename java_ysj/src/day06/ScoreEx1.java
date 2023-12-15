package day06;

import java.util.Scanner;

public class ScoreEx1 {

	public static void main(String[] args) {

		int menu = 1;
		int subject, num, score;	//과목이름, 학생번호, 성적
		int maxStudent = 30;
		//국어 영어 수학 성적을 넣을 배열
		int [] kor = new int[maxStudent];
		int [] eng = new int[maxStudent];
		int [] math = new int[maxStudent];
		
		int submenu;
		Scanner sc = new Scanner(System.in);
		
		do {
			//메뉴
			System.out.println("==============");
			System.out.println("1. 성적수정");
			System.out.println("2. 성적조회");
			System.out.println("3. 프로그램 종료");
			System.out.println("==============");
			System.out.print("메뉴 선택 : ");
			menu = sc.nextInt();
			
			switch(menu) {
			//서브메뉴 출력
			case 1 : 
				System.out.println("--성적수정--");
				System.out.println("1. 국어");
				System.out.println("2. 영어");
				System.out.println("3. 수학");
				//과목선택
				System.out.print("과목 선택 : ");
				subject = sc.nextInt();
				//학생선택
				System.out.print("학생 선택 : ");
				num = sc.nextInt();
				//성적입력
				System.out.print("성적 입력 : ");
				score = sc.nextInt();
				//성적을 저장
				switch(subject) {
				case 1 : kor[num-1] = score; break;
				case 2 : eng[num-1] = score; break;
				case 3 : math[num-1] = score; break;
				
				}
				break;
				
			case 2 : 
				//서브메뉴 출력
				System.out.println("--성적조회--");
				System.out.println("1. 과목별조회");
				System.out.println("2. 학생별조회");
				System.out.print("선택 : ");
				//서브메뉴 선택
				submenu = sc.nextInt();
				//서브메뉴에 따른 기능실행
				switch(submenu) {
				case 1 : 
					//과목선택메뉴 출력
					System.out.println("--과목별조회--");
					System.out.println("1. 국어");
					System.out.println("2. 영어");
					System.out.println("3. 수학");
					System.out.println("과목 선택 : ");
					//과목선택
					subject = sc.nextInt();
					//선택한 과목의 성적을 출력
					int []selectedSubject = null;	//하나만 만들어 한줄
					switch(subject) {
					case 1 : selectedSubject = kor; break;
					case 2 : selectedSubject = eng; break;
					case 3 : selectedSubject = math; break;
					default : System.out.println("잘못된 과목입니다.");
					}
					if(selectedSubject != null) {
						for(int i=0;i<selectedSubject.length;i++) {
							System.out.println((i+1)+"번 : "+selectedSubject[i]+"점");
						}
					}
					break;
				
				case 2 : 
					//학생 선택
					System.out.println("--학생별조회--");
					System.out.print("학생 선택 : ");
					num = sc.nextInt();
					
					//선택한 학생의 국어,영어,수학점수 출력
					System.out.println(num+"번 학생 점수");
					System.out.println("국어 : " + kor[num-1]);
					System.out.println("영어 : " + eng[num-1]);
					System.out.println("수학 : " + math[num-1]);
					break;
					
				default : System.out.println("잘못된 메뉴입니다.");
				}
				break;
				
			case 3 : 
				System.out.println("프로그램을 종료합니다.");
				break;
			
			default : 
				System.out.println("잘못된 메뉴입니다.");
				
			}
			
			
		}while(menu != 3);
		
		sc.close();
	}

}
