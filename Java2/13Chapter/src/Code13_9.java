import java.util.*;
class StudentKey implements Comparable{
	double key=0;
	StudentKey(double key){
		this.key=key;
	}
	public int compareTo(Object o){
		StudentKey st=(StudentKey) o;
		if(this.key-st.key==0)
			return -1;
		else 
			return (int)((this.key-st.key)*1000);
	}
}
class Stud{
	String name=null;
	double math, english;
	Stud(String n, double m,double e){
		name=n;
		math=m;
		english=e;		
	}
}
public class Code13_9 {
	public static void main(String[] args) {
		TreeMap treemap=new TreeMap(new Comparator(){
			public int compare(Object a, Object b){
				StudentKey key1=(StudentKey) a;
				StudentKey key2=(StudentKey) b;
				return key1.compareTo(key2);
			}
		});
		String str[]={"Abracadabra","Bracadabra","Cadabra","Dabra"};
		double math[]={76, 89, 65, 90};
		double english[]={67,66,90,87};
		Stud student[]=new Stud[4];
		for(int i=0; i<student.length; i++){
			student[i]=new Stud(str[i],math[i],english[i]);
		}
		StudentKey key[]=new StudentKey[4];
		for(int k=0; k<key.length; k++){
			key[k]=new StudentKey(student[k].math);
		}
		for (int i=0;i<student.length;i++){
			treemap.put(key[i], student[i]);
		}
		int number=treemap.size();
		System.out.println(number + " objects in the TREEMAP , sort w.r.t math record :");
		Collection collection=treemap.values();
		Iterator iter=collection.iterator();
		while(iter.hasNext()){
			Stud stu=(Stud) iter.next();
			System.out.println(" Name : " + stu.name + " Math :" + stu.math);
			
		}
		treemap.clear();
		for(int k=0; k<key.length; k++){
			key[k]=new StudentKey(student[k].english);
		}
		for (int i=0;i<student.length;i++){
			treemap.put(key[i], student[i]);
		}
		number=treemap.size();
		System.out.println(number + " objects in the TREEMAP , sort w.r.t english record :");
		collection=treemap.values();
		iter=collection.iterator();
		while(iter.hasNext()){
			Stud stu=(Stud)iter.next();
			System.out.println(" Name : " + stu.name + " English :" + stu.english);
			
		}
				
	}
}
