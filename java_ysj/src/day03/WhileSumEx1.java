package day03;

public class WhileSumEx1 {

	public static void main(String[] args) {

		/* 1부터 5까지 합을 구하는 코드를 작성하시오. */
		/* 반복횟수 : i가 1부터 5까지 1씩 증가
		 * 규칙성 : sum = sum + i
		 * 반복문 종료 후 : sum을 출력*/
		
		int sum = 0;
		int i = 1;
		int num = 5;
		
		while(i<=num) {
			sum += i;
			i++;
		}
		System.out.println(sum);
	}

}
/*
 * sum = sum + 1;
 * sysout(sum);
 * sum = sum + 2;
 * sysout(sum);
 * sum = sum + 3;
 * sysout(sum);
 * sum = sum + 4;
 * sysout(sum);
 * . . .*/
/*
 * sum = sum + i;
 * i++;
 * sum = sum + i;
 * i++;
 * . . .*/