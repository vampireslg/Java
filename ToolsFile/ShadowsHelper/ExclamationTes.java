import java.io.*;

//For test whether last words of 'pwd > pwd.lg #!' if ! 
public class ExclamationTes{
    public static void main(String[] args){
	File f = new File ("s.s");
	ExclamationTes(f);
    }

    private static void ExclamationTes(File file){
	try{
	    RandomAccessFile contents = new RandomAccessFile(file, "rw");
	    StringBuffer fileBuffer = new StringBuffer();
	    String str = null;
	    
	    while((str = contents.readLine()) != null){
		if(str.endsWith("6!"))
		    System.out.println(false);
		else System.out.println(true);
	    }
	}catch (IOException e){}
    }
}
	
	