package day10.word;

import java.util.Scanner;

public class WordMain {

	/* 영어 단어장 프로그램을 만드세요.
	 * 제한사항
	 * 각 알파벳(A~C) 마다 5단어만 구현
	 * 단어의 뜻은 최대 2개 까지 작성 가능
	 * 
	 * 1. 기능 정리
	 * 	1. 알파벳별 단어장
	 * 		-모르는 단어는 체크해서 북마크
	 * 	2. 단어 추가하기
	 * 		-뜻 최대 2개 까지 작성
	 * 	3. 북마크 단어 보기
	 * 		-북마크 해제
	 * 	4. 단어 맞추기 게임
	 *  
	 *  
	 * 2. 틀 작성
	 * [영어 단어장]
	 * 1. 알파벳별 단어장
	 * 2. 단어 추가하기
	 * 3. 북마크 단어 보기
	 * 4. 단어 맞추기 게임
	 * 5. 종료
	 * 메뉴 선택 : 1
	 * 
	 * [알파벳별 단어장]
	 * 1. A
	 * 2. B
	 * 3. C
	 * 4. 뒤로가기
	 * 알파벳 선택 : 1
	 * 
	 * [A]
	 * attak : 폭행, 공격
	 * 엔터
	 * advance : 전진, 발전
	 * 엔터
	 * arm : 팔
	 * 엔터
	 * age : 나이, 연령
	 * 엔터
	 * art : 미술, 예술
	 * 엔터
	 * 
	 * [알파벳별 단어장]
	 * 1. A
	 * 2. B
	 * 3. C
	 * 4. 뒤로가기
	 * 알파벳 선택 : 2
	 * 
	 * [B]
	 * back : 등, 허리
	 * 엔터
	 * bar : 술집
	 * 엔터
	 * box : 상자
	 * 엔터
	 * bag : 봉투, 가방
	 * 엔터
	 * bowl : 그릇, 통
	 * 엔터
	 * 
	 * [알파벳별 단어장]
	 * 1. A
	 * 2. B
	 * 3. C
	 * 4. 뒤로가기
	 * 알파벳 선택 : 3
	 * 
	 * [C]
	 * charge : 요금
	 * 엔터
	 * crown : 왕관
	 * 엔터
	 * cup : 컵
	 * 엔터
	 * cap : 모자
	 * 엔터
	 * crop : 농작물, 수확량
	 * 엔터
	 * 
	 * 
	 * 
	 * [영어 단어장]
	 * 1. 알파벳별 단어장
	 * 2. 단어 추가하기
	 * 3. 북마크 단어 보기
	 * 4. 단어 맞추기 게임
	 * 5. 종료
	 * 메뉴 선택 : 2
	 * 
	 * [단어 추가하기]
	 * *a로 시작되는 단어는 A에 추가 ...
	 * 
	 * [영어 단어장]
	 * 1. 알파벳별 단어장
	 * 2. 단어 추가하기
	 * 3. 북마크 단어 보기
	 * 4. 단어 맞추기 게임
	 * 5. 종료
	 * 메뉴 선택 : 3
	 * 
	 * [북마크 단어 보기]
	 *  *체크한 단어만 보이게 하기
	 *  
	 *  [영어 단어장]
	 * 1. 알파벳별 단어장
	 * 2. 단어 추가하기
	 * 3. 북마크 단어 보기
	 * 4. 단어 맞추기 게임
	 * 5. 종료
	 * 메뉴 선택 : 4
	 * 
	 * [단어 맞추기 게임] *랜덤으로 나옴
	 * attack
	 * 1) 단어 뜻 입력 : 폭행
	 * 정답
	 * 2) 단어 뜻 입력 : 공격
	 * 정답
	 * 3) 단어 뜻 입력 : 폭행, 공격 or 공격, 폭행
	 * 정답
	 * 4) 단어 뜻 입력 : 다른 뜻이 들어가면
	 * 땡!
	 * 
	 * 3. 필요 메소드 구현
	 * */
	
	private static Scanner sc = new Scanner(System.in);
	private static Word a[] = new Word[5];	//단어를 넣을 배열
	private static Word b[] = new Word[5];
	private static Word c[] = new Word[5];
	
	public static void main(String[] args) {
		
		int menu = 0;
		
		do {
			//메뉴
			printMenu();
			menu = sc.nextInt();
			
			//기능 실행
			runMenu(menu);
			
		}while(menu != 4);
		
	}

	private static void runMenu(int menu) {
		
		switch(menu) {
		
		case 1 : 
			printMenu1();
			int alphabet = sc.nextInt();
			printAlphabet(alphabet);
			break;
			
		case 2 : 
			break;
			
		case 3 : 
			break;
			
		case 4 : System.out.println("프로그램을 종료합니다.");	break;
			
		default : System.out.println("없는 메뉴입니다.");	break;
		}
		
	}

	private static void printAlphabet(int alphabet) {
		switch(alphabet) {
		
		case 1 : 
			for(int i=0;i<a.length;i++) {
				String[] Word = {"attack","advance","arm","age","art"};
				String[] Mean = {"폭행, 공격","전진, 발전","팔","나이,연령","미술,예술"};
				a[i].printWord(Word[i], Mean[i]);
			}
			break;
		
		case 2 : 
			
			break;
			
		case 3 : 
			
			break;
			
		default : System.out.println("없는 알파벳 입니다.");
		}
		
	}

	private static void printMenu1() {
		System.out.println("[알파벳별 단어장]");
		System.out.println("1. a");
		System.out.println("2. b");
		System.out.println("3. c");
		System.out.println("4. 뒤로가기");
		System.out.println("알파벳 선택 : ");
	}

	private static void printMenu() {
		System.out.println("[영어 단어장]");
		System.out.println("1. 알파벳별 단어장");
		System.out.println("2. 단어 추가하기");
		System.out.println("3. 북마크 단어 보기");
		System.out.println("4. 종료");
		System.out.print("메뉴 선택 :");
	}

}
