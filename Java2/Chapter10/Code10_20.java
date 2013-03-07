import javax.swing.*;
import java.io.*;
import static Package.print.Print.*;

public class Code10_20{
    public static void main(String[] args){
	byte b[]=new byte[32];
	try{FileInputStream input=new FileInputStream("Code10_20.java");
	    ProgressMonitorInputStream in=
		new ProgressMonitorInputStream(null, "ReadFile", input);
	    //get Progress Monitor
	    ProgressMonitor p=in.getProgressMonitor(); 
	    while(in.read(b)!=-1){
		String s=new String(b);
		print(s);
		Thread.sleep(200);
	    }
	}catch(Exception e){}
	
    }
}