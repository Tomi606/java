package ex;

import java.util.Scanner;

public class EnumEx {
	//오후 강의 뒤에 enum 조금만 듣기
	public static void main(String []agrs) {
		Scanner sc = new Scanner(System.in);
		System.out.print("계절 입력(봄, 여름, 가을, 겨울) : ");
		String seasonStr = sc.next();
		
		Season season = Season.valueOf(seasonStr); //문자열을 Season 객체로
		switch(season) {
		case 봄 : System.out.println("봄입니다."); break;
		case 여름 : System.out.println("봄입니다."); break;
		case 가을 : System.out.println("봄입니다."); break;
		case 겨울 : System.out.println("봄입니다."); break;
		default : 
		}
		
	}
}
