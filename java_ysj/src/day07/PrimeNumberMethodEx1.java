package day07;

public class PrimeNumberMethodEx1 {

	public static void main(String[] args) {
		//주어진 num가 소수인지 아닌지 판별하는 코드를 작성하시오. (메소드 이용)
		
		int num = 4;
		if(isPrimeNumber(num)) {
			System.out.println(num + "은 소수");
		}else {
			System.out.println(num + "은 소수가 아님");
		}
	
		if(isPrimeNumber2(num)) {
			System.out.println(num + "은 소수");
		}else {
			System.out.println(num + "은 소수가 아님");
		}
	}

	//1.
	/* 기능 : 주어진 정수가 소수이면 소수라고 알려주고 아니면 아니라고 알려주는 메소드
	 * 매개변수 : 정수 -> int num
	 * 리턴타입 : 소수인지 아닌지 -> boolean
	 * 메소드명 : isPrimeNumber
	 * */
	public static boolean isPrimeNumber(int num) {
		//약수의 개수가 2개면 소수, 아니면 소수가 아님
		int count = 0; //약수의 개수
		for(int i=1;i<=num;i++) {
			if(isDivisor(num, i)) {	//약수이면
				count++;	//증가해라
			}
		}
		if(count ==2) {
			return true;	//count가 2이면 참
		}
		return false;	//else : 아니면 거짓
	}
	
	//2.
	//1과 자기자신을 제외한 약수가 존재하면 소수가 아니고, 존재하지 않으면 소수
	/* 기능 : 주어진 정수가 소수이면 소수라고 알려주고 아니면 아니라고 알려주는 메소드
	 * 매개변수 : 정수 -> int num
	 * 리턴타입 : 소수인지 아닌지 -> boolean
	 * 메소드명 : isPrimeNumber2
	 * */
	public static boolean isPrimeNumber2(int num) {
		for(int i=2;i<num;i++) {
			if(isDivisor(num, i)) {
				return false;
			}
		}
		return num != 1;	//1은 소수가 아님
	}
	
	/*
	 * 기능 : 정수 num1과 정수 num2가 주어졌을때 num2가 num1의 약수이면 참, 아니면 거짓을 알려주는 메소드
	 * 매개변수 : 정수 num1과 정수 num2 -> int num1, int num2
	 * 리턴타입 : 약수이거나 아니거나 -> boolean
	 * 메소드명 : isDivisor
	 * */
	public static boolean isDivisor(int num1, int num2) {
		return num1 % num2 == 0;
	}
}
