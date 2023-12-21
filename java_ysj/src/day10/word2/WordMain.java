package day10.word2;

import java.util.Scanner;

public class WordMain {
	private static Scanner sc = new Scanner(System.in);
	private static Word[] list= new Word[10];	//단어장
	private static int count = 0;	//저장된 단어 개수
	
	public static void main(String[] args) {
		int menu = 0;
		do {
			printMenu();
			menu = sc.nextInt();
			
			runMenu(menu);
		}while(menu != 5);
	}

	private static void runMenu(int menu) {
		switch(menu) {
		case 1 :
			insertWord();
			break;
			
		case 2 : 
			searchWord();
			break;
			
		case 3 : 
			updateWord();
			break;
			
		case 4 : 
			deleteWord();
			break;
			
		case 5 : System.out.println("프로그램 종료!");	break;
			
		default : System.out.println("잘못된 입력입니다");
		}
	}

	//4. 단어 삭제
	private static void deleteWord() {	//배열 미루는 작업
		//삭제할 단어 입력
		System.out.println("삭제할 단어 입력 : ");
		String word = sc.next();
		
		//단어장에서 단어를 삭제
		//삭제할 위치를 찾음
		//반복문 : 저장된 개수만큼 반복
		int index = -1;	//찾으면 0 이상이라서 -1로 초기화(배열의 번지는 0이상)
		for(int i=0;i<count;i++) {
			//입력한 단어와 같으면
			if(list[i].equals(word)) {
				//현재 위치를 index에 저장
				index = i;
				//break; index를 처음부터 -1이라고 가정했기때문(없다고 판단했기에)
			}
		}
		//일치하는 단어가 없으면
		if(index == -1) {
			//안내문구 출력 후 종료
			System.out.println("일치하는 단어가 없습니다.");
			return;
		}
		//저장된 단어의 개수를 1 줄임
		count--;
		System.out.println("삭제가 완료되었습니다.");
		//일치하는 단어가 마지막 단어이면
		if(index == count) {	//count가 1감소 했기에
			return;
			//종료
		}
		//한 칸씩 당겨오기(빈칸 없애기 위한 추가작업)
		//현재 배열과 같은 크기의 새 배열을 생성
		Word[] tmpList = new Word[list.length];
		//새 배열에 현재 배열을 복붙
		System.arraycopy(list, 0, tmpList, 0, list.length);
		//현재 배열에서 index + 1 번지 부터 단어가 있는 마지막 번지까지
		//복사해서 새 배열에 index 번지 부터 복붙
		System.arraycopy(tmpList, index + 1, list, index, count - index);
		/* 1 2 3 4
		 * 2(index [1] 자리) 삭제, 2자리를 땡겨옴(3 4를 2자리로)
		 * index = 1, count = 2 */
	}

	//3. 단어 수정
	private static void updateWord() {
		//단어와 뜻을 입력
		System.out.println("수정할 단어 선택 : ");
		String word = sc.next();		
		System.out.println("의미 : ");
		sc.nextLine();
		String mean = sc.nextLine();
		
		//해당 단어의 뜻을 수정
		//반복문 : 저장된 개수만큼
		for(int i=0;i<count;i++) {		
			//입력한 단어와 단어가 같으면
			if(list[i].equals(word)) {
				//뜻을 수정하고 종료
				list[i].update(mean);
				System.out.print("단어가 수정되었습니다.");
				return;
			}
		}
		//반복문이 끝날때까지 안나오면 일치하는 단어가 없다고 출력
		System.out.println("찾는 단어가 없습니다.");
	}

	//2. 단어 검색
	private static void searchWord() {
		System.out.println("단어 검색 : ");
		String word = sc.next();
		//반복문 : 저장된 개수만큼
		for(int i=0;i<count;i++) {
			//단어장에 단어가 주어진 단어와 일치하면
			if(list[i].equals(word)) {	//단어는 .equals() 사용
				//출력 후 종료
				list[i].print();
				return;
			}
		}
		//단어가 없다고 출력
		System.out.println("일치하는 단어가 없습니다.");
	}

	//1. 단어 등록
	private static void insertWord() {
		//단어와 뜻 입력받음
		System.out.print("단어 : ");
		String word = sc.next();	//단어는 공백없는 한 단어(문자)
		
		System.out.print("의미 : ");
		sc.nextLine();	//엔터처리
		String meaning = sc.nextLine();	//뜻은 문자열
		
		//단어와 뜻을 이용하여 Word 클래스의 인스턴스를 생성
		Word tmp = new Word(word, meaning);
		
		//위에서 생성한 인스턴스를 단어장에 저장 + 저장된 단어의 개수를 1증가
		list[count++] = tmp;
		
		//테스트용으로 단어장 목록 출력
		for(int i=0; i<count;i++) {
			list[i].print();
		}
		
		//단어장이 꽉 차면 단어장 크기를 늘림
		if(count == list.length) {
			expandWordList();
		}
	}
	//배열확장(기존 단어장보다 큰 새 단어장 생성)
	private static void expandWordList() {
		Word[] tmpList = new Word[list.length + 10];
		//새 단어장에 기존 단어들을 복붙
		System.arraycopy(list, 0, tmpList, 0, count);
		//새 단어장을 내 단어장이라고 선언
		list = tmpList;
	}

	//메뉴
	private static void printMenu() {
		System.out.println("------------");
		System.out.println("1. 단어 등록");
		System.out.println("2. 단어 검색");
		System.out.println("3. 단어 수정");
		System.out.println("4. 단어 삭제");
		System.out.println("5. 종료");
		System.out.print("메뉴 선택 : ");	
	}

}
