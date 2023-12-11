package day02;
//홀짝 판별 예제
public class TestEx2 {

	public static void main(String[] args) {

		//num이 홀수이면 홀수라 출력, 짝수이면 짝수라 출력하는 코드를 작성하시오.
		int num = 3;
		
		if(num%2==0) {
			System.out.println(num + "은 짝수 입니다.");
		} else {
			System.out.println(num + "은 홀수 입니다.");
		}
	}

}
