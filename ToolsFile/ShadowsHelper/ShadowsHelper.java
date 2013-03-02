import java.io.*;
import java.util.Scanner;
import static ade.AddDelExc.*;
import static cpt.CopyPwdToSh.*;
/*
  SshHelper 
  Read file by line and ADD line number ,then write it to another file .  
  @copyrightL 
*/

class ShadowsHelper{
    public static void main(String[] args){
	//Step 1
	opeOnIns("s.s","shadowsHelper.sh");
	//Step 2
	try{
	    RandomAccessFile contents = new RandomAccessFile("pwd.lg", "rw");
	    StringBuffer sb = new StringBuffer();
	    String str = null;
	    sb.append("cd ");
	    while((str = contents.readLine())!=null){
		sb.append(str).append("\n");
	    }
	    BufferedWriter bw = new BufferedWriter(new FileWriter("pwd.lg"));
	    bw.write(sb.toString());
	    bw.close();
	    contents.close();
	}catch (IOException e){
	    e.printStackTrace();
	}
	//Step 3 
	copy_file1_to_file2("pwd.lg", 1, 1, "shadowsHelper.sh", 19);
    }
}