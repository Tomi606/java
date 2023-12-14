package day05;

import java.util.Scanner;

public class ArrayEx1 {

	public static void main(String[] args) {

		//학생 5명의 국어 성적을 저장하기 위한 배열
		Scanner sc = new Scanner(System.in);
		
		//1. 배열을 안 쓸 경우
		/* 	int kor1, kor2, kor3, kor4, kor5;
			kor1 = sc.nextInt();
			kor2 = sc.nextInt();
			kor3 = sc.nextInt();
			kor4 = sc.nextInt();
			kor5 = sc.nextInt();
			
		 *  아래 반복문은 변수명에 숫자가 들어가서 i로 변경 후 반복문을 쓰려해도 불가능
		 * for(int i=1;i<=5;i) {
		 * kori = sc.nextInt(); 이렇게 쓸 수 없다
		 * } */
		
		//2. 배열
		int  korScore[] = new int[5];	//=	int kor1, kor2, kor3, kor4, kor5;
		
		for(int i=0;i<5;i++) {
			System.out.print("학생"+(i+1)+" 성적 입력 : ");
			korScore[i] = sc.nextInt();	//사용 가능
		}
		
		for(int i=0;i<5;i++) {
			System.out.println("학생"+(i+1)+" 성적 : "+korScore[i]);
		}
		
		//실수로 i<=5까지하면 ArrayIndexOutIfBoundsException 예외가 나온다.
		sc.close();
	}

}
