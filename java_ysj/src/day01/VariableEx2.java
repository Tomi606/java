package day01;
//정수형(byte, short, int, long) 선언 예제
public class VariableEx2 {

	public static void main(String[] args) {

		byte num1 = 1;
		System.out.println(num1);
		
		//byte는 -128~127까지 표현 가능하기 때문에 128을 저장할 수 없다.
		//byte num2 = 128;
		
		//형 변환 + byte의 양수 표현 범위를 넘어서 "오버플로우" 발생하여 -128이 됨
		byte num3 = (byte)(127+1);
		System.out.println(num3);
		//byte의 음수 표현 범위를 넘어서 "언더플로우" 발생해 127이 됨
		byte num4 = (byte)(-128-1);
		System.out.println(num4);
		
		int num5 = 128;
		System.out.println(num5);
		//int의 양수 표현 범위를 넘어서 저장할 수 없다.
		//int num6 = 123456789123;
		
		int num6 = 010;		//8진수(0) 10
		int num7 = 0x10;	//16진수(0x) 10
		int num8 = 0b10;	//2진수(0b) 10
		System.out.println(num6);
		System.out.println(num7);
		System.out.println(num8);
		
		//큰 수로 초기화 하는 경우, 기본 타입이 int 이기때문에 뒤에 접미사 L, l을 붙여야 함
		long num10 = 123456789123L;
		System.out.println(num10);
	}

}
