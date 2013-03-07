import java.util.*;
import java.text.SimpleDateFormat;
/*
 Time left for graduate.
 */
class Cal{
    public static void main(String[] args){
	SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy.MM.dd");
	String str = sDateFormat.format(new java.util.Date());
	String cal[] = new String[3] ; cal = str.split("\\.");
	int calInt[] = new int[3];
	for (int i = 0 ; i < 3 ; i ++){
	    calInt[i] = Integer.parseInt(cal[i]);
	}
	
	Calendar calendar=Calendar.getInstance();
	calendar.set(calInt[0] ,calInt[1] - 1 ,calInt[2]);
	long timeToday=calendar.getTimeInMillis();
	calendar.set(2016,5,1);
	long timeTom=calendar.getTimeInMillis();
	long interval = (timeTom-timeToday)/(1000*60*60*24);
	System.out.println("\n You got "+interval+" days left .\n Stay sharp !  React fast !! \n");
	
    }
}