import java.io.*;
public class Code10_4{
    public static void main(String[] args){
	int b;
	byte set[]=new byte[25];
	try{File f=new File("Code10_3.java");
	    FileInputStream in=new FileInputStream(f);
	    while((b=in.read(set, 0, 25))!=-1){
		    String s=new String (set, 0, 25);
		    System.out.print(s);
	    }
	    in.close();
	}catch(IOException e){
	    System.out.println("File read Error: "+e);
	}
    }
}