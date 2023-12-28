package day14.work;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class LottoEx1 {

	public static void main(String[] args) {
		//랜덤으로 당첨 번호를 생성하고, 사용자가 로또 번호를 입력하면 등수를 알려주는 코드를 작성
		//단, 컬렉션을 이용
		/* 당첨번호 : 6개, 보너스 : 1개
		 * 사용자 : 6개
		 * 번호 범위 : 1~45 */
		
		Set<Integer> lotto = new TreeSet<Integer>();
		Set<Integer> user = new HashSet<Integer>();
		int bonus;		
		int min = 1, max = 45;
		
		//로또 당첨번호 6개를 랜덤으로 생성(중복 X)
		while(lotto.size() < 6) {
			int tmp = (int)(Math.random()*(max - min + 1) + min);
			lotto.add(tmp);
		}
		//보너스 번호 생성
		while(true) {
			bonus = (int)(Math.random()*(max - min + 1) + min);
			//보너스번호가 당첨번호와 일치하지 않으면 빠져나감
			if(!lotto.contains(bonus)) {
				break;
			}
		}
		System.out.println(lotto + ", 보너스 : " + bonus);
		
		//사용자가 당첨 번호를 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("번호(중복되지 않은 6개) : ");
		while(user.size() < 6) {
			int tmp = sc.nextInt();
			user.add(tmp);
		}
		//일치하는 개수 계산
		int count = 0;
		for(int tmp : user) {
			//사용자 번호를 하나씩꺼내서 로또번호와 맞으면 count++
			if(lotto.contains(tmp)) {
				count++;
			}
		}
		//등수 출력
		switch(count) {
		case 6 : System.out.println("1등");
			break;
			
		case 5 :
			int rank = user.contains(bonus) ? 2 : 3;
			System.out.println(rank + "등");	
			break;
			
		case 4 : System.out.println("4등");
			break;
			
		case 3 : System.out.println("5등");
			break;	
		
		default : System.out.println("꽝");
		}
				
	}

}
