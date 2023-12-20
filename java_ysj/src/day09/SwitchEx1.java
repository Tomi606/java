package day09;

public class SwitchEx1 {

	public static void main(String[] args) {

		//switch 문 안에 지역 변수를 선언하는 경우 발생할 수 있는 문제점
		for(int i=0;i<5;i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for(int i=0;i<5;i++) {
			System.out.print(i + " ");
		}//int i를 각각써도 상관 없다
		System.out.println();
		
		int menu = 1;
		switch(menu) {
		case 1 :
			//여기서 선언된 num가 break문이 없으면 case 2까지
			//갈 수 있기 때문에 여기서 선언된 num은 이후 switch
			//아래 코드에서 사용할 수 있다.
			int num = 10;
			System.out.println(num);
			break;
		case 2 :
			//int num = 20; 을하면 위에서 선언된 num와 중복, 에러 발생 / 그래서 지역변수는 switch문 밖에다 놓고 사용
			num = 20;
			System.out.println(num);
			break;
				
		}
	}

}
