import java.util.*;
public class baiduHashView {
	public static void main(String[] args) {
		HashMap hm=new HashMap();
		//Element[] elm=new Element[10];
		for (int i=0;i<10;i++){
			
			hm.put(new Element(i), new Figureout());
			//System.out.println("hm: ");
			//System.out.println("Get the result for Element ");
			System.out.println((Figureout)hm.get(new Element(i)));
		}
		
		System.out.println("-------------I AM THE LOVELY CUTTING LINE ------------");
		//Element test;
		for(int k=0;k<10;k++){
		Element test= new Element(k);
		if(hm.containsKey(test))
			System.out.println((Figureout)hm.get(test));
		else
			System.out.println("Not found ");
		//System.out.println(k.hashCode());
		}		
	}

	private static Object Element(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}

class Element{
	int number;
	public Element(int n){
		number=n;
	}
	public int hashCode(){
		return number;
	}
	public boolean equals(Object o){
		return (o instanceof Element)&&(number==((Element)o).number);
	}
}

class Figureout{
	Random r=new Random();
	boolean possible=r.nextDouble()>0.5;
	public String toString(){
		if(possible)
			return "OK!";
		else
			return "Impossible ! ";
	}
}