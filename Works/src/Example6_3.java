import java.util.*;
public class Example6_3 {
	public static void main(String[] args) {
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat ");
		Calendar calendar=Calendar.getInstance();
		calendar.set(2012, 00,17);
		int whatDay=calendar.get(Calendar.DAY_OF_WEEK)-1;
		String a[]=new String[whatDay+31];
		for(int i=0;i<whatDay;i++){
			a[i]="***";
		}
		for(int i=whatDay,n=1;i<whatDay+31;i++){
			if(n<=9)
				a[i]=String.valueOf(n)+"  ";
			else
				a[i]=String.valueOf(n)+" ";
			n++;
		}
		for(int i=0;i<a.length;i++){
			if(i%7==0)
				System.out.println(" ");
			System.out.print(" "+a[i]);
		}
		double aa=129.3487;
		String str=String.valueOf(aa);
		int index=str.indexOf(".");
		
		System.out.println("\n"+str);
		System.out.println(index);
	}
}
