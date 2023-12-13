package day04;

public class StarEx1 {

	public static void main(String[] args) {

		/* 별이 출력되게 작성하시오.
		 * *****
		 * *****
		 * *****
		 * 반복횟수 : i 는 1부터 3까지 1씩 증가
		 * 규칙성 : *을 5개 출력
		 * 			=>반복횟수 : j 는 1부터 5까지 1씩 증가
		 * 			  규칙성 : *을 출력
		 * 			  반복문 종료 후 : 엔터
		 * */
		
		for(int i=0;i<3;i++) {	//3줄
			for(int j=0;j<5;j++) {	//5칸
				System.out.print("*");				
			}
			System.out.println();
		}
	}

}
