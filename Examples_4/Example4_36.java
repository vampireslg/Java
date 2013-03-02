class Rect{
 double width,height,area;
 public double getArea(){
	 area = width*height;
	 return area;
 }
}
public class Example4_36 {
	public static void main(String args[]){
		try{	Class cs=Class.forName("Rect");
				Rect rect=(Rect)cs.newInstance();
				rect.width=100;
				rect.height=200;
				System.out.print("The area of the rect " + rect.getArea());
		}
		catch(Exception e){}
	}

}
