package day13;

import java.util.Calendar;

public class CalendarEx1 {

	public static void main(String[] args) {
		//캘린터 예제
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		System.out.println(year);
		
		int month = cal.get(Calendar.MONTH) + 1;	//월만 +1 함.
		System.out.println(month);
		
		int day = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
	}

}
