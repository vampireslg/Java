public class Foo{
    public static void main(String[] args){
	Foo f = new Foo();
	int a = 7;
	int b = 14;
	int x = (f.bar(21) + a) * b;
	System.out.println("-----------\n");
    }

    public int bar(int n) {return n + 42 ;}
}