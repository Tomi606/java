package day11.HomeworkEx2;

public class Operator {

	private int num1;
	private int num2;
	private char ch;
	
	
	
	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public char getCh() {
		return ch;
	}

	public void setCh(char ch) {
		this.ch = ch;
	}



	public void plus(int num1, char ch1, int num2) {
		int result = num1 + num2;
		System.out.println("" + num1 + ch1 + num2 + " = " + result);
	}
	
	public void subtract(int num1, char ch1, int num2) {
		int result = num1 - num2;
		System.out.println("" + num1 + ch1 + num2 + " = " + result);
	}
	
	public void times(int num1, char ch1, int num2) {
		int result = num1 * num2;
		System.out.println("" + num1 + ch1 + num2 + " = " + result);
	}
	
	public void divide(int num1, char ch1, int num2) {
		double result = (double)num1 / num2;
		System.out.println("" + num1 + ch1 + num2 + " = " + result);
	}
	
	public void remain(int num1, char ch1, int num2) {
		int result = num1 % num2;
		System.out.println("" + num1 + ch1 + num2 + " = " + result);
	}
}
