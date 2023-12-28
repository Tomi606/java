package day14;

import java.text.DecimalFormat;

public class DecimalFormatEx1 {

	public static void main(String[] args) {

		//종종 사용
		long num = 100000000;	//중간에 콤마넣어서 표현
		DecimalFormat df = new DecimalFormat("###,###");	//3자리마다 콤마
		System.out.println(df.format(num));
		
		int num2 = 5;
		DecimalFormat df2 = new DecimalFormat("00000");
		System.out.println(df2.format(num2));
	}

}
