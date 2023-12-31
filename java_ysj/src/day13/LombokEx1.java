package day13;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class LombokEx1 {

	public static void main(String[] args) {
		Test t = new Test();
		t.print();
		t.setNum1(10);
		System.out.println(t.getNum1());
		System.out.println(t);
	}

}
//lombok을 설치하고 이용, 코드 깔끔
//@getter @setter
@Data
@AllArgsConstructor	//모든 멤버들이 매개변수로 들어간 생성자를 생성(멤버들을 모두포함)
@NoArgsConstructor	//기본 생성자 추가
class Test {
	private int num1;
	private int num2;
	
	public void print() {
		System.out.println(num1);
		System.out.println(num2);
	}
}

/* 롬복 어노테이션 종류

@NonNull : 자동으로 null 체크를 진행하고, null인경우 NullPointException 발생

@AllArgsConstructor : 모든 필드를 매개변수로 갖는 생성자를 구현

@RequiredArgsConstructor : 초기화되지 않은 모든 final 필드, 
			@NonNull로 마크되어 있는 필드들에 대한 생성자를 자동으로 생성한다.
			(final이나 @NonNull인 필드 값만 매개변수로 받는 생성자를 만들어줍니다.)

@NoArgsConstructor : 매개변수가 없는 기본 생성자를 생성

@EqualsAndHashCode : equals와 hashcode를 모든 매개변수를 오버라이딩해서 생성
(원하는 매개변수만 하고싶으면 source -> hashcode and equals 사용)

@Data : 
@Getter / @Setter, @RequiredArgsConstructor, 
@ToString, @EqualsAndHashCode 을 한번에 설정해준다.*/