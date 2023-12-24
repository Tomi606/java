package day11;

/* 사이트에서 회원 관리(로그인, 회원가입 등)를 위한 Member 클래스를 작성하세요. */

//작성한 Member 클래스를 이용하여 인스턴스를 생성하고 구현한 메서드를 테스트 해보세요.

public class HomeworkEx3 {

	public static void main(String[] args) {

		Member m[] = new Member[10];
		
	}

	//필요한 멤버변수 및 메서드를 정리하고 구현하세요.(Car)
	class Member {
		
		//멤버변수
		
		//회원 가입
		String name;
		int birth;	//6자리
		char sex;
		
		//로그인
		String id, password;
		
		
		
		
		//메서드
		
		public Member(int birth, String name, char sex) {
			this.birth = birth;
			this.name = name;
			this.sex = sex;
		}
	}
}
