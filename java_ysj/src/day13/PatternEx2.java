package day13;

import java.util.regex.Pattern;

public class PatternEx2 {

	public static void main(String[] args) {
		/* 아이디를 입력받아 아이디 형식에 맞는지 틀린지를 출력하는 프로그램을 작성하세요. 
		 * 아이디 정규표현식 : 영문+숫자로 구성, 8~13자
		 * 아이디 : abc
		 * 아이디 형식에 맞지 않습니다.
		 * 
		 *  아이디 : abcd1234
		 *  아이디로 사용 가능합니다.
		 *  */
		
		String id = "qwer1234";
		String regex = "^[a-zA-Z0-9]{8,13}$";
		//^\w{8,13}$ -> 왜 안되지? -> 문자열에서 역슬래쉬는 기능이 있다.
		//그래서 역슬래쉬를 한번 더 적어준다. -> ^\\w{8,13}$
		if(Pattern.matches(regex, id)) {
			System.out.println("아이디로 사용 가능합니다.");
		} else {
			System.out.println("아이디 형식에 맞지 않습니다.");
		}
	}

}
