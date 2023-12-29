package day13.console;

//구현한 클래스를 사용
public class ConsoleProgramEx1 {

	public static void main(String[] args) {
		/*
		ConsoleProgram cp = new ConsoleProgram();
		cp.run();	//프로그램 실행, main은 이게 끝 */
		
		//형변환 : 인터페이스와 구현 클래스 사이에서 형변환 가능
		//인터페이스 = 구현 클래스
		Program p = new ConsoleProgram();
		p.run();
	}
	
}
