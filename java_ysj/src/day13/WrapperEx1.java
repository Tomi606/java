package day13;

public class WrapperEx1 {

	public static void main(String[] args) {
		int num1 = 1;
		Integer num2 = 1;
		num2 = null;	//null로 초기화
		num2 = num1;	//num1을 num2에 저장
		System.out.println(num2);
		
		num2 = 20;
		num1 = num2;
		System.out.println(num1);
		
		/* 널포인트익셉션 : num2가 null이라서 int로 저장할 수 없다.
		num2 = null;
		num1 = num2;
		System.out.println(num1);
		*/
		
		//문자열을 정수로
		String str = "12345";
		int num3 = Integer.parseInt(str);
		System.out.println(num3 * 10);	//*10 : 정수로 변환되어서 곱해지는 걸 보여주기 위해
	}

}
