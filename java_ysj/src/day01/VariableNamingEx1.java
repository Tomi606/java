package day01;
//변수명 착성규칙(필수)과 관례(선택이지만 추천)
public class VariableNamingEx1 {

	public static void main(String[] args) {

		//1. 대소문자를 구분
		int num;
		int NUM;
		int Num;
		int nUm;
		int nuM;
		
		//2. 예약어 사용 불가능
		//int int;
		//int double;
		//int public;
		//int class;
		//int void;
		
		//3. 숫자로 시작 불가능
		  int num1;
		//int 1num;
		  int nu1m;
		  
		//4. 특수문자는 _ 와 $만 가능
		  int _num;
		  int num$;
		//int #num;
		//int  num;(띄어쓰기도 안됨)
		  
		//5. 중복선언 불가능
		//int num;
	
	}

}
