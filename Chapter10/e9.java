import java.io.*;

public class e9{
    public static void main(String[] args){
	double x=0.98;
	boolean bo=true;
	try{
	    PrintStream ps=new PrintStream(new FileOutputStream("p.txt"));
	    ps.print(12345);
	    ps.println("Gbye,Cruel World");
	    ps.println(234);
	    ps.println(x);
	    ps.println(bo);
	    ps.close();
	}catch (IOException e){}
    }
}