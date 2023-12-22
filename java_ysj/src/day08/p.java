package day08;

public class p {

	public static void main(String[] args) {

		System.out.println(sum());
		System.out.println(sum(1,1,1,1,1));

	}

	
	public static int sum(int ... nums) {
		int sum = 0;
		
		if(nums.length == 0) {
			return 0;
		}
		
		for(int num : nums) {
			sum += num;
		}
		return sum;
	}
}
