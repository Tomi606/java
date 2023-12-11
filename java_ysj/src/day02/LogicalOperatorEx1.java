package day02;
//논리 연산자 예제 : A와 B는 참/거짓을 판별할 수 있는 식 또는 변수
public class LogicalOperatorEx1 {

	public static void main(String[] args) {

		/* && : and, ~이고, A&&B
		 * 성적이 100이하 이고, 90 이상이면 A / 성적이 95 => true
		 * 100이고, 90 이다, A / 성적이 95 => 무엇이 100이고 90인지 모르기 때문에 판별 X => 에러발생
		 * 
		 * -진리표 A&&B
		 * F&&F => false
		 * F&&T => false
		 * T&&F => false
		 * T&&T => true(둘 다 참일때 참)
		 * 
		 * || : or, ~이거나, A||B
		 * -진리표 A||B
		 * F||F => false(둘 다 거짓일때 거짓)
		 * F||T => true(하나라도 참이면 참)
		 * T||F => true
		 * T||T => true
		 * 
		 * ! : ~아닌, 반대
		 * -!A
		 * F => T
		 * T => F
		 */
		
		int score = 99;
		//성적이 올바른지 확인하는 작업, 올바른 성적은 0~100(범위를 넘어가면 잘못된 성적)
		//성적이 0이상이고, 100이하이다.
		//성적이 0보다 (크거나 같)(고), 성적이 100보다 (작거나 같다).
		//성적 >=0 && 성적 <=100
		System.out.println(score + "점은 올바른 성적인가? " + (score>=0 && score <=100));
		
		//앞 결과와 반대로 출력
		System.out.println(score + "점은 올바른 성적이 아닌가? " + !(score>=0 && score <=100));
		
		//성적이 올바른지 아닌지 확인. 올바르지 않은 성적인 0미만, 100초과
		//성적이 0미만이거나, 100초과이다.
		//성적이 0보다 (작)(거나), 성적이 100보다 (크다)
		//성적 < 0 || 성적 > 100
		System.out.println(score + "점은 올바른 성적이 아닌가? " + (score < 0 && score > 100));

	}

}
