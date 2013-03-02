class A{
	int x;
	public void setX(int x)
	{this.x = x;
	}
	int getX(){
		return x;
	}
}
class B{
	public void f(A a){
		a.setX(100);
	}
}
public class Mark{
	public static void main(String args[]){
		A a=new A();
		a.setX(8);
		System.out.println(a.getX());
		B b=new B();
		b.f(a);
		System.out.println(a.getX());
	}
}