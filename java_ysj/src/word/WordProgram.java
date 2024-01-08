package word;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import program.Program;
import word.service.FileService;
import word.service.FileServiceImp;
import word.service.PrintService;
import word.service.PrintServiceImp;

public class WordProgram implements Program {

	private final int EXIT = 5;
	private final int WORD_EXIT = 4;
	private final int MEAN_EXIT = 4;
	private final int PRINT_MENU = 4;
	private final int GAME_EXIT = 4;
	
	private Scanner sc = new Scanner(System.in);
	
	private PrintService printService = new PrintServiceImp();	//출력 인터페이스
	private FileService fileService = new FileServiceImp();		//파일(로드, 세이브) 인터페이스
	
	
	private Vocabulary vocabulary = new Vocabulary(null);
	private List<Word> wrongList = new ArrayList<Word>();	//오답노트
	
	@Override
	public void run() {
		int menu = 0;
		String fileName = "src/word/wordList.txt";
		//불러오기
		List<Word> list = fileService.load(fileName);
		vocabulary = new Vocabulary(list);
		do {
			try {
				printMenu();
				menu = sc.nextInt();
				runMenu(menu);
			} catch(InputMismatchException e) {
				System.out.println("없는 메뉴입니다.");
				//메뉴를 잘못 입력하면 입력 버퍼에 잘못 입력된 메뉴가 남아있어서 비워줘야 함.
				//비워주지 않으면 무한 루프 발생
				sc.nextLine();
			}
		}while(menu != EXIT);
		
		//저장하기
		if(fileService.save(fileName, vocabulary.getList())) {
			System.out.println("저장이 완료됐습니다.");
		} else {
			System.out.println("저장에 실패했습니다.");
		}
	}


	@Override
	public void printMenu() {
		printService.printMainMenu();
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1 : 
			wordManage();
			break;
			
		case 2 : 
			meanManage();
			break;
			
		case 3 : 
			printManage();
			break;
			
		case 4 : 
			gameManage();
			break;
		
		case 5 : System.out.println("프로그램을 종료합니다");
			break;
			
		default : throw new InputMismatchException();
		}
	}


	//1. 단어 관리
	private void wordManage() {
		int menu = 0;
		do {
		//단어 관리 메뉴 출력
		printService.printWordMenu();
			try {
				//메뉴 선택
				menu = sc.nextInt();
				//메뉴 실행
				runWordMenu(menu);
			} catch(InputMismatchException e) {
				System.out.println("없는 메뉴입니다.");
				sc.nextLine();
			}
		}while(menu != WORD_EXIT);
	}

	private void runWordMenu(int menu) {
		switch(menu) {
		case 1 : addWord();
			break;
			
		case 2 : setWord();
			break;
			
		case 3 : removeWord();
			break;
			
		case 4 : System.out.println("이전 메뉴로 돌아갑니다.");
			break;
			
		default : throw new InputMismatchException();
		}
	}

	private void removeWord() {
		//삭제할 단어 입력
		System.out.println("삭제할 단어 : ");
		sc.nextLine();
		String word = sc.nextLine();
		//단어 삭제
		if(vocabulary.removeWord(word)) {
			System.out.println("단어를 삭제했습니다.");
		} else {
			System.out.println("없는 단어입니다.");
		}
	}

	private void setWord() {
		//수정할 단어와 새 단어를 입력
		System.out.println("수정할 단어 : ");
		sc.nextLine();
		String oldWord = sc.nextLine();
		System.out.println("새 단어 : ");
		String newWord = sc.nextLine();
		
		//단어 수정
		if(vocabulary.setWord(oldWord, newWord)) {
			System.out.println("단어를 수정했습니다.");
		} else {
			//없는 단어를 수정하려고 했거나 이미 등록된 단어로 수정하려고 할 때
			System.out.println("단어를 수정하지 못했습니다.");
		}
	}

	private void addWord() {
		//단어, 품사, 뜻을 입력
		System.out.print("단어 : ");
		sc.nextLine();
		String word  = sc.nextLine();
		//뜻들을 저장할 리스트
		List<Mean> meanList = new ArrayList<Mean>();
		char isContinue = 'n';
		do {
			System.out.print("품사 :");
			String partOfSpeech= sc.nextLine();
			System.out.print("의미 : ");
			String mean = sc.nextLine();
			
			meanList.add(new Mean(partOfSpeech, mean));
			System.out.println("의미를 더 추가하겠습니까?(y/n) : ");
			isContinue = sc.next().charAt(0);
		}while(isContinue == 'y');
		
		//단어장이 비어 있으면 **null 처리 꼭!(아니면 널포인트익셉션 발생)
		if(vocabulary == null) {
			System.out.println("단어장이 없습니다.");
			return;
		}
		//단어장에 추가
		if(vocabulary.addWord(word, meanList)) {
			System.out.println("단어를 추가했습니다");
		} else {
			System.out.println("뜻과 단어가 이미 등록된 상태입니다.");
		}
		//확인용
		//System.out.println(vocabulary);
	}

	
	//2. 뜻 관리
	private void meanManage() {
		int menu = 0;
		do {
		printService.printMeanMenu();
			try {
				menu = sc.nextInt();
				runMeanMenu(menu);
			} catch (InputMismatchException e) {
				System.out.println("없는 메뉴입니다.");
				sc.nextLine();
			}
		}while(menu != MEAN_EXIT);
	}

	private void runMeanMenu(int menu) {
		switch(menu) {
		case 1 : addMean();
			break;
			
		case 2 : setMean();
			break;
			
		case 3 : removeMean();
			break;
			
		case 4 : System.out.println("이전 메뉴로 돌아갑니다.");
			break;
			
		default : throw new InputMismatchException();
		}
	}

	private void removeMean() {
		//단어 입력
		System.out.print("단어 : ");
		sc.nextLine();
		String word = sc.nextLine();
		//입력한 단어와 일치하는 단어 객체를 가져옴
		Word selectedWord = vocabulary.getWord(word);
		//없는 단어이면 알림
		if(selectedWord == null) {
			System.out.println("등록되지 않은 단어입니다.");
			return;
		}
		//단어가 있으면 단어와 뜻을 출력
		selectedWord.printWord();
		
		//삭제할 단어의 번호를 입력
		System.out.println("삭제할 뜻의 번호 입력 : ");
		int index = sc.nextInt() - 1;
		
		//해당 단어의 뜻 삭제 후 알림
		if(selectedWord.removeMean(index)) {
			System.out.println("뜻을 삭제했습니다.");
		} else {//없는 번호를 쳤을 경우
			System.out.println("뜻을 삭제하지 못했습니다.");
		}
	}

	private void setMean() {
		//뜻을 수정할 단어 입력
		System.out.print("수정할 단어 : ");
		sc.nextLine();
		String word = sc.nextLine();
		
		//입력한 단어의 뜻을 출력(보캐불러리한테 일치하는 단어를 달라 명령)
		//입력한 단어와 일치하는 단어 객체를 가져옴
		Word selectedWord = vocabulary.getWord(word);
		//없는 단어이면
		if(selectedWord == null) {
			System.out.println("등록되지 않은 단어입니다.");
			return;
		}
		
		//수정할 뜻 선택
		selectedWord.printWord();
		
		//수정할 품사, 뜻을 입력
		int index = sc.nextInt() - 1;	//보이는건 1부터라서 -1 해줌
		//수정할 품사, 뜻을 입력
		System.out.print("수정할 품사 : ");
		String partOfSpeech = sc.next();
		System.out.print("수정할 뜻 : ");
		sc.nextLine();
		String mean = sc.nextLine();
		
		//뜻을 수정
		if(selectedWord.setMean(index, partOfSpeech, mean)) {
			System.out.println("의미를 수정했습니다.");
		} else {
			System.out.println("의미를 수정하지 못했습니다.");
		}
		//확인용
		//System.out.println(vocabulary);
	}

	private void addMean() {
		//뜻을 추가할 단어 입력, 품사, 뜻 입력
		System.out.print("단어 : ");
		sc.nextLine();
		String word = sc.nextLine();
		System.out.print("품사 : ");
		String partOfSpeech = sc.next();
		System.out.print("뜻 : ");
		sc.nextLine();
		String mean = sc.nextLine();
		
		//뜻 추가
		if(vocabulary.addMean(word, partOfSpeech, mean)) {
			System.out.println("새 뜻을 추가했습니다.");
		} else {
			System.out.println("새 뜻을 추가하지 못했습니다.");
		}
		//확인용
		//System.out.println(vocabulary);
		
	}

	
	//3. 조회
	private void printManage() {
		int menu = 0;
		do {
			printService.printPrintMenu();
			try {
			menu = sc.nextInt();
			runPrintMenu(menu);
			} catch (InputMismatchException e) {
				System.out.println("없는 메뉴입니다.");
			}
		}while(menu != PRINT_MENU);
	}
	
	
	private void runPrintMenu(int menu) {
		switch(menu) {
		case 1 : 
			printAll();
			break;
			
		case 2 : 
			printSearch();
			break;
			
		case 3 : 
			printAllByViews();
			break;
			
		case 4 : System.out.println("이전 메뉴로 돌아갑니다."); 
			break;
			
			
		default : throw new InputMismatchException();
		}
	}


	private void printAll() {
		vocabulary.print();
	}


	private void printSearch() {
		//검색할 단어 입력
		System.out.print("검색할 단어 : ");
		sc.nextLine();
		String word = sc.nextLine();
		
		//단어장에 검색어를 주면서 검색어를 포함한 단어를 출력하라고 요청
		vocabulary.print(word);
		
	}
		
	private void printAllByViews() {
		vocabulary.printByViews();
	}


	//4. 게임
	private void gameManage() {
		int menu = 0;
		do {
			printService.printGameMenu();
			menu = sc.nextInt();
			runGameMenu(menu);
		}while(menu != GAME_EXIT);
	}


	private void runGameMenu(int menu) {
		switch(menu) {
		case 1 :
			play();
			break;
			
		case 2 : 
			printWrongList();
			break;
			
		case 3 : 
			inItWrongList();
			break;
			
		case 4 : System.out.println("이전으로 돌아갑니다.");
			break;
			
		default : throw new InputMismatchException();
		}
	}


	private void play() {
		List<Word> gameList = new ArrayList<Word>(vocabulary.getList());
		
		if(gameList.size() == 0) {
			System.out.println("등록된 단어가 없습니다.");
			return;
		}
		//랜덤으로 단어를 섞어 줌
		Collections.shuffle(gameList);
		int win = 0, lose = 0;
		
		//반복문 : 최대 리스트 크기만큼
		while(gameList.size() != 0) {
			//0번지에 있는 단어를 꺼냄
			Word word = gameList.remove(0);
			//단어의 뜻 중에서 랜덤으로 하나 선택
			String mean = word.getRandomMean();
			//뜻이 등록되지 않은 경우
			if(mean == null) {
				continue;
			}
			//뜻 출력
			System.out.println("의미 : " + mean);
			//정답을 입력 받음
			System.out.print("단어 : ");
			sc.nextLine();
			String userMean = sc.nextLine();
			
			//맞았는지 틀렸는지 확인 및 알림 메세지
			//맞았으면 오답에서 제거
			if(word.getWord().equals(userMean)) {
				System.out.println("정답입니다.");
				win++;
				wrongList.remove(word);
			} else {
				//틀렸으면 오답에 추가
				System.out.println("오답입니다.");
				lose++;
				wrongList.add(word);
			}
			//계속 할건지 말건지 출력
			System.out.println("더 하시겠습니까?(y/n)");
			//이어하기 여부를 입력
			String isContinue = sc.next();
			//종료하면 반복문 종료
			if(isContinue.equals('n')) {
				break;
			}
		}
		//결과를 출력
		System.out.println(win + "승 " + lose + "패");
	}


	private void printWrongList() {
		if(wrongList.size() == 0) {
			System.out.println("오답이 없습니다");
			return;
		}
		wrongList.stream().forEach(w->w.printWord());	
	}


	//오답 초기화
	private void inItWrongList() {
		if(wrongList == null) {
			wrongList = new ArrayList<Word>();
		}
		wrongList.clear();
	}
	
	
}
