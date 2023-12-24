package day11.HomeworkEx1;

public class Student {

	//멤버변수
	String name;
	int grade, classNum, num;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	
	
	//메서드
	
	//학생 정보 출력
	public void showStudentInfo() {
		System.out.println(grade + "학년 " + classNum + "반 " + num + "번 이름 : " + name);
	}
	
	//중복 학생(이름은 같은 수 있으나 학년,반,번호,이름이 다 같은 학생은 있을 수 없다)
	public boolean equalStudent() {
		return this.name.equals(name);
	}
	
	//이름수정
	public void updateName(String name) {
		this.name = name;
	}
	
	//생성자
	public Student(int grade, int classNum, int num, String name) {
		this.name = name;
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
	}
}
