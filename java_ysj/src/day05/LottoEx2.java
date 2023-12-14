package day05;

import java.util.Arrays;

public class LottoEx2 {

	public static void main(String[] args) {

		/* 로또 당첨번호를 랜덤으로 생성한 후(당첨번호 6자리 + 보너스 번호),
		 * 사용자가 로또번호를 입력하면(로또번호 6자리) 당첨 등수를 출력하는 코드를 작성하시오. 
		 * */
		
		int min = 1, max = 45;
		int lotto1[] = new int[7];
		int lotto2[] = new int[7];
		int user[] = new int[6];
		int i, count=0, bonus=0;
		
		//랜덤으로 중복되지 않는 7개의 수 생성
		while(count<lotto1.length) {
			//랜덤수생성
			int r = (int)(Math.random()*(max-min+1)+1);
			
			//중복인지 확인
			boolean duplicated = false;
			for(i=0;i<count;i++) {
				if(lotto1[i]==r) {
					duplicated = true;
				break;
				}
			}
			
			//중복이 아니면 저장 count++;
			if(!duplicated) {
				lotto1[count] = r;
				count++;
			}
			
		}
		//위에서 생성한 배열 중 0번지부터 5번지까지 복사해서 새로운 배열에 복사 - 2번 배열(당첨번호)
		System.arraycopy(lotto1, 0, lotto2, 0, lotto1.length-1);
		
		//1번 배열 6번지에 있는 값을 보너스로 지정 - 보너스 번호
		lotto1[6] = bonus;
		System.arraycopy(lotto1, 6, lotto2, 6, 1);
		
		//2번 배열 정령 후 출력
		Arrays.sort(lotto2);
		for(i=0;i<lotto2.length;i++) {
			System.out.print(lotto2[i]+" ");
		}
	}

}
