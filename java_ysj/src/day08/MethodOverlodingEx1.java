package day08;

public class MethodOverlodingEx1 {

	public static void main(String[] args) {

		System.out.println(sum(1,2));		//1
		System.out.println(sum(1.2, 2.3));	//2
		System.out.println();
		System.out.println(sum(1,2,3));		//4
	}

	//1. 두 정수의 합을 알려주는 메소드
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}
	
	//2. 두 실수의 합을 알려주는 메소드
	public static double sum(double num1, double num2) {	//메소드명이 같지만 오버로딩
		return num1 + num2;
	}
	
	//3. 아래 메서드는 1번 메서드와 매개변수의 개수도 같고, 자료형(int)도 같기때문에 메서드 오버로딩 X -> 에러 발생
	/*
	public static double sum(int num1, int num2) {
		return num1 + num2;
	}
	*/
	
	//4. 세 정수의 합
	public static int sum(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}
}
