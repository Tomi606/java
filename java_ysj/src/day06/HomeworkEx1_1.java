package day06;
//숫자 야구게임
import java.util.Scanner;

public class HomeworkEx1_1 {

	public static void main(String[] args) {
		
		//컴퓨터가 랜덤으로 중복되지 않은 숫자 3개를 생성(1~9) -> 밖에 생성(안으로 들어가면 계속 다른수 생성)
		//로또 복사
		int min=1, max=9;
		int com[] = new int[3];	//3개 출력
		int count = 0;	//저장된 갯수만큼
		
		//랜덤으로 중복되지 않는 3개의 수 생성
		while(count < com.length) {
			
			//랜덤수 생성
			int r = (int)(Math.random()*(max-min+1)+min);
			
			//중복확인(0번부터 시작)
			int i;
			for(i=0;i<count;i++) {
				if(com[i]==r) {
						break;
				}
			}
			
			//중복되지 않으면 저장 후 count++
			if(i==count) {
				com[count++] = r;
			}
		}
		
		//3개 숫자 출력, 게임시 주석 처리
		for(int i=0;i<com.length;i++) {
			System.out.print(com[i]+" ");
		}
		System.out.println();
		
		//반복문 : 맞출때까지 = strike 개수가 3개 미만일 경우 반복(strike가 3개일때 종료), 최소 1번은 실행
		int s,b;
		int user[] = new int[com.length];
		Scanner sc = new Scanner(System.in);
		do {
			//중복되지 않은 숫자 3개를 입력받음
			count=0;
			System.out.print("입력 : ");
			while(count < user.length) {
				int input = sc.nextInt();
				int i;
				for(i=0;i<count;i++) {
					if(user[i]==input) {	//중복되면 빠져나옴
							break;
					}
				}
				//중복되지 않으면 저장 후 count++
				if(i==count) {	//중복되지 않은 것
					user[count++] = input;
				}
			}
			//스트라이크와 볼의 개수를 같이 계산(반복문), 0으로 초기화(안하면 누적됨)
			s=0;
			b=0;
			for(int i=0;i<com.length;i++) {
				for(int j=0;j<user.length;j++) {
					if(com[i]==user[j]) {	//수가 같고
						if(i == j) {	//위치도 같으면
							s++;
						}else {			//위치는 다르면
							b++;
						}
					}
				}
			}
			//스트라이크와 볼의 개수에 따른 결과를 출력
			if(s != 0) {
				System.out.print(s + "S");
			}
			if(b != 0) {
				System.out.print(b + "B");
			}
			if(s == 0 && b ==0) {
				System.out.print("O");
			}
			System.out.println();
			
		}while(s < 3);
		//정답입니다. 를 출력(게임 끝)
		System.out.println("정답입니다!");
		
		sc.close();
	}

}


	

