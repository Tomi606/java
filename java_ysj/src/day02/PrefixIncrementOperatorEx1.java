package day02;
//증감 연산자 예제
public class PrefixIncrementOperatorEx1 {

	public static void main(String[] args) {

		int num1 = 1, num2 = 1;
		//num1은 전위형, num2은 후위형 증가 연산자
		System.out.println("증가 전 : num1 = " + num1 + ", num2 = " + num2);
		//num1은 1 -> 2로 증가 후, "증가 중 : num1 = " 라는 문자열과 더함
		//num2는 ", num2 = " 라는 문자열과 더해 진 후, 1 -> 2로 증가
		System.out.println("증가 중 : num1 = " + ++num1 + ", num2 = " + num2++);
		System.out.println("증가 후 : num1 = " + num1 + ", num2 = " + num2);	//최종적으로는 1증가
		
		System.out.println("==================================");
		//전위형과 후위형이 이해되지 않아 전위형 하나만을 이용하여 후위형도 구현할려고 한다.
		num1 = 1;
		num2 = 1;
		System.out.println("증가 전 : num1 = " + num1 + ", num2 = " + num2);
		++num1;	//num1 = num1 + 1;
		System.out.println("증가 중 : num1 = " + num1 + ", num2 = " + num2);
		++num2; //num2 = num2 + 1;
		System.out.println("증가 후 : num1 = " + num1 + ", num2 = " + num2);
		
		
	}

}
