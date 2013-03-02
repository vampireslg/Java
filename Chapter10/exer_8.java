import java.io.*;
import static Package.print.Print.*;
import java.util.Scanner;
/*
  Read file by line and ADD line number ,then write it to another file .  
  @copyrightL 
*/

class exer_8{
    public static void main(String[] args){
	Scanner file=new Scanner(System.in);
	String fileName=file.next();
	Scanner file2=new Scanner(System.in);
	String file_copy_name=file2.next();
	read_by_line(fileName,file_copy_name);
	
    }
    public static void  read_by_line(String file,String file_copy_name){
	
	//Copy contents from file ;
	try{
	    int lines_counter=1;
	    RandomAccessFile contents=new RandomAccessFile(file, "rw");
	    StringBuffer file_buffer=new StringBuffer ();
	    String str=null;
	    
	    while ((str=contents.readLine())!=null){
		file_buffer.append(Integer.toString(lines_counter)+"  ").append(str).append("\r\n");
		lines_counter++;
	    }
	    // Print the contents with line number :
	    print(file_buffer);
	    
	    //Write file's contents to another file :
	    BufferedWriter bw=new BufferedWriter(new FileWriter(file_copy_name));
	    bw.write(file_buffer.toString());
	    bw.close();	    

	    contents.close();

	}catch(IOException e){}
       

    }
}
