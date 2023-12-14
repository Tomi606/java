package day05;

public class EnhancedForLoopEx1 {

	public static void main(String[] args) {

		//1부터 5까지 저장된 배열을 향상된 for문으로 출력하는 예제
		int arr[] = new int[] {1,2,3,4,5};
		
		//1. 향상된 for문 사용 X
		for(int i=0;i<arr.length;i++) {
			int tmp = arr[i];	//변수 tmp에 저장후 출력
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		//2. 향상된 for문 사용/배열의 전체 내용 확인, 내용을 변경할 수 없다.(가능하나 번거로움 그냥 for문 쓰기)
		for(int tmp : arr) {
			System.out.print(tmp + " ");
		}
	}

}
