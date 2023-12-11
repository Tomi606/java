package day02;
//조건 연산자 예제
public class ConditionalOperatorEx1 {

	public static void main(String[] args) {
		
		/* 성적이 A인지 아닌지를 판별하는 예제
		 * 성적이 100이하~90이상이면 A, 아니면 A가 아님
		*/
		
		int score = 70;
		String result = " ";
		
		//score가 100보다 (작거나 같)(고), 90보다 (크거나 같)으면
		//score <=100 && score >= 90
		result = score <= 100 && score >= 90? "A학점 입니다." : "A학점이 아닙니다.";
		System.out.println(score + "점은 " + result);
		//System.out.println(score + "점은 " + "A학점입니다. A학점이 아닙니다.");
	}

}
