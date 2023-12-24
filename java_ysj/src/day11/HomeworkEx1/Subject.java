package day11.HomeworkEx1;

public class Subject {

	//멤버변수
	private String name;
	private int score;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	
	//메서드
	
	//과목 정보
	public void showSubjectInfo() {
		System.out.println("과목 : " + name + ", 점수 : " + score);
	}
	
	//총점
	public int allScore() {
		int result = 0;
		result += score;
		return result;
	}
	
	//점수 수정
	public void updateScore(int score) {
		this.score = score;
	}
	
	//같은 과목 이름
	public boolean equals(String name) {
		return this.name.equals(name);
	}
	
	//생성자
	public Subject(String name, int score) { 
		this.name = name;
		this.score = score;
	}
}
