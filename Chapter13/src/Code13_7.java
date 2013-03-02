import java.util.*;

class Stud implements Comparable {
	int english = 0;
	String name;

	Stud(int english, String name) {
		this.english = english;
		this.name = name;
	}

	public int compareTo(Object o) {
		Stud st = (Stud) o;
		if((this.english-st.english)==0)
		    return 1;
		else 
		    return (this.english - st.english);
	}
}

public class Code13_7 {
	public static void main(String[] args) {
		TreeSet mytree = new TreeSet(new Comparator() {
			public int compare(Object a, Object b) {
				Stud stu1 = (Stud) a;
				Stud stu2 = (Stud) b;
				return stu1.compareTo(stu2);
			}
		});
		Stud st1, st2, st3, st4,st5;
		st1 = new Stud (90, "StudentA");
		st2 = new Stud (66, "StudentB");
		st3 = new Stud (86, "StudentC");
		st4 = new Stud (76, "StudentD");
		st5 = new Stud (90, "StudnetE");
		mytree.add(st1);
		mytree.add(st2);
		mytree.add(st3);
		mytree.add(st4);
		mytree.add(st5);
		Iterator te = mytree.iterator();
		while (te.hasNext()) {
			Stud stu = (Stud) te.next();
			System.out.println(" " + stu.name + "" + stu.english);
		}
		System.out.println(mytree.size());
		mytree.clear();
		if(!te.hasNext())
			System.out.println(" No element left .");
		
	}
}
