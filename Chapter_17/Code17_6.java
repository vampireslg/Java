import javax.swing.*;
import java.io.*;

public class Code17_6{
    public static void main(String[] args){
	JFileChooser chooser=new JFileChooser();
	int state=chooser.showOpenDialog(null);
	File file=chooser.getSelectedFile();
	if(file!=null&&state==JFileChooser.APPROVE_OPTION){
	    try{FileInputStream in=new FileInputStream(file);
		byte b[]=new byte[1024];
		int n=-1;
		while((n=in.read(b))!=-1){
		    String str=new String(b,0,n);
		    System.out.println(str);
		}
	    }catch(IOException e){}
	}
    }
}