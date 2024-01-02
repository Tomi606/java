package day16.student2;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student implements Serializable {

	private static final long serialVersionUID = 1328965129698986264L;
	private int grade, classNum, num;
	private String name;
	
	
	
	public void print() {
		System.out.println(grade + "학년 " + classNum + "반 " + num + "번 " + name);
	}

	//학년, 반, 번호가 같을시(이름 제외)
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
}
