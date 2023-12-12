package day03;

import java.util.Scanner;

public class SwitchEx3 {

	public static void main(String[] args) {

		/*월을 입력받아 입력받은 월의 계절을 출력하세요
		 * 3, 4, 5 : 봄
		 * 6, 7, 8 : 여름
		 * 9, 10, 11 : 가을
		 * 12, 1, 2 : 겨울
		 * 그 외 : 잘못된 월
		 * 이런 반복되는 구문이 많을때 스위치문 사용 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("몇월인지 입력하시오.");
		int month = sc.nextInt();
		
		switch(month) {
		case 3,4,5 :
			System.out.println("봄 입니다.");
			break;
			
		case 6,7,8 : 
			System.out.println("여름 입니다.");
			break;
			
		case 9,10,11 : 
			System.out.println("가을 입니다.");
			break;
			
		case 1,2,12 : 
			System.out.println("겨울 입니다.");
			break;
			
		default :
			System.out.println("잘못된 입력입니다.");
		}
	}

}
