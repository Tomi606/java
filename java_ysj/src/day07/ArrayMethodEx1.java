package day07;

import java.util.Scanner;

public class ArrayMethodEx1 {

	public static void main(String[] args) {
		//1~45사이의 중복되지 않은 랜덤한 수 6개를 만드는 코드를 작성하시오.(메소드 이용)
		int arr[] = new int[6];
		int min = 1, max = 45;
		if(createRandomArray(min, max, arr)) {
			System.out.println("배열 생성 성공!");
			for(int tmp : arr) {
				System.out.print(tmp + " ");
			}
			System.out.println();
		}else {
			System.out.println("배열 생성 실패!");	//max가 6보다 작을경우 실패
		}
		
		//1~45사이의 중복되지 않은 수 6개를 입력하는 코드를 작성하시오.(contains 메소드 이용)
		int user[] = new int[6];
		int count = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("중복되지 않은 수 6자리 입력(1~45) : ");
		while(count < user.length) {
			int num = sc.nextInt();
			if(!contains(user, count, num) && (num >= min && num <= max)) {
				user[count++] = num;
			}	
		}
		for(int tmp : user) {
			System.out.println(tmp + " ");
		}
		System.out.println();
		sc.close();
	}

	/* 기능 : min ~ max 사이의 중복되지 않은 랜덤한 수를 배열에 만들어 주고 생성 여부를 알려주는 메소드
	 * 매개변수 : 최솟값, 최댓값, 배열 -> int min, int max, int arr[]
	 * 리턴타입 : 배열의 생성 여부 -> boolean
	 * 메소드명 : createRandomArray
	 * */
	public static boolean createRandomArray(int min, int max, int arr[]) {
		if(arr == null || arr.length ==0) {
			return false;
		}
		
		//max가 min보다 작으면
		if(max < min) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		//배열의 크기가 min~max사이의 정수 개수보다 클때
		if(arr.length > max - min + 1) {
			return false;
		}
		//반복분 : 저장된 숫자의 개수가 배열의 크기보다 작을때 반복
		int count = 0; //저장된 숫자의 개수
		while(count < arr.length) {
			//랜덤수 생성
			int r = random(min, max);
			//중복 확인
			if(!contains(arr, count, r)) {
				//중복되지 않으면(!contains) 배열에 저장 + 저장된 숫자의 개수 1증가
				arr[count++] = r;
			}
		}
		return true;
	}
	
	//2. [1, 2, 0, 0, 0] -> 배열에서 0번지부터 2개 중에서 0과 일치하는 값이 있나? false
	/* 기능 : 배열이 주어지고 배열의 0번지부터 n개 중에서 num와 같은 값이 있는지 없는지를 알려주는 메소드(중복 유무 메소드)
	 * 매개변수 : 주어진 배열, 검사할 배열의 개수, 비교할 정수 ->int []arr, int n, int num(n = count, 배열에 있는 중복아닌 값의 개수)
	 * 리턴타입 : 같은 값이 있는지 없는지 -> boolean
	 * 메소드명 : contains(포함하다)
	 * */
		public static boolean contains(int []arr, int n, int num) {
			//배열생성이 안됬거나 크기가 0이면
			if(arr == null || arr.length == 0) {	
				return false;
			}
			
			//배열의 크기보다 비교할 개수가 많으면
			if(arr.length < n) {	
				n = arr.length;		//비교할 개수를 배열 개수로 수정
			}
			
			//배열에 num와 같은 값이 있으면
			for(int i=0;i<n;i++) {
				if(arr[i] == num) {
					return true;
					//Q.arr[i] == num true 로 끝나서 값을 출력안하고, !=이면 통과되서 false로 가서 출력?
				}
			}
			//반복문이 끝날때까지 같은 값이 없으면 
			return false;
		}
	/*1. 
	 * 기능 : min ~ max 사이의 랜덤한 수를 생성해서 알려주는 메소드
	 * 매개변수 : 최소값과 최댓값 -? int min, int max
	 * 리턴타입 : 생성된 랜덤한 수 -> 정수 -> int
	 * 메소드명 : random */
	public static int random(int min, int max) {
		if(max < min) {	//맥스값이 민값보다 작을때
			int tmp = max;
			max = min;
			min = tmp;
		}
		return (int)(Math.random()*(max-min+1)+min);
	}
}

