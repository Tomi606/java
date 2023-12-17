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
		int alphabet[] = new int[26];
		int i;
		
		//1.
		//단어 입력 받기(문자-charAt)
		System.out.print("단어 입력 : ");
		String word = sc.next();
		
		//입력받은 단어 세기
		for(i=0;i<word.length();i++) {
			char ch = word.charAt(i);
			alphabet[ch-'a']++;
		}
		
		for(i=0;i<alphabet.length;i++) {
			if(alphabet[i] != 0) {
				char ch = (char)('a'+i);
				System.out.println(ch+ " : " +alphabet[i]);
			}
		}
		
		//2. 향상된 for 문 사용
		//문자받기
		System.out.print("문자 입력 : ");
		word = sc.next();
				
		//문자의 알파벳 세기
		for(i=0;i<word.length();i++) {
			 char ch = word.charAt(i);	//각 알파벳
			 alphabet[ch - 'a']++;		//각 인덱스에 1증가
		}
		
		//갯수가 0을 제외한 나머지 수 출력
		char ch = 'a';
		for(int count : alphabet) {
			if(count != 0) {
				System.out.println(ch+ " : " +count);
			}
			ch++;
		}
	}

}
