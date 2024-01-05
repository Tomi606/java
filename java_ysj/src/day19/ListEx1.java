package day19;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListEx1 {

	public static void main(String[] args) {
		//List는 제네릭 인터페이스 -> 꺽쇠를 이용해 타입 설정
		//<> 안하면 최상위 클래스인 Object가 들어감. -> 들고올때마다 형변환 해줘야 함.
		/* 제네릭 인터페이스인 List의 <타입>을 지정하지 않은 경우
		 * 	- <타입>에 최상위 클래스인 Object가 자동으로 들어감 
		 * 	- 단점 : get()을 이용할 때, 클래스 형변환을 해야 함. 
		 * 
		 * -get(번지) : 리스트에서 제공하는 메서드 
		 * 	*Set은 사용불가(번지가 없기때문) */
		List list = new ArrayList();
		list.add("abc");
		String str = (String)list.get(0);	//(String)으로 다운 클래스
		System.out.println(str);
		
		List<String> list2 = new ArrayList<String>();
		list2.add("abc");
		String str2 = list2.get(0);	//형변환 안해줌.
		System.out.println(str2);
		
		/* - list3는 List 인터페이스를 구현한 구현클래스들의 객체 중 아무나 올 수 있다.
		 * 	- list3 = new ArrayList<String>(); => 가능
		 * 	- list3 = new LinkedList<String>(); => 가능
		 * - list4는 ArrayList 클래스를 이용한 객체만 올 수 있다.
		 * 	- list3 = new ArrayList<String>(); => 가능
		 * 	- list3 = new LinkedList<String>(); => 불가능 */
		List<String> list3;
		ArrayList<String> list4;
		
		/* add(객체) : Collection에서 제공하는 메서드(Set에서도 add() 기능이 있다),
		 * 			  객체를 추가하고 추가여부를 알려줌, boolean
		 * 	- 리스트에서는 무조건 true(중복을 허용하기 때문에 넣는대로 들어감)
		 * 	- set에서는 없으면 true, 있으면 false(중복을 허용하지 않기 때문에 중복되면 알려줌) */
		List<String> list5 = new ArrayList<String>();
		list5.add("abc");
		list5.add("def");
		
		/* contains(객체) : Collection, 컬렉션에 객체가 있는지 없는지를 알려줌. boolean
		 * - 이 때, Objects.equals를 이용하여 동작
		 * - 컬렉션에 있는 타입과 객체의 타입이 다르면 false를 return
		 * - 같으면 객체.equals()를 호출해서 결과를 리턴
		 * - 해당 클래스의 equals가 어떻게 오버라이딩 되어 있느냐에 따라 결과가 달라짐. */
		System.out.println(list5.contains("abc"));
		
		/* indexOf(객체) : List에만 있음(Set은 번지가 없기때문에 제공 X). int
		 * 				  객체가 몇번지에 있는지 알려줌, 없으면 -1
		 * - 동작 방식은 contains와 같음 */
		System.out.println(list5.indexOf("abc"));
		
		/* remove(번지) : List에만(Set에는 X), 번지에 있는 객체를 제거한 후 제거한 객체를 반환 
		 * remove(객체) : Collection(Set에도 O), 객체와 일치하는 요소를 제거 후 제거 여부를 반환 */
		list5.remove(0);
		list5.remove("def");
		
		list5.add("123");
		list5.add("456");
		
		/* iterator(), 반복자 : Collection, 컬렉션을 이용하여 반복자를 생성해서 리턴
		 * 						 => 반복자를 이용하여 반복문으로 활용하기 위해서 */
		Iterator<String> it = list5.iterator();
		while(it.hasNext()) {
			String tmp = it.next();
			System.out.println(tmp);
		}
		
		/* size() : Collection, 컬렉션의 크기를 반환 */
		System.out.println(list5.size());
		
		/* forEach() : Collection, 람다식을 이용하여 컬렉션에서 하나 꺼낸 값을 활용할 때 사용
		 * 				컨슈머이기 때문에 리턴타입이 없다. */
		list5.forEach(a->System.out.println(a));
		
		/* sort() : List(Set은 순서를 보장하지 않아서 X),람다식을 이용해서 정렬 기준을 정해주면
		 * 			정해진 정렬 기준대로 리스트를 정렬 
		 * - 정렬 기준은 정수로 알려주고, 음수이면 앞, 0이면 같은 위치, 양수이면 뒤 
		 * - Comparator 인터페이스를 구현한 클래스의 객체가 필요
		 * - 일반적으로는 람다식을 이용하여 익명 객체를 생성해서 활용 */
		list5.sort((s1, s2)-> s1.compareTo(s2));
		
		
		/* Collections.sort() : 리스트이 타입이 comparable 인터페이스를 구현한 구현클래스인 경우
		 * 						해당 기준을 이용하여 정렬해줌.*/
		Collections.sort(list5);
	}

}
