package day01;

public class TestEx1 {

	public static void main(String[] args) {

		//1. 아래 코드에서 잘못된 부분을 찾아 수정하세요.
		//char ch1 = "A";
		char ch1 = 'A';
		
		//2. 국어, 영어, 수학 성적을 입력하여 평균을 구하려 할때 필요한 변수들을 선언하세요.
		
		int Kor1 = 100;
		int Eng1 = 95;
		int Math1 = 79;
		int Standard1 = Kor1 + Eng1 + Math1;
		
		System.out.println( (Kor1+Eng1+Math1) /3);
		System.out.println(Standard1/3);
		
		double Kor2 = 100;
		double Eng2 = 95.5;
		double Math2 = 79.6;
		double Standard2 = Kor2 + Eng2 + Math2;
		
		System.out.println( (Kor2+Eng2+Math2) /3);
		System.out.println(Standard2/3);
		
	}

}
