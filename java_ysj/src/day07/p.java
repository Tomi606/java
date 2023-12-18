package day07;

public class p {

	public static void main(String[] args) {
		//주어진 num이 소수인지 아닌지(boolean)
		int num = 3;
		if(isPrimeNumber(num)) {
			System.out.println();
		}
	}

	public static boolean isPrimeNumber(int num) {
		for(int i=2;i<num;i++) {
		if(isDivisor(num, i)) {
			return false;
			}
		}
		return num != 1;
	}
	
	
	//num1 % num2가 0일경우
	public static boolean isDivisor(int num1, int num2) {
		return num1 % num2 == 0;
	}
}
