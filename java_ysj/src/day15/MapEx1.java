package day15;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapEx1 {

	public static void main(String[] args) {
		//map은 <key, value>를 다루기 때문에 클래스가 2개 온다(아디, 비번)
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("abc123", "abc123!");
		map.put("def456", "abc123!");	//비번 중복 => value 중복 가능
		map.put("abc123", "qwer123!");	//아이디 중복 => key 중복 => 추가가 안됨, value가 변경
		map.put("admin", "admin");
		map.put("def", "def");
		System.out.println(map.remove("abc123"));	//key값이 abc123인 것 삭제 + value값 리턴
		System.out.println(map);	//key=value 형태로 출력
		
		//keySet을 이용한 반복문 예제
		Set<String> keySet = map.keySet();
		for(String tmp : keySet) {
			String value = map.get(tmp);	//키값을 하나씩 넣어서 밸류값을 갖고옴
			System.out.println(tmp + ", " + value);
		}
		
		System.out.println("=======================");
		//entrySet을 이용한 반복문 예제, 키와 밸류를 엔트리 클래스로 가져와서 멤버변수로 키와 밸류를 넣어서 만듦.
		//엔트리라는 제네릭 클래스를 만듦. 바로 키값과 밸류값을 가져올 수 있다.
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		for(Map.Entry<String, String> tmp : entrySet) {
			System.out.println(tmp.getKey() + " , " + tmp.getValue());
		}
		
		//내부 클래스의 인스턴스를 생성하는 예제
		A a = new A();
		A.B b = a.new B();
		
	}

}

//내부 클래스 예제
class A {
	public class B {
		int num;
	}
}
