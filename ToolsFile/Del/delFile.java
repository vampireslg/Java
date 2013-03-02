import java.io.*;
import java.util.*;
import static Package.print.Print.*;
/*
  Del line num1--num2 of File1 
  @copyrightL 
*/

class delFile{
    public static void main(String[] args){
	Scanner s0=new Scanner(System.in);
	Scanner s1=new Scanner(System.in);
	Scanner s2=new Scanner(System.in);
	String file=s0.next();
	int startLine= s1.nextInt(), endLine=s2.nextInt();
	del_start_util_end(file,startLine,endLine);

    }
    public static void  del_start_util_end(String file1, int line1, int line2){
	long startPoint=line1 , endPoint=line2;


	//Copy contents from file1 ;
	try{
	    long lines_counter=1;
	    RandomAccessFile contents=new RandomAccessFile(file1, "rw");
	    StringBuffer file_buffer=new StringBuffer ();
	    String str=null;
	    
	    while (lines_counter<=line2&&(str=contents.readLine())!=null){
		if(lines_counter<line1)
		    file_buffer.append(str).append("\r\n");
		lines_counter++;
	    }
	    
	     
	    //Move contents below line3 in file2
	    while((str=contents.readLine())!=null){
		file_buffer.append(str).append("\r\n");
	    }
	    print("******************\n"+"line: "+line1 + " to line: "+line2+ " were removed ");
	    print("******************");
	    
	    //Get the Paste done;
	    BufferedWriter bw=new BufferedWriter(new FileWriter(file1));
	    bw.write(file_buffer.toString());
	    bw.close();	    
	    contents.close();

	}catch(IOException e){}
       

    }
}