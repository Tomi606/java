package day16;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class StreamEx1 {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student(1, 1, 1, "홍길동",90, 80, 70),
				new Student(1, 1, 2, "임꺽정",65, 30, 40),
				new Student(2, 1, 1, "고길동", 0, 59, 68)
				);
		
		Stream<Student> stream = list.stream();
		//학생들 중 1학년만 확인, forEach 하나씩 꺼내서 보여줌
		stream.filter(s->s.getGrade() == 1).forEach(s-> System.out.println(s));
		
		//스트림은 초기화가 안되기 때문에 다시 생성해줘야함
		stream = list.stream();
		//학생 정보에서 국어 성적을 추출해서 점수를 출력
		stream.map(s->s.getKor()).forEach(k-> System.out.println("국어 : " + k));
		
		//학생들의 국어 성적 평균을 확인
		stream = list.stream();
		//map : A에서 B로 변환 시킴.
		//mapToInt : A에서 Integer로 변환 시킴.
		//orElse : 계산한 값(평균값이)이 null이면 0으로 대체해서 계산
		double avg = stream.mapToInt(Student::getKor).average().orElse(0.0);
		System.out.println("국어 성적 평균 : " + avg);
		
		stream = list.stream();
		//국어 성적에 2를 곱합 뒤 합을 구함
		//0은 초기값, sum은 누적, kor은 스트림에서 꺼낸 국어 성적
		Integer res = stream.mapToInt(Student::getKor).reduce(0, (sum, kor)-> {
			return sum+2*kor;
		});
		System.out.println("2배 총합 : " + res);
		
		Student arr[] = new Student[] {
				new Student(1, 1, 1, "홍길동",90, 80, 70),
				new Student(1, 1, 2, "임꺽정",65, 30, 40),
				new Student(2, 1, 1, "고길동", 0, 59, 68)
		};
		Stream<Student> stream2 = Arrays.stream(arr);
		System.out.println("=======================");
		
		//위에서 작성한 filter 예제를 복붙 후 stream 대신 stream2로 수정
		//리스트로 만든 스트림과 배열로 만든 스크림을 같은 방법을 이용하여 사용할 수 있
		stream2.filter(s->s.getGrade() == 1).forEach(s-> System.out.println(s));	}

}

@Data
@RequiredArgsConstructor
class Student {
	@NonNull
	Integer grade, classNum, num;	//int는 애초에 null값이 안들어가서 Integer로 수정
	@NonNull
	String name;
	@NonNull
	Integer kor, eng, math;
}