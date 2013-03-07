import java.util.*;
class Student{
	String name;
	int number;
	Student(String name,int number){
		this.name=name;
		this.number=number;
	}
}
public class Code13_2 {
	public static void main(String[] args) {
		List list=new LinkedList();
		for(int i=1;i<=22222;i++){
			list.add(new Student("I am"+i, i));
		}
		Iterator iter=list.iterator();
		long time1=System.currentTimeMillis();
		while(iter.hasNext()){
			Student te=(Student) iter.next();
		}
		long time2=System.currentTimeMillis();
		System.out.println("Time for traverse of the linkedlist : "+ (time2-time1));
		time1=System.currentTimeMillis();
		for(int k=0;k<list.size();k++){
			Student te=(Student)list.get(k);
		}
		time2=System.currentTimeMillis();
		System.out.println("Time for traverse of the linkedlist : "+ (time2-time1));
	}
}