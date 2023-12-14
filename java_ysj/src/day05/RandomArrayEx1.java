package day05;

public class RandomArrayEx1 {

	public static void main(String[] args) {

		/* 1에서 9사이의 랜덤한 수를 3개 생성해서 배열에 저장하는 코드를 작성하시오. 
		 * 3개짜리 배열을 생성하여 랜덤한 수 저장 */
		
		int min =1, max=9;
		
		//int r = (int)(Math.random()*(max-min+1)+min); 밖에 있으면 1번만 랜덤
		/* arr[0] = (int)(Math.random()*(max-min+1)+min);
		 * arr[1] = (int)(Math.random()*(max-min+1)+min);
		 * arr[2] = (int)(Math.random()*(max-min+1)+min);
		 * */
		
		int arr[] = new int[3];
		
		System.out.print("랜덤 값은 ");
		for(int i=0;i<3;i++) {	//3=arr.length
			int r = (int)(Math.random()*(max-min+1)+min);	//이걸 안에 넣어줘야 3값 모두 랜덤으로 나옴
			arr[i] = r;
			System.out.print(arr[i]+" ");
		}
		System.out.println("입니다.");
		
		for(int i=0;i<arr.length;i++) {	//3=arr.length
			arr[i] = (int)(Math.random()*(max-min+1)+min);
			System.out.print(arr[i]+" ");
		}
		
	}

}
