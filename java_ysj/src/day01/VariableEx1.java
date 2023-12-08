package day01;
//문자형(char) 변수 선언 예제
public class VariableEx1 {

	public static void main(String[] args) {

		/* 변수선언방법
		 * 1. 변수 선언만
		 * 변수타입 변수명;
		 * 2.변수 선언 및 초기화
		 * 변수타입 변수명 = 변수;
		 */
		
		//1. 문자형 변수 ch1 선언
		//변수는 초기화를 하고 사용해야 함, 초기화되지 않은 ch1을 사용하려하면 에러 발생		
		char ch1;
		ch1 = '+';
		System.out.println(ch1);
		
		//2. 문자형 변수 ch2 선언 후 A로 초기화
		char ch2 = 'A';
		System.out.println(ch2);
		
		//" "는 문자열(String)을 의미, " "안에 한글자가 들어간다해서 문자가 되는게 아니라 한글자인 문자열 이다.
		//char ch3 = "A";
		
		//' '안에는 한 글자가 들어가야 함
		//char ch4 = '12';
		
		//유니코드 65에 해당하는 문자 저장
		char ch5 = '\u0065';	//a
		System.out.println(ch5);
		
		//아스키코드 65에 해당하는 문자 저장
		char ch6 = 65;
		System.out.println(ch6);
		
		//역슬래쉬가 들어간 문자 \n : 엔터, \t : 탭키만큼 공백, \\ : \문자 등
		char ch7 ='\n';
		System.out.println(ch7);	//2줄이 엔터되있다 = println + \n
		
	}
	
}
