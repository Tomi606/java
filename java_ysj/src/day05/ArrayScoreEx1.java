package day05;

import java.util.Scanner;

public class ArrayScoreEx1 {

	public static void main(String[] args) {

		/* 학생 5명의 국어 성적을 입력받고, 총점과 평균을 구하시오. */
		Scanner sc = new Scanner(System.in);
		int korScore[] = new int[5];
		int sum = 0;
		double avg = 0;
		
		for(int i=0;i<5;i++) {
			System.out.print("학생"+(i+1)+" 국어 성적 입력 : ");
			korScore[i] = sc.nextInt();
		}
		
		for(int i=0;i<5;i++) {
			sum += korScore[i];
		}
		
		avg = (double)sum/5;
		System.out.println("총점 : "+ sum+" 평균 : "+avg);
	}

}

/*
 * int[] kor = new int[5];
 * 
 * for(int i =0;i<5;i++) {
 * sysout("학생"+(i+1)+"의 국어성적 : ");
 * kor[i] = sc.nextInt();
 * }
 * 
 * int sum;
 * for(int i=0;i<5;i++) {
 * sum += kor[i];
 * }
 * 
 * int avg = sum/5;
 * sysout("총점 : "+sum + "평균 : " +avg);*/