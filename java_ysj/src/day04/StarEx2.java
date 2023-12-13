package day04;

public class StarEx2 {

	public static void main(String[] args) {

		/* *		i=1 *=1
		 * **		i=2 *=2
		 * ***		i=3 *=3
		 * ****		i=4 *=4
		 * *****	i=5 *=5
		 * 위와같이 작성하시오. 
		 * 반복횟수 : i 는 1부터 5까지 1씩 증가
		 * 규칙성 : *을 i개 출력 후 엔터
		 * 			반복횟수 : j 는 1부터 i까지
		 * 			규칙성 : *을 출력
		 * 반복문 종료 후 : 엔터 */
		
		for(int i=1;i<=5;i++) {	//5줄
			for(int j=1;j<=i;j++) {	//i 칸 + i 갯수 만큼 *생성
				System.out.print("*");
			}
			System.out.println();
		}
		
		//i, j를 0이라고 할 경우(*이 하나씩 없이나옴)
		for(int i=0;i<5;i++) {
			for(int j=0;j<i;j++) {
			System.out.print("*");
			}
			System.out.println();
			}
	}

	
}
