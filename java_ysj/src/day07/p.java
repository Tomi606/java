package day07;

import java.util.Scanner;

public class p {

	public static void main(String[] args) {
		//1~45사이의 중복되지 않은 랜덤한 수 6개를 만드는 코드를 작성하시오.(메소드 이용)
		int min = 1, max = 25;
		int arr[] = new int[6];
		
		}
	
	//중복 유무 (배열, 중복되지 않는 수, 값)
	int count = 0;
	public static boolean contains(int arr[], int count, int num) {
		//arr 배열이 없거나 길이가 0일때 false
		if(arr == null || arr.length == 0) {
			return false;
		}
		
		//배열길이보다 비교할 count 수가 많을때 false
		if(count > arr.length) {
			count = arr.length;
		}
		
		//중복값이 있을때
		for(int i=0;i<count;i++) {
			if(arr[i] == num) {
				return true;
			}
		}
		
		return false;
	}
	
	//랜덤 수 만들기
	public static int random(int min, int max) {
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random()*(max - min + 1) + 1);
	}
	
}