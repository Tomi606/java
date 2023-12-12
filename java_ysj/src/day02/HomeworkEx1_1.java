package day02;

import java.util.Scanner;

public class HomeworkEx1_1 {

	public static void main(String[] args) {
		/* 성적을 입력받아 성적에 맞는 학점을 출력하는 코드를 작성하시오.
		 * 90이상~100이하 : A
		 * 80이상~90미만 : B
		 * 70이상~80미만 : C
		 * 60이상~70미만 : D
		 * 60 미만 : F
		 * 0보다 작거나 100보다 큰 경우 : 잘못된 점수*/
		
		//성적을 콘솔에서 입력 받음
		Scanner sc = new Scanner(System.in);	//123엔터 abc엔터
		System.out.print("학생의 성적은 몇점 입니까? ");
		int score = sc.nextInt();
		
		/*Scanner sc = new Scanner("123\nabc\n");	//123엔터 abc엔터
		int num = sc.nextInt();
		String str = sc.next();
		System.out.println(num);	//123
		System.out.println(str);	//abc */
		
		//성적을 기준으로 학점 출력(이 코드는 순서가 중요)
		//순서가 바뀌면 해당하는 수식에 맞춰서 나가기 때문에 다른 출력값이 나올 수 있다.
		
		if(score<0 || score>100) {
			System.out.println("잘못된 점수입니다.");
		}else if(score>=90) {
			System.out.println("A학점 입니다.");
		}else if(score>=80) {
			System.out.println("B학점 입니다.");
		}else if(score>=70) {
			System.out.println("C학점 입니다.");
		}else if(score>=60) {
			System.out.println("D학점 입니다.");
		}else {
			System.out.println("F학점 입니다.");
		}
		
	}
}
