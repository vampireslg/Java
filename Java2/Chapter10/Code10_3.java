import java.io.*;
public class Code10_3{
    public static void main(String[] args){
	try{
	    Runtime ce=Runtime.getRuntime();
	    ce.exec("javac Code10_2.java");
	    ce.exec("java Code10_2.java");
	    File file=new File("/usr/share/lintian/overrides/" , "gnome-terminal");
	    ce.exec(file.getAbsolutePath());
	}catch(Exception e){
	    System.out.println(e);
	}
    }
}