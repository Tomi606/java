package day01;
//자동 자료 형 변환 예제 : 작은 자료형 값을 -> 큰 자료형으로 변환, 정수 -> 실수로 변환, 데이터 손실 X
public class TypeCastingEx1 {

	public static void main(String []args) {
		
		double num1 = 1; 
		//자동 자료 형변환이 일어남
		//리터럴 1은 타입이 int, num1 타입은 double -> 리터럴 1을 num1에 저장하기 위해 int를 double로 자동 형변환 됨
		System.out.println(num1);
		
		//리터럴 2는 타입이 int, num2 타입은 long -> 자동 형변환에 의해 int값 2를 long에 저장(long>int)
		long num2 = 2;
		System.out.println(num2);

		//'a'의 아스키코드 값인 97이 num3에 저장
		char ch = 'a';
		int num3 = ch;
		System.out.println(num3);
	}
}
