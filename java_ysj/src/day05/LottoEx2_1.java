package day05;

import java.util.Arrays;
import java.util.Scanner;

public class LottoEx2_1 {

	public static void main(String[] args) {

		/* 로또 당첨번호를 랜덤으로 생성한 후(당첨번호 6자리 + 보너스 번호),
		 * 사용자가 로또번호를 입력하면(로또번호 6자리) 당첨 등수를 출력하는 코드를 작성하시오. 
		 * */
		

		
		//7개짜리 배열을 만들어 로또 당첨 번호를 랜덤으로 생성(7개짜리 배열에 생성) - 1번 배열
		int [] tmp = new int[7]; //임시변수
		int count = 0; //중복되지 않게 저장되있는 수
		int min = 1, max = 45;
		
		while(count < tmp.length) {
			int r = (int)(Math.random()*(max-min+1)+min);
			
			int i;
			for(i=0;i<count;i++) {	//count가 0일때 밑의 if문을 break를 통해 빠져나오고,
				if(r==tmp[i]) {
					break;
				}
			}
			if(i==count) {
				tmp[count++] = r; 	//count번지에 저장하고 1증가
			}
			
		}
		
		//위에서 생성한 배열 중 0번지부터 5번지까지 복사해서 새로운 배열에 복사 - 2번 배열(당첨번호)
		int [] lotto = new int[6];
		System.arraycopy(tmp, 0, lotto, 0, 6);	//당첨번호라 6개
		
		//1번 배열 6번지에 있는 값을 보너스로 지정 - 보너스 번호
		int bonus = tmp[6];	//tmp 6번지값을 bonus로 지정
		
		//2번 배열 정령 후 출력
		Arrays.sort(lotto);
		System.out.print("당첨번호 : ");
		for(int i=0;i<lotto.length;i++) {
			System.out.print(lotto[i]+" ");
		}
		System.out.println(" [" + bonus + "]");
		
		//사용자 번호를 입력(6개)해서 배열 저장 - 3번 배열
		int user[] = new int[6];
		Scanner sc= new Scanner(System.in);
		System.out.print("입력 번호 : ");
		for(int i=0;i<6;i++) {
			user[i] = sc.nextInt();
		}
		
		//당첨 개수 확인(이중 반복문) 숫자 하나당 여러개를 비교
		int sameCount = 0;
		for(int i=0;i<lotto.length;i++) {
			for(int j=0;j<user.length;j++) {
				if(lotto[i] == user[j]) {
					sameCount++;
					break;	//같은 숫자가 있으면 빠져나와야 해서 break(사용자가 중복수를 입력했을때 한번만 체크)
				}
			}
		}
		
		//당첨 개수에 따른 등수를 출력
		switch(sameCount) {
		
		case 6 :
			System.out.println("1등!!!");
			break;
			
		case 5 : 
			int i;
			//사용자가 입력한 번호에 보너스에 일치하는 번호가 있는지 확인
			//중복체크
			for(i=0;i<user.length;i++) {
				if(bonus == user[i]) {
					break;
				}
			}
			
			//보너스번호와 일치하는 번호가
			if(i == user.length) {
				//없으면
				System.out.println("3등!");
			} else {
				//있으면
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
			System.out.println("꽝");
		}
	}

}
