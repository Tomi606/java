package day06;

public class ArrayExpandEx1 {

	public static void main(String[] args) {

		//배열이 꽉 찼을 때 배열을 확장하는 예제 : 배열은 지정한만큼 사용가능, 자동으로 늘지 않음
		int arr[] = new int[5];
		 
		 int count = 10;
		 for(int i=0;i<count;i++) {
			 if(i+1 > arr.length) { //i+1이 배열의 크기보다 크다면 
				 int tmp[] = new int[arr.length + 5];	//새로운 배열 5개 추가
				 System.arraycopy(arr, 0, tmp, 0, arr.length);	//기존에 있는건 tmp에 복사
				 arr = tmp;	//arr는 tmp로 덮어쓰기 해줌
				 
			 }
			 
			 arr[i] = i+1;	//배열보다 큰수라 에러남
		 }
		 
		 for(int tmp : arr) {	//for 안에 있는 건 벗어나서 새로 만든 것
			 System.out.println(tmp);
		 }
	}

}


