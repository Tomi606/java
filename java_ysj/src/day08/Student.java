package day08;

/* 
 * 학생의 국어, 영어, 수학 성적을 관리하기 위한 프로그램 작성하려고 한다.
 * 이 때 필요한 학생 클래스를 생성해보세요.
 * */
public class Student {

	//멤버 변수 : 학년, 반, 학생번호, 이름, 국영수 성적
	int kor, eng, math;
	int grade, classNum, num;
	String name;
	
	//메소드 : 학생 정보 확인, 국영수 성적 확인, 성적 수정
	/* 기능 : 학생 정보(학년, 반, 번호, 이름)을 콘솔에 출력하는 메소드
	 * 매개변수 : void -> 내정보라서
	 * 리턴타입 : void	-> 내가 입력할거라
	 * 매소드명 : printInfo */
	public void printInfo() {
		System.out.println("--------------------");
		System.out.println(grade + "학년 " + classNum + "반 " + num + "번 " + "이름 : " + name);
	}
	
	/* 기능 : 학생 성적(학년, 반, 번호, 이름, 국어, 영어, 수학)을 콘솔에 출력하는 메소드
	 * 매개변수 : void
	 * 리턴타입 : void
	 * 매소드명 : printScore */
	public void printScore() {
		printInfo();
		System.out.println("국어 성적 : " + kor);
		System.out.println("영어 성적 : " + eng);
		System.out.println("수학 성적 : " + math);
	}
	
	/* 기능 : 국어 성적을 수정하는 메소드
	 * 매개변수 : int korScore -> 수정하려는 국어 성적
	 * 리턴타입 : void -> 내가수정하면됨
	 * 매소드명 : setKor */
	public void setKor(int korScore) {
		kor = korScore;
	}
	
	/* 기능 : 영어 성적을 수정하는 메소드
	 * 매개변수 : 
	 * 리턴타입 : 
	 * 매소드명 : setEng */
	public void setEng(int engScore) {	//매개변수가 수정되기 때문에 이름을 다르게 설정
		eng = engScore;
	}
	
	/* 기능 : 수학 성적을 수정하는 메소드
	 * 매개변수 : 
	 * 리턴타입 : 
	 * 매소드명 : setMath */
	public void setMath(int mathScore) {
		math = mathScore;
	}
	
}
