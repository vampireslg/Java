class A{
	public void f(){
		int startPoint;
		int endPoint;
		char cStart='α',cEnd='ω';
		startPoint=cStart;
		endPoint=cEnd;
		System.out.println("Geek Alphabet: ");
		for(int i=startPoint;i<=endPoint;i++){
			char c ;
			c=(char)i;
			System.out.print(" "+c);
		}
	}
}
class B extends A{
	public void g(){
		int startPoint;
		int endPoint;
		char cStart='a',cEnd='z';
		startPoint=cStart;
		endPoint=cEnd;
		System.out.println("Englis Alphabet: ");
		for(int i=startPoint;i<=endPoint;i++){
			char c ;
			c=(char)i;
			System.out.print(" "+c);
		}
	}
}
public class Problem5_16 {
	public static void main(String[] args) {
		A a=new A();
		a.f();
		System.out.println( );
		B b=new B();
		//b.f();
		b.g();
		
	}
}
