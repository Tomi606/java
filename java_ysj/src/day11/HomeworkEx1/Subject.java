package day11.HomeworkEx1;

public class Subject {

	//멤버변수
	int korScore, mathScore, engScore;

	public int getKorScore() {
		return korScore;
	}
	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}
	public int getMathScore() {
		return mathScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	public int getEngScore() {
		return engScore;
	}
	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}
	
	
	
	//메서드
	
	//과목 : 점
	public void showSubjectScore() {
		System.out.println("국어 : " + korScore + ", 수학 : " + mathScore + ", 영어 : " + engScore);
	}
		
	//총점
	public void sum() {
		System.out.println("총점 : " + korScore + mathScore + engScore);
	}
	
	//평균
	public void average() {
		System.out.println("평균 : " + (korScore + mathScore + engScore) / 3);
	}
		
	
	//생성자
	public Subject(int korScore, int mathScore, int engScore) {
		this.korScore = korScore;
		this.mathScore = mathScore;
		this.engScore = engScore;
	}
		
}
