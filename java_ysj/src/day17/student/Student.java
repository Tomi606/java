package day17.student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data	//@getter, setter, @ToString, @HashCodeAndEquals 등
@AllArgsConstructor	//배치순서대로 매개변수 생성
public class Student implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6588474647564459241L;
	private int grade, classNum, num;
	private String name;
	
	//이름을 제외한 학년,반,번호 이름이 같을때
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return classNum == other.classNum && grade == other.grade && num == other.num;
	}
	@Override
	public int hashCode() {
		return Objects.hash(classNum, grade, num);
	}
	
	//프린트 메서드를 따로 만들지 않아도 자동으로 생성
	@Override
	public String toString() {
		return grade + "학년 " + classNum + "반 " + num + "번  이름 : " + name;
	}
	
}
