package day14.work;

import java.util.ArrayList;
import java.util.Iterator;

public class ListIteratorEx1 {

	public static void main(String[] args) {
		//업캐스팅
		ArrayList<Integer> list = new ArrayList<Integer>();
				
		list.add(10);
		list.add(5);
		list.add(1);
		
		Iterator<Integer> it = list.iterator();
		
		while(it.hasNext()) {
			Integer tmp = it.next();
			System.out.println(tmp);
		}
	}

}
