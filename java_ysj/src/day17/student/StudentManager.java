package day17.student;

import java.util.ArrayList;

import lombok.Data;

//학생들을 관리하는 클래스
@Data
public class StudentManager {
	//같은 패키지는 따로 import 안해도 된다.
	private ArrayList<Student> list = new ArrayList<Student>();
	
	/**	학생 정보가 주어지면 학생 정보를 추가하는 메서드로,
	 * 학년, 반, 번호가 같은 학생이 있는 경우 학생 정보를 추가하지 않음
	 * @param student 학생정보
	 * @return 학생 정보를 추가했는지 여부를 반환(추가했으면 true, 실패했으면 false)
	 */
	public boolean insertStudent(Student std) {
		//이미 학생정보가 포함되있으면
		if(list.contains(std)) {
			//false로 추가 실패
			return false;
		}
		//없으면 true로 추가
		list.add(std);
		//학년, 반, 번호 순으로 정렬
		sort();
		return true;
	}
	
	/** 가지고있는 학생 정보들을 정렬하는 메서드
	 */
	public void sort() {
		//학생1 과 학생 2를 비교할때
		list.sort((s1, s2) -> {
			//학년이 다르면
			if(s1.getGrade() != s2.getGrade()) {
				return s1.getGrade() - s2.getGrade();
			}
			//반이 다르면
			if(s1.getClassNum() != s2.getClassNum()) {
				return s1.getClassNum() - s2.getClassNum();
			}
			return s1.getNum() - s2.getNum();
		});
	}
	
	//학생 정보 출력
	public void printAll() {
		//stream에서 각각의 학생(s,매개변수 이름은 아무거나 상관X)를 하나 꺼내서 출력
		list.stream().forEach(s -> System.out.println(s));
	}
	
	//null 처리를 위해 set 다시 메서드 생성
	public void setList(ArrayList<Student> list) {
		if(list == null) {
			return;
		}
		this.list = list;
	}
}
