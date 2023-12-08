package day01;
//강제(명시적) 자료 형 변환 예제
public class TypeCastingEx2 {

	public static void main(String[] args) {

		//실수값인 3.14를 정수형 변수에 저장하면 소수점이 사라지기 때문에 자동으로 변환이 안됨 -> 강제 형 변환
		int num1 = (int)3.14;
		System.out.println(num1);
		
		//num1에 3이 저장되있어서 byte에 바로 저장할 수 있는 것처럼 보이지만, num1은 타입이 중요하기 때문에 자동 변환X -> 강제 형 변환
		byte num2 = (byte)num1;
		System.out.println(num2);
		
		byte num3 =(byte)128;
		System.out.println(num3);
		
		//에러가 발생하지 않지만 필요에 의해 형변환 하는 경우
		System.out.println(1/2);	//정수로 떨어진다
		System.out.println((double)1/2);
		System.out.println(1.0/2.0);
		
		
		//같은 타입의 변수를 여러개 선언하는 경우
		int num5, num6, num7;	//콤마 이용하여 선언
		int num8=1, num9=2, num0=3;	//바로 초기화 가능
	}

}
