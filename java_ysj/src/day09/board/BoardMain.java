package day09.board;

import java.util.Scanner;

public class BoardMain {
	private static Scanner sc = new Scanner(System.in);
	private static Board [] boardList = new Board[5];	//게시글 목록
	private static int boardNum = 1;	//추가될 게시글 번호
	private static int count = 0;	//현재 등록된 게시글 개수
	
	/* 게시판에서 게시글 관리를 위한 콘솔 프로그램 작성하세요.
	 * - 제한사항 정리
	 *   - 게시판은 1개
	 *   - 로그인, 회원가입 구현 X => 게시글 작성 시 아이디를 입력
	 *   - 게시글 제목과 내용은 한 줄만 가능
	 *   - 작성일을 입력
	 *   ------------------------------
	 * 1. 필요한 기능을 정리해서 메뉴로 출력
	 * 메뉴
	 *   1. 게시글 목록 조회
	 *   2. 게시글 등록
	 *   3. 프로그램 종료
	 *   메뉴 선택 : 1
	 * 게시글 목록
	 *   2. 가입인사 2023-12-20 asd 1
	 *   1. 공지 2023-12-19 admin 3
	 * 메뉴
	 * 	 1. 게시글 상세 조회
	 *   2. 게시글 수정
	 *   3. 게시글 삭제
	 *   4. 뒤로가기
	 *   메뉴 선택 : 1
	 *   조회할 게시글 번호 : 2
	 *   번호 : 2
	 *   제목 : 가입인사
	 *   내용 : 안녕하세요.
	 *   일자 : 2023-12-20
	 *   작성자: asd
	 *   조회수: 2
	 * 게시글 목록
	 *   2. 가입인사 2023-12-20 asd 1
	 *   1. 공지 2023-12-19 admin 3
	 * 메뉴
	 * 	 1. 게시글 상세 조회
	 *   2. 게시글 수정
	 *   3. 게시글 삭제
	 *   4. 뒤로가기
	 *   메뉴 선택 : 2
	 *   수정할 게시글 번호 : 2
	 *   제목 : 가입인사입니다.
	 *   내용 : 만나서 반갑습니다.
	 *   수정이 완료됐습니다.
	 * 게시글 목록
	 *   2. 가입인사입니다. 2023-12-20 asd 2
	 *   1. 공지 2023-12-19 admin 3
	 * 메뉴
	 * 	 1. 게시글 상세 조회
	 *   2. 게시글 수정
	 *   3. 게시글 삭제
	 *   4. 뒤로가기
	 *   메뉴 선택 : 3
	 *   삭제할 게시글 번호 : 1
	 *   게시글이 삭제됐습니다.
	 * 게시글 목록
	 *   2. 가입인사 2023-12-20 asd 1
	 * 메뉴
	 * 	 1. 게시글 상세 조회
	 *   2. 게시글 수정
	 *   3. 게시글 삭제
	 *   4. 뒤로가기
	 *   메뉴 선택 : 4
	 * 메뉴
	 *   1. 게시글 목록 조회
	 *   2. 게시글 등록
	 *   3. 프로그램 종료
	 *   메뉴 선택 :2
	 *   제목 : 테스트
	 *   내용 : 테스트
	 *   일자 : 2023-12-20
	 *   아이디: qwe
	 *   등록이 완료됐습니다.
	 * 메뉴
	 *   1. 게시글 목록 조회
	 *   2. 게시글 등록
	 *   3. 프로그램 종료
	 *   메뉴 선택 : 1
	 * 게시글 목록
	 *   3. 테스트 2023-12-20 qwe 0
	 *   2. 가입인사입니다. 2023-12-20 asd 2
	 * 메뉴
	 * 	 1. 게시글 상세 조회
	 *   2. 게시글 수정
	 *   3. 게시글 삭제
	 *   4. 뒤로가기
	 *   메뉴 선택 : 
	 * 2. 기능을 구현
	 * */
	public static void main(String[] args) {

		//반복문
		int menu;
		do {
			//메뉴출력
			printMenu();
			//메뉴선택
			menu = sc.nextInt();
			//선택한 기능 실행
			runMenu(menu);	//주어진 menu에 맞게 실행되도록
			
		}while(menu != 3);
	}

	/** parameter 주석 : 메서드명에 갖다대면 설명이 나옴
	 * menu가 주어지면 menu에 맞는 기능을 실행하는 메서드
	 * @param menu 실행할 메뉴의 번호
	 */
	
	private static void runMenu(int menu) {

		switch(menu) {
		
		case 1 : 
			//runBoard();
			//게시글 목록 출력(번호가 높은 순으로)
			for(int i=count-1;i>=0;i--) {
				boardList[i].printInfo();
			}
			//서브메뉴 출력
			printSubmenu();
			//서브메뉴 선택
			int submenu = sc.nextInt();
			//서브메뉴에 맞는 기능 실행
			runSubmenu(submenu);
			break;
			
		case 2 : 
			//게시글 등록 기능을 구현
			insertBoard();
			//1. 게시글 배열이 필요(어느 위치에서 선언하고 생성할건지, 크기는 얼마로?)
			break;
			
		case 3 : System.out.println("프로그램 종료");
			break;
			
		default : System.out.println("잘못된 메뉴입니다.");
		}
	}
	
	private static void runSubmenu(int submenu) {
		switch(submenu) {
		case 1 :
			//게시글 상세 조회
			System.out.print("조회할 게시글 번호 : ");
			int num = sc.nextInt();
			
			break;
		case 2 :
			break;
		case 3 :
			break;
		case 4 :
			break;
		default : System.out.println("잘못된 메뉴입니다.");	break;	
		}
	}

	/** 게시글 목록 조회 시 나타나는 서브메뉴를 출력하는 메서드
	 */
	private static void printSubmenu() {
		System.out.println("--------서브 메뉴--------");
		System.out.println("1. 게시글 상세 조회");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 뒤로가기");
		System.out.println("----------------------");
		System.out.println("메뉴 선택 : ");
	}

	/**
	 * 게시글 정보를 입력받아 게시글을 등록하는 메소드
	 */
	private static void insertBoard() {
		sc.nextLine();	//입력 버퍼에 남아있는 엔터 처리
		//제목, 내용, 일자, 아이디 순으로 입력받음
		System.out.println("제목 : ");
		String title = sc.nextLine();
		System.out.println("내용 : ");
		String contents = sc.nextLine();
		System.out.println("일자 : ");
		String date = sc.next();
		System.out.println("작성자 : ");
		String writer = sc.next();
		//입력받은 정보들을 이용하여 게시글 인스턴스를 생성
		Board board = new Board(boardNum++, title, contents, writer, date);	//추가될 게시글 번호 1증가
		//생성된 인스턴스를 배열에 저장(몇번지에 저장?)
		boardList[count++] = board;	//저장된 개수를 1증가
		//배열 크기를 안늘려도 되면 종료
		if(count < boardList.length) {
			return;
		}
		
		//배열이 꽉 차면 배열을 늘려줌
		//기존 배열보다 큰 배열 생성
		Board tmpList[] = new Board[boardList.length + 5];
		//새로 생성된 배열에 기존 배열을 복사
		System.arraycopy(boardList, 0, tmpList, 0, count);
		//새로 생성된 배열을 boardList 연결
		boardList = tmpList;
	}

	private static void printMenu() {
		System.out.println("------메뉴------");
		System.out.println("1. 게시글 목록 조회");
		System.out.println("2. 게시글 등록");
		System.out.println("3. 프로그램 종료");
		System.out.println("--------------");
		System.out.print("메뉴 선택 : ");
	}
}
