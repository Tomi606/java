package day04;

import java.util.Scanner;

public class TestEx1 {

	public static void main(String[] args) {

		/* Scanner를 이용하여 국어, 영어, 수학 성적을 입력하고
		 * 총점과 평균을 구하는 코드를 작성하세요.*/
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 성적을 입력하세요 : ");
		int korScore = sc.nextInt();
		System.out.print("영어 성적을 입력하세요 : ");
		int engScore = sc.nextInt();
		System.out.print("수학 성적을 입력하세요 : ");
		int mathScore = sc.nextInt();
		
		int sum = korScore + engScore + mathScore;
		double avg = sum/(double)3;
		
		System.out.println("총점은 " + sum + "점 입니다.");
		System.out.println("평균은 " + avg + "점 입니다.");
		
		sc.close();
	}

}
