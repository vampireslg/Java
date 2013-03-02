import java.lang.reflect.*;
class Rect{
	double width,height,area;
	public double getArea(){
		area=height*width;
		return area;
	}
}

public class Example4_35{
	public static void main(String args[]){
	    Rect rect=new Rect();
	    Class cs=rect.getClass();
	    String className=cs.getName();
	    Constructor[] con=cs.getDeclaredConstructors();
	    Field[] field=cs.getDeclaredFields();
	    Method[] method=cs.getDeclaredMethods();
	    System.out.println("Name of the class: "+className);
	    System.out.println("filed of the class: " );
	    for (int i=0;i<field.length;i++){
		System.out.println(field[i].toString());
	    }
	}
}
    
