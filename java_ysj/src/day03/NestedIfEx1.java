package day03;
//중첩 if 문
public class NestedIfEx1 {

	public static void main(String[] args) {

		//2의 배수이면 2의 배수라고 출력하고, 6의 배수이면 6의 배수라고 출력하고
		//2, 6의 배수가 아니면 2, 6의 배수가 아님이라고 출력하는 예제
		
		int num = 9;
		
		//중첩 if 문
		//2의 배수를 체크 => num을 2로 나누었을때 나머지가 0
		if(num%2==0) {
			//3의 배수(6이 3의 배수이기도 해서)
			if(num%3==0) {
				System.out.println(num + "은 6의 배수");
			} else {
				System.out.println(num + "은 2의 배수");
			}
		}else {
			System.out.println("2, 6의 배수가 아닙니다.");
		}
		
		//중첩 if를 사용안함
		if(num%2==0 && num%3==0) {
			System.out.println(num + "은 6의 배수");
		}else if(num%2==0) {
			System.out.println(num + "은 6의 배수");
		}else {
			System.out.println("2, 6의 배수가 아닙니다.");

		}
		
	}

}
