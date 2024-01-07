package day15;

public class LamdaEx3 {

	public static void main(String[] args) {
		MyNumber max = (x,y)-> x>=y? x : y;
		System.out.println(max.getMax(10, 20));
		
		StringConcat scc = (s1, s2)-> System.out.println(s1+ ", " +s2);
		scc.makeString("Hello", "World!");
		
		StringConcat s1 = new StringConcat() {

			@Override
			public void makeString(String s1, String s2) {
				System.out.println(s1 + ", " + s2);
			}
		};
	}

	@FunctionalInterface
	public interface MyNumber {
	int getMax(int x, int y);
	}
	
	@FunctionalInterface
	public interface StringConcat {
		public void makeString(String s1, String s2);
	}
}