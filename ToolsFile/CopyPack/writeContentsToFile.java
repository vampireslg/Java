import java.io.*;
import java.util.Scanner;

/*
@Slipper
*/

class writeContentsToFile{
    public static void main(String[] args){
	//Get filename, contens ,and loc;
	System.out.println("< Contents, FileName, Location > \n ");
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String fcl[] = new String[3];
	try{
	    String te = br.readLine();
	    fcl = te.split(",");
	}catch(IOException e){}
	copyCTF(fcl[0], fcl[1], Integer.parseInt(fcl[2]));
    }

    public static void copyCTF(String contents, String file,int loc){
	try{
	    long lines_counter = 0;
	    RandomAccessFile f=new RandomAccessFile(file, "rw");
	    StringBuffer file_buffer = new StringBuffer();
	    
	    String str = null;
	    while(lines_counter < loc && (str = f.readLine())!=null){
		file_buffer.append(str).append("\r\n");
		lines_counter++;
	    }
	    file_buffer.append(contents).append("\r\n");

	    while((str = f.readLine())!=null){
		file_buffer.append(str).append("\r\n");
	    }


	    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	    bw.write(file_buffer.toString());
	    bw.close();

	    f.close();
	}catch(IOException e){}
    }
}