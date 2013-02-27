import java.io.*;
import java.util.Scanner;

/*
@Slipper
*/

class writeBack{
    public static void main(String[] args){
	//Get filename, contens ,and loc;
	System.out.println("< Contents, Location > \n ");
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String fcl[] = new String[2];
	try{
	    String te = br.readLine();
	    fcl = te.split(",");
	}catch(IOException e){}
	copyCTF(fcl[0], "/home/gaoang/s.s", Integer.parseInt(fcl[1]));
    }

    public static void copyCTF(String contents, String file,int loc){
	try{
	    long lines_counter = 0;
	    int location = loc + 16;
	    RandomAccessFile f=new RandomAccessFile(file, "rw");
	    StringBuffer file_buffer = new StringBuffer();
	    
	    String str = null;
	    while(lines_counter < location && (str = f.readLine())!=null){
		file_buffer.append(str).append("\n");
		lines_counter++;
	    }
	    file_buffer.append(contents).append("\n");

	    while((str = f.readLine())!=null){
		file_buffer.append(str).append("\n");
	    }
	  
	    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	    bw.write(file_buffer.toString());
	    bw.close();

	    f.close();
	}catch(IOException e){}
    }
}