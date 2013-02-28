import java.util.*;

class Cal{
    public static void main(String[] args){
	Calendar calendar=Calendar.getInstance();
	//calendar.setTime(new Date());
	calendar.set(2013,1,27);
	long timeToday=calendar.getTimeInMillis();
	calendar.set(2016,5,1);
	long timeTom=calendar.getTimeInMillis();
	long interval = (timeTom-timeToday)/(1000*60*60*24);
	System.out.println("You Got "+interval+" Days Left .");
	
    }
}