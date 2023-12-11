package day02;
//if 문 예제
public class IfEx1 {

	public static void main(String[] args) {

		/* ...이면 ~이다 : 조건문
		 * ... : 조건식, ~ : 실행문
		 * if(조건식) {
		 * 		실행문;
		 * }
		 * */
		
		//정수가 0이면 0이라고 출력하고, 정수가 0이 아니면 0이 아닙니다라고 출력하는 코드
		int num = 10;
		if(num == 0) {
			System.out.println(0);
		}
		//정수가 0이 아니면 0이 아닙니다
		if(num != 0) {
			System.out.println("0이 아닙니다.");
		}
		//if를 2번쓰면 각 if문을 무조건 다 확인한다.
	}

}
