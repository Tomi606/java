package day06;

public class ArrayExpandEx1 {

	public static void main(String[] args) {

		//배열이 꽉 찼을 때 배열을 확장하는 예제 : 배열은 지정한만큼 사용가능, 자동으로 늘지 않음
		int arr[] = new int[5];
		
		int count = 10;
		for(int i=0;i<count;i++) {
			if(i+1 > arr.length) {
				int tmp[] = new int[arr.length + 5];	//새로운 배열 5개 추가
				System.arraycopy(arr, 0, tmp, 0, arr.length);	//기존꺼를 tmp에 복사
				arr = tmp;
			}
			arr[i] = i+1;	//배열보다 큰수라 에러남
		}
		for(int tmp : arr) {
			System.out.println(tmp);
		}
	}

}


