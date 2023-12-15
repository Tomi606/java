package day06;

import java.util.Scanner;

public class AlphabetCountEx1 {
		//word.length();
		//word.charAt(0);
	public static void main(String[] args) {

		/* 단어를 입력받아 단어 각 알파벳이 몇번 나왔는지 출력하는 코드
		 * 입력 : apple
		 * a : 1
		 * e : 1
		 * l : 1
		 * p : 2 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("영어 단어 입력 : ");
		String word = sc.next();	//next ->문자, nextLine -> 문자열
		
		//각 알파벳을 받을 배열과 알파벳 개수를 셀 count 배열
		int alphabet[] = new int[26];
		int count[] = new int[50];
		
		//알파벳을 받은 배열 출력
		for(int i=0;i<alphabet.length;i++) {
			
		}
		
	}

}
