package day06;
//숫자 야구게임
import java.util.Scanner;

public class HomeworkEx1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int com[] = new int[3];
		int user[] = new int[3];
		
		int S=0, B=0;
		//6개 랜덤 수 생성
		
			for(int i=0;i<com.length;i++) {
			com[i] = (int)(Math.random()*9 + 1);
			//중복확인
			for(int j=0;j<i;j++) {
				if(com[i]==com[j]) {	//baseball[]와 
					j--;
				}
			}
		}
		do {
			
		//랜덤으로 생성된 숫자
		for(int i=0;i<com.length;i++) {			
			System.out.print(com[i] + " ");	//게임시 지우기
		}
		System.out.println();
		
		//유저 입력 받기
		for(int i=0;i<user.length;i++) {
			System.out.print((i+1)+"번 자리 입력 : ");
			user[i] = sc.nextInt();
		}
		
		//strike, ball
		for(int i=0;i<com.length;i++) {
			for(int j=0;j<user.length;j++) {
				if(com[i]==user[j]) {	//수가 같을때
					if(i==j) {			//배열도 같으면	strike
						S++;
						break;
					}else {				//배열은 다르면 ball
						B++;
						break;
					}
				}
			}
		}
		
		//결과
		if(S==0 && B==0) {
			System.out.println("Out 입니다.");
		}else if(S==3) {
			System.out.println("홈런 입니다.");
		}else {
			System.out.println("Ball : "+B+ ", "+"Strike : "+S);
			B = 0;
			S = 0;
		}
		
		}while(S!=3);
		
	}

}


	

