import java.io.*;
import java.util.Scanner;

/*
  Remove cons from /home/gaoang/s.s
  @Slipper
*/

class RemoveContentsFromFile{
    public static void main(String[] args){
	//Get filename, contens ,and loc;
	System.out.println("< Ins' Location > \n ");
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	String loc[] = new String[16];
	try{
	    String str = bf.readLine()+",0000";
	    loc  = str.split(",");
	}catch (IOException e){}
	remove("/home/gaoang/s.s", loc);
    }

    public static void remove( String file,String loc[]){
	try{
	    long lines_counter = 1;int num = 0 ;
	    int location = Integer.parseInt(loc[num]) + 16;
	    RandomAccessFile f=new RandomAccessFile(file, "rw");
	    StringBuffer file_buffer = new StringBuffer();
	    
	    String str = null;
	    while( (str = f.readLine())!=null){
		if (lines_counter == location){
		    num ++;
		    location = Integer.parseInt(loc[num]) + 16 ;
		    lines_counter ++ ;
		    continue;
		}
		file_buffer.append(str).append("\n");
		lines_counter++;
	    }
	    /*str = f.readLine(); // Omit on line of Ins

	    while((str = f.readLine())!=null){
		file_buffer.append(str).append("\n");
	    }
	    */
	    
	    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	    bw.write(file_buffer.toString());
	    bw.close();

	    f.close();
	}catch(IOException e){}
    }
}