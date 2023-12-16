package day05;
//배열 초기화(중괄호{} 사용)
public class ArrayInitEx1 {

	public static void main(String[] args) {

		//arr1배열에는 0번지~4번지까지 모두 0으로 초기화 됨
		//char는 \0, 정수는 0, 실수는 0.0, boolean은 false
		int arr1[] = new int[5];
		
		//1. new int[] 있음
		//arr2는 0번지에 1, 1번지에 2, 2번지에 3, 3번지에 4, 4번지에 5 저장
		//arr2는 총 5개의 크기를 가진 배열이 됨
		int arr2[] = new int[] {1,2,3,4,5};
		arr2 = new int[] {6,7,8,9,10};	//중간에 다시 초기화 가능!
		
		//2. new int[] 없음
		//arr3은 arr2와 같음(표현형태만 다름)
		//arr3와 같이 초기화 하는 경우는 배열선언과 동시에 초기화하는 경우만 가능
		int arr3[] = {1,2,3,4,5};	//고정값
		//arr3 = {6,7,8,9,10};	//다시 초기화 불가능(에러 발생) *차이 기억!
	}

}
