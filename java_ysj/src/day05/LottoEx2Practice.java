package day05;

import java.util.Arrays;
import java.util.Scanner;

public class LottoEx2Practice {

	public static void main(String []args) {
		
		int lotto[] = new int[7];
		int count = 0;
		
		//랜덤수생성
		//중복확인
		while(count < lotto.length) {
			int r = (int)(Math.random()*45 + 1);
			
			int i;
			for(i=0;i<count;i++) {
				if(lotto[i]==r) {
					break;
				}
			}
			if(i==count) {
				lotto[i]=r;
				count++;
			}
			
		}
		Arrays.sort(lotto);
		
		
		//1~6자리 배열을 다른 배열에 넣기
		int tmp[] = new int[6];
		System.arraycopy(lotto, 0, tmp, 0, 6);
		//보너스 값 넣기
		int bonus = lotto[6];
		
		//출력
		System.out.print("로또 번호 : ");
		for(int i=0;i<tmp.length;i++) {
			System.out.print(tmp[i]+ " ");
		}
		System.out.println("["+bonus+"]");
		
		//사용자 값 받기
		Scanner sc = new Scanner(System.in);
		int user[] = new int[6];
		System.out.print("6개 값을 입력 : ");
		for(int i=0;i<user.length;i++) {
			user[i] = sc.nextInt();
		}
		
		//중복숫자 확인, 같으면 break 후 다음 배열확인
		int sameCount = 0;
		for(int i=0;i<tmp.length;i++) {
			for(int j=0;j<user.length;j++) {
				if(tmp[i]==user[i]) {
					sameCount++;
					break;
				}
			}
		}
		
		//중복숫자 확인 + 등수
		switch(sameCount) {
			case 6 :
				System.out.println("1등!!!");
				break;
			case 5 :
				//bonus 유(2)/무(3)
				int i;
				//유저 번호에 보너스번호와 일치하는 숫자가 있는지 확인
				for(i=0;i<user.length;i++) {
					if(bonus==user[i]) {						
						break;
					}
				}
				//
				if(i==user.length) {
					System.out.println("3등!");
				} else {
					System.out.println("2등!!");
				}
				
				break;
			case 4 :
				System.out.println("4등");
				break;
			case 3 :
				System.out.println("5등");
				break;
			default :
				System.out.println("꽝~~~ㅋㅋ");
				break;
				
				
		}
	}		
}
