package day05;

import java.util.Arrays;

public class LottoEx1 {

	public static void main(String[] args) {

		/* 1~45 사이의 중복되지 않는 랜덤한 수 6개를 생성하여 출력하는 예제를 작성하시오.
		 * 단, 정렬이 되도록 (Arrays.sort) */
		
		int min=1, max=45;
		int lotto[] = new int[6];	//6개 출력
		int count = 0;	//저장된 갯수만큼
		
		//랜덤으로 중복되지 않는 6개의 수 생성
		//(배열에 중복되지 않은 수가 6보다 작으면 반복)
		while(count < lotto.length) {	//배열에 저장된갯수(count)가 lotto 길이 보다 작을동안
			
			//랜덤수 생성
			int r = (int)(Math.random()*(max-min+1)+min);
			
			//중복확인(0번부터 시작)
			int i;
			for(i=0;i<count;i++) {
				if(lotto[i]==r) {
						break;
				}
			}
			
			//중복되지 않으면 저장 후 count++
			if(i==count) {
				lotto[count++] = r;	//Q. lotto[i] = r; count++;도 되나? 
			}
			/* 
			 * if(!duplicated) {	//!duplicated = 중복이 아니면 = true
				lotto[count] = r;
				count++;
			}*/
			
		}
		
		//오름차순 정렬
		Arrays.sort(lotto);
		
		//6개 숫자 출력
		System.out.print("당첨 번호는 ");
		for(int i=0;i<lotto.length;i++) {
			System.out.print(lotto[i]+" ");
		}
		System.out.println("입니다.");
		
	}

}
