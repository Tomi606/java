package day03;
//switch 문 예제
public class SwitchEx1 {

	public static void main(String[] args) {

		/*정수가 0인지 아닌지 판별하는 예제
		 * A가 B와 같다면 ~해라
		 * if(num%2 == 0)
		 * A : num%2는 변수 식 괄호에 다가,
		 * B : 0은 case에 넣으면 됨*/
		
		int num = 0;
		
		switch(num) {
		case 0 :
			System.out.println("0 입니다.");
			break;
			
		default :
			System.out.println(num +"은 0이 아닙니다.");
		}
		
	}

}
