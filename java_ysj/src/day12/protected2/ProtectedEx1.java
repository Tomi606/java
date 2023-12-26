package day12.protected2;

import day12.protected1.A;	//다른 패키지라 import해줘야 함

public class ProtectedEx1 {

	public static void main(String[] args) {
		/* num1 : private
		 * num2 : default
		 * num3 : protected
		 * num4 : public */
		
		A a = new A();
		//a.num1 = 1;	private
		//a.num2 = 2;	default : 다른패키지라 안됨
		//a.num3 = 3;	protected : 자식클래스가 아니라서 안됨
		a.num4 = 4;
		
		B b = new B();
		//b.num1 = 1;
		//default인 num2는 B와 ProtectedEx1이 같은 패키지이기 때문에 접글할 수 있지 않을까?
		//애초에 B도 num2에 접근할 수 없음(num2는 protected1 패키지의 A 클래스 것이다)
		//b.num2 = 2;
		//같은 패키지 이지만, ProtectedEx1이 B클래스의 자식 클래스가 아니기 때문에
		//b.num3 = 3;
		b.num4 = 4;
	}

}
