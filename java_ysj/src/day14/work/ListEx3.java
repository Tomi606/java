package day14.work;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx3 {

	public static void main(String[] args) {
		//속담을 입력받아 저장하고, 출력하는 코드를 작성하세요.
		
		ArrayList<String> list = new ArrayList<String>();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("속담 입력 : ");
		int count = 5;
		for(int i=0;i<count;i++) { 
			String tmp = sc.nextLine();
			list.add(tmp);
		}
		
		for(String tmp : list) {
			System.out.println(tmp);
		}
	}

}
