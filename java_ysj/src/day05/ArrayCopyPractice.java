package day05;


public class ArrayCopyPractice {

	public static void main(String[] args) {

		//배열 복사
		int arr1[] = new int[] {1,2,3,4,5};
		
		//1. 힙 메모리 주소 "공유"
		int arr2[] = arr1;		
		//arr1[0] = 9;
		
		for(int i=0;i<arr1.length;i++) {
			//System.out.print(arr2[i]+ " ");
		}
		
		//2. 직접복사
		int arr3[] = new int[arr1.length];
		
		for(int i=0;i<arr1.length;i++) {
			arr3[i] = arr1[i];
		}
		
		arr1[0] = 9;	//arr1[0]에 9대입
		for(int i=0;i<arr1.length;i++) {
			//System.out.print(arr3[i]+ " ");
		}
		
		//얕은복사
		//3. System.arraycopy(arr1, 0, arr4, 0, arr1.length);
		//arr1의 [0]부터를 arr4의 [0]부터 arr1길이만큼 카피
		int arr4[] = new int[arr1.length];
		System.arraycopy(arr1, 0, arr4, 0, arr1.length);
		for(int i=0;i<arr1.length;i++) {
			//System.out.print(arr4[i]+" ");
		}
		
		//4. System.arraycopy(arr1, 0, arr5, 3, 2)
		int arr5[] = new int[arr1.length];
		System.arraycopy(arr1, 0, arr5, 2, 2);	//arr1 [0]부터를 arr5 [2]부터 2자리 카피해놓는다.
		for(int i=0;i<arr1.length;i++) {
			//System.out.print(arr5[i]+" ");
		}
		
	}
	
}
