package day18.student;

import java.util.ArrayList;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentManager {

	private ArrayList<Student> list = new ArrayList<Student>();

	public boolean insertStudent(Student std) {
		if(list.contains(std)) {
			return false;
		}
		//등록안되 있다면 리스트에 추가 후 리턴 트루 반환
		list.add(std);
		sort();	//정렬
		return true;
	}

	//학생 정렬(람다식)
	private void sort() {
		list.sort((s1, s2)-> {
			//학년
			if(s1.getGrade() != s2.getGrade()) {
				return s1.getGrade() - s2.getGrade();
			}
			//반
			if(s1.getClassNum() != s2.getClassNum()) {
				return s1.getClassNum() - s2.getClassNum();
			}
			//번호
			return s1.getNum() - s2.getNum();
		});
	}
	
	//학생 정보 출력
	public void printStudent() {
		list.stream().forEach(s -> System.out.println(s));	//Student 클래스의 toString
	}
	
	//null처리를 위해 StudentManager 메서드 다시 생성
	public StudentManager(ArrayList<Student> list) {
		if(list == null) {
			return;	//list가 비워있으면 return해서 종료
		}
		this.list = list;	//둘이 바뀌면 학생 목록 조회때 세이브된 파일이 안뜬다!
	}
	
	public boolean updateStudent(Student std) {
		//등록된 학생인지 확인
		int index = list.indexOf(std);
		
		//등록된 학생이 아니면 false로 리턴
		if(index < 0) {
			return false;			
		}
		
		//등록된 학생이면 이름을 수정
		list.get(index).setName(std.getName());
		return true;
	}
}
