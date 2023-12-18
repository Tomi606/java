package day07;

import java.util.Scanner;

public class p {

	public static void main(String[] args) {
		//1~45사이의 중복되지 않은 랜덤한 수 6개를 만드는 코드를 작성하시오.(메소드 이용)
		int arr[] = new int[6];
		int min = 1, max =45;
		
		if(createRandomArray(min, max, arr)) {
			System.out.println("배열 생성 성공!");
			for(int tmp : arr) {
				System.out.print(tmp + " ");
			}
		}else {
			System.out.println("배열 생성 실패!");
		}
		System.out.println();
		
		//1~45사이의 중복되지 않은 수 6개를 입력하는 코드를 작성하시오.(contains 메소드 입력)
		int user[] = new int[6];
		int count = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("1~45 중복되지 않는 6자리 수 입력 : ");
		while(count < user.length) {
			int num = sc.nextInt();
			if(!contains(user, count, num) && (num >= min && num <= max)) {
				user[count++] =  num;
			}
		}
		for(int tmp : user) {
			System.out.println(tmp + " ");
		}
		System.out.println();
		sc.close();
	}

	//1. 랜덤 수 뽑기
	public static int random(int min, int max) {
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random()*(max+min-1) + 1);
	}
	
	//2. 배열의 [0]~[n] 중, num과 같은 값이 있는지 없는지 알려주는 메소드(중복 유무 메소드)
	public static boolean contains(int arr[], int count, int num) {
		//배열생성이 안됬거나 크기가 0이면
		if(arr == null || arr.length ==0) {
			return false;
		}
		
		//배열의 크기보다 비교할 갯수가 많으면
		if(arr.length < count) {
			count = arr.length;
		}
		
		//배열에 num과 같은 값이 있으면
		for(int i=0;i<count;i++) {
			if(arr[i] == num) {
				return true;
			}
		}
		//반복문이 끝날때까지 같은 값이 없으면
		return false;
	}
	
	//3. min ~ max사이 중복되지 않은 랜덤한 수를 배열에 만들어주고, 생성여부를 알려주는 메소드
	public static boolean createRandomArray(int min, int max, int arr[]) {
		//arr 배열 null or 0
		if(arr == null || arr.length == 0) {
			return false;
		}
		
		//max < min
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		
		//배열의 크기가 min ~ max 사이의 정수 개수보다 클때
		if(arr.length > (max-min +1)) {
			return false;
		}
		
		//반복문 : 저장된 숫자의 개수가 배열의 크기보다 작을때 동안 반복
		int count = 0;
		while(count < arr.length) {
			int r = random(min, max);
			if(!contains(arr,count, r)) {
				arr[count++] = r;
			}
		}
		
		return true;
	}
}