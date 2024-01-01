package day15.word;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class WordProgram implements Program {

	private static Scanner sc = new Scanner(System.in);
	private static List<Word> list = new ArrayList<Word>();
	
	int menu = 0;
	@Override
	public void run() {
		do {
		printMenu();
		try {
		menu = sc.nextInt();
		runMenu(menu);
		} catch(InputMismatchException e) {
			System.out.println("없는 메뉴입니다.");
		}
		}while(menu != 5);
	}
	
	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1 : insertWord();
			break;
			
		case 2 : updateWord();
			break;
			
		case 3 : deleteWord();
			break;
			
		case 4 : searchWord();
			break;
			
		case 5 : System.out.println("프로그램을 종료합니다.");
			break;
			
		default : throw new InputMismatchException();
		}
		
	}
	
	//4. 단어 조회
	private void searchWord() {
		for(Word tmp : list) {
			tmp.print();
		}
	}

	//3. 단어 삭제
	private void deleteWord() {
		System.out.print("단어 입력 : ");
		sc.nextLine();
		String word = sc.nextLine();
		System.out.print("뜻 입력 : ");
		String mean = sc.nextLine();
		
		Word tmp = new Word(word, mean);
		if(list.remove(tmp)) {
			System.out.println("단어가 삭제되었습니다.");
		} else {
			System.out.println("등록되지 않은 단어입니다.");
		}
	}

	//2. 단어 수정
	private void updateWord() {
		//기존 단어, 뜻 입력
		System.out.print("단어 입력 : ");
		sc.nextLine();
		String word = sc.nextLine();
		System.out.print("뜻 입력 : ");
		String mean = sc.nextLine();
		
		Word tmp = new Word(word, mean);
		int index = list.indexOf(tmp);
		
		if(index == -1) {
			System.out.println("등록되지 않은 단어입니다.");
			return;
		}
		
		tmp = list.get(index);
		System.out.print("수정할 단어 입력 : ");
		word = sc.nextLine();
		System.out.print("수정할 뜻 입력 : ");
		mean = sc.nextLine();
		
		Word newWord = new Word(word, mean);
		
		//수정할 단어 인스턴스에 기존 단어를 업데이트하고 + 삭제 후 저장
		newWord.setWord(tmp.getWord());
		newWord.setMean(tmp.getMean());
		
		list.remove(index);
		list.add(newWord);
		System.out.println("단어가 수정되었습니다.");
		System.out.println(list);
		
	}

	//1. 단어 추가
	private void insertWord() {
		System.out.print("단어 입력 : ");
		sc.nextLine();
		String word = sc.nextLine();
		System.out.print("뜻 입력 : ");
		String mean = sc.nextLine();
		
		//없는 단어, 뜻이면 추가
		Word tmp = new Word(word, mean);
		if(!list.contains(tmp)) {
			list.add(tmp);
			System.out.println("단어 추가 완료");
			return;
		}
		System.out.println("이미 등록된 단어 입니다.");
	}

	@Override
	public void printMenu() {
		System.out.println("----메뉴----");
		System.out.println("1. 단어 추가");
		System.out.println("2. 단어 수정");
		System.out.println("3. 단어 삭제");
		System.out.println("4. 단어 조회");
		System.out.println("5. 종료");
		System.out.println("---------");
		System.out.print("메뉴 선택 : ");


	}

	

}
