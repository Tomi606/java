package day02;
//if else if문 예제
public class IfElseIfEx1 {

	public static void main(String[] args) {

		int num = -3;
		//num이 0이면 0이라고 출력, num이 양수이면 양수라고 출력, num이 음수이면 음수라고 출력하는 코드
		if(num == 0) {
			System.out.println("0 입니다.");
		} else if(num>0) {
			System.out.println("양수 입니다.");
		} else {
			System.out.println("음수 입니다.");
		}
	}

}
