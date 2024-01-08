package word.service;

public class PrintServiceImp implements PrintService {

	//메인 메뉴
	@Override
	public void printMainMenu() {
		System.out.println("-------메뉴-------");
		System.out.println("1. 단어 관리");
		System.out.println("2. 뜻 관리");
		System.out.println("3. 조회");
		System.out.println("4. 게임");
		System.out.println("5. 종료");
		System.out.println("-----------------");
		System.out.print("메뉴 선택 : ");		
	}

	//단어 메뉴
	@Override
	public void printWordMenu() {
		System.out.println("-----단어 메뉴-----");
		System.out.println("1. 단어 추가");
		System.out.println("2. 단어 수정");
		System.out.println("3. 단어 삭제");
		System.out.println("4. 뒤로가기");
		System.out.println("----------------");
		System.out.print("메뉴 선택 : ");	
	}

	//뜻 메뉴
	@Override
	public void printMeanMenu() {
		System.out.println("------뜻 메뉴------");
		System.out.println("1. 뜻 추가");
		System.out.println("2. 뜻 수정");
		System.out.println("3. 뜻 삭제");
		System.out.println("4. 뒤로가기");
		System.out.println("-----------------");
		System.out.print("메뉴 선택 : ");	
	}

	@Override
	public void printPrintMenu() {
		System.out.println("------조회------");
		System.out.println("1. 전체 조회");
		System.out.println("2. 검색 조회");
		System.out.println("3. 전체 조회(조회순)");
		System.out.println("4. 뒤로가기");
		System.out.println("---------------");
		System.out.print("메뉴 선택 : ");	
	}

	@Override
	public void printGameMenu() {
		System.out.println("------게임------");
		System.out.println("1. 게임 시작");
		System.out.println("2. 오답 노트");
		System.out.println("3. 오답 초기화");
		System.out.println("4. 뒤로가기");
		System.out.println("---------------");
		System.out.print("메뉴 선택 : ");	
	}


}
