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
	
		//5명의 학생 정보를 저장할 수 있는 배열 생성
		Student stds[] = new Student[5];
		
		for(int i=0;i<stds.length;i++) {
			//각 학생의 인스턴스 생성
			stds[i] = new Student();
			//각 학생의 번호를 1~5번까지 지정
			stds[i].classNum = 1;	//반
			stds[i].num = i + 1;	//번호
			//stds[i].printInfo();	1~5번 학생 출력
		}
		
		//반복문
		int menu = 0;
		do {
			
		}while(menu != 3);
	}
	
}
