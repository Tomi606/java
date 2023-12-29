package day15.student;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor	//(필수항목을 포함한 생성자들을가지겠다)
public class Student {
	@NonNull	//널값을 갖지 않게함(필수항목)
	private int grade, classNum, num;
	@NonNull
	private String name;
	private int kor, eng, math;
	
	@Override	//학년 반 번호가 맞는지 확인하는 오버라이딩
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
