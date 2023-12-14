package day05;

import java.util.Arrays;

public class ArraySortEx1 {

	public static void main(String[] args) {

		//배열 정렬 방법
		int arr[] = new int[] {1,3,5,7,2,4,6,8};	//배열이 안되있는 정렬
		
		//버블정렬
		/* 옆에 인접한 값들을 비교하여 정렬하는 방식 
		 * 1 3 5 7 2 4 6 8 
		 * 1과 3을비교-작은걸 앞쪽으로,큰걸뒤쪽으로-3과5비교-5,7-7,2-7,4-7,6-7,8
		 * 1 3 5 2 4 6 7 [8] 8이 확정
		 * 1 3 2 4 5 6 [7 8] 7과8확정(큰수라고 확정)*/
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1;j++) {
				//0번지와 1번지 비교
				if(arr[j] > arr[j+1]) {	//오름차순, 부등호만 바꾸면 내림차순
					int tmp = arr[j];
					arr [j] = arr[j+1];
					arr [j+1] = tmp;
				}
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i] + " ");
		}
		System.out.println();
		
		int arr2[] = {1,3,5,7,2,4,6,8};
		//오름차순으로 정렬
		Arrays.sort(arr2);
		
		for(int i=0;i<arr2.length;i++) {
			System.out.println(arr2[i] + " ");
		}
	}

}
