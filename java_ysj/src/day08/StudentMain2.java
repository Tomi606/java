package day08;

public class StudentMain2 {

	public static void main(String[] args) {

		//5명의 학생을 저장하기 위한 배열을 생성하세요.
		Student []stds = new Student[5];
		
		//학생 5명의 학생 정보를 출력하는 코드
		for(int i=0;i<stds.length;i++) {
			stds[i] = new Student();	//인스턴스를 만들어 준다음에(앞에서는 배열만 만들었기 때문에)
			stds[i].printInfo();		//정보를 출력
		}
		
	}

}
