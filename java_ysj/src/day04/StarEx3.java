package day04;

public class StarEx3 {

	public static void main(String[] args) {

		/*     * i=1  " "=4  *=1
		 *    ** i=2  " "=3  *=2
		 *   *** i=3  " "=2  *=3
		 *  **** i=4  " "=1  *=4
		 * ***** i=5  " "=0  *=5
		 *             5-i개  =i개
		 * 반복횟수 : 
		 * 규칙성 : 
		 * */
		
		int rows = 5;
		for(int i=1;i<=rows;i++) {
			//' '을 5-i개 출력
			for(int j=1;j<=rows-i;j++) {
				System.out.print(" ");
			}
			//*을 i개 출력
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();

		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5-i;j++) {
			System.out.print(" ");
			}
			for(int k=1;k<=i;k++) {
			System.out.print("*");
			}
			System.out.println();
			}

		}
	}