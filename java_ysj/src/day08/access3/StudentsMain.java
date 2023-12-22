package day08.access3;

public class StudentsMain {

	public static void main(String[] args) {
		
		Students stds = new Students();
		
		stds.setGrade(1);
		stds.setClassNum(5);
		stds.setNum(18);
		stds.setName("양선진");
		stds.printInfo();
		
		stds.printInfo2(3,10, 20, "홍길동");
		
	}

}
