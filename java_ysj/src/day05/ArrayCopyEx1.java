package day05;

public class ArrayCopyEx1 {

	public static void main(String[] args) {

		//배열 복사 예제
		
		//1. arr1과 arr2의 "공유"
		int[] arr1 = new int[] {1,2,3,4,5};
		int[] arr2 = arr1;	//arr2는 복사가 아닌 "공유"가 된 것. 복사가 된게 아님, "주소"를 공유!
		
		//arr1의 내용이 바뀌면 arr2도 같이 바뀜
		arr1[0] = 9;	//arr2도 같이 수정({1,2,3,4,5}가 복사된게 아님)
		
		//arr2의 0번지 내용이 9로 출력되는걸 확인
		for(int i=0;i<5;i++) {
			System.out.println(arr2[i]);
		}
		
		//2. arr3의 arr1 직접복사
		int[] arr3 = new int[arr1.length];	//arr1.길이만큼
		//반복문을 이용하여 arr1에 있는 값들을 arr3에 복사
		for(int i=0;i<arr1.length;i++) {
			arr3[i] = arr1[i];	//복사
		}
		System.out.print("arr3 확인 : ");
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr3[i] + " ");	//[0]이 9로 바뀌지 않고 arr1을 직접복사
		}
		
		
		//3. System.arraycopy : arr1을 arr4에 전체 복사
		int[] arr4 = new int[arr1.length];
		//시작어레이, 몇번지부터 복사, 어디 어레이에복사, 시작번지, arr1길이만큼
		System.arraycopy(arr1, 0, arr4, 0, arr1.length);
		
		System.out.print("\narr4 확인 : ");
		for(int i=0;i<5;i++) {
			System.out.print(arr4[i] + " ");
		}
		
		
		//4. arr1배열에 1번지부터 2개를 복사해서 arr5배열에 2번지부터 덮어씀(부분복사)
		int[] arr5 = new int[arr1.length];
		System.arraycopy(arr1, 1, arr5, 2, 2);
		
		System.out.print("\narr5 확인 : ");
		for(int i=0;i<5;i++) {
			System.out.print(arr5[i] + " ");
		}
			
	}

}
//참조 자료형에서 '='은 '공유'이다.
//기본 자료형은 바로 복사 가능