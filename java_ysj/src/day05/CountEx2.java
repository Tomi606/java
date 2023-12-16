package day05;

import java.util.Arrays;

public class CountEx2 {

	public static void main(String []args) {
		
		/* 1~10까지의 랜덤 수 5개를 받고, 받은 수와 갯수만 출력하시오. */
		
		//정수 5배열
		int arr[] = new int[5];
		//1~10사이 갯수 배열
		int count[] = new int[11];
		
		//1~10사이 랜덤 숫자 받고, 생성된 숫자 카운트 증가
		for(int i=0;i<arr.length;i++) {
			int r = (int)(Math.random()*10+ 1);
			arr[i] = r;
			System.out.print(arr[i]+" ");
			count[arr[i]]++;
		}
		System.out.println();
		
		//count 출력
		for(int i=1;i<=count.length;i++) {
			if(count[i]!=0) {	//count가 0이 아닐때만 출력하는 코드
				System.out.println(i+" : " + count[i]);
			}
		}
		
	}
}
