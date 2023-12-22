package day08.access3;

public class Students {
	//학생
	//맴버변수
	private int grade, classNum, num;
	private String name;
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	//메서드
	
	//양선진
	public void printInfo() {
		System.out.println(this.grade + "학년 " + this.classNum + "반 " + this.num + "번 " + this.name + "입니다.");
	}
	
	//홍길동
	public void printInfo2(int grade, int classNum, int num, String name) {
		System.out.println(grade + "학년 " + classNum + "반 " + num + "번 " + name + "입니다.");
	}
}
