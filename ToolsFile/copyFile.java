import java.io.*;
import static Package.print.Print.*;
/*
  Copy line num1--num2 of File1 to File2 below line3  
  @copyrightL 
*/

class copyFile{
    public static void main(String[] args){
	
	copy_file1_to_file2("copyFile.java",3,6,"receiver.txt",4);

    }
    public static void  copy_file1_to_file2(String file1, int line1, int line2,
					    String file2, long line3){
	long startPoint=line1 , endPoint=line2;
	//long startPoint_2=line3;


	//Copy contents from file1 ;
	try{
	    long lines_counter=0;
	    RandomAccessFile contents_1=new RandomAccessFile(file1, "rw");
	    RandomAccessFile contents_2=new RandomAccessFile(file2, "rw");
	    StringBuffer file_buffer=new StringBuffer ();
	    String str=null;
	    
	    while (lines_counter<line3&&(str=contents_2.readLine())!=null){
		file_buffer.append(str).append("\r\n");
		lines_counter++;
	    }
	    
	    lines_counter = 1;
	    

	    while(lines_counter<line1){
		str = contents_1.readLine();
		lines_counter++;
	    }

	    for(long i=startPoint; i<=endPoint; i++){
		str = contents_1.readLine();
		file_buffer.append(str).append("\r\n");

	    }


	    //Move contents below line3 in file2
	    while((str=contents_2.readLine())!=null){
		file_buffer.append(str).append("\r\n");
	    }
	    print(file_buffer);	    
	    
	    //Get the Paste done;
	    BufferedWriter bw=new BufferedWriter(new FileWriter(file2));
	    bw.write(file_buffer.toString());
	    bw.close();	    

	    contents_2.close();
	    contents_1.close();

	}catch(IOException e){}
       

    }
}
