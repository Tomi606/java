package day08.access1;

//파일명과 class명이 같아서 public 가능(다르면 public사용불가)
public class Student {
	
	//멤버변수는 private
	private int grade;
	int classNum;	//접근제어자가 default
	public int num;
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
	
	
}
