import java.util.*;
public class Exercises {
	public static void main(int year1,int month1,int day1, int year2, int month2,int day2) {
		Calendar calendar=Calendar.getInstance();
		calendar.set(year1, month1-1,day1);
		long time_1=calendar.getTimeInMillis();
		calendar.set(year2, month2-1,day2);
		long time_2=calendar.getTimeInMillis();
		long days=(time_2-time_1)/(1000*3600*24);
		System.out.println(days);
		
	}
}
