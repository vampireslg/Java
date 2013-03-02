import java.io.*;
import java.net.*;

public class Client{
    public static void main(String[] args){
	String s = null ;
	Socket mysocket;
	DataInputStream in = null ;
	DataOutputStream out = null ;
	BufferedReader br = null;//new BufferedReader(new InputStreamReader(System.in));
	try{
	    mysocket = new Socket("192.168.8.134", 1234);
	    in = new DataInputStream(mysocket.getInputStream());
	    out = new DataOutputStream(mysocket.getOutputStream());
	    /*for (int i = 1 ;i < 100; i += 2){
		out.writeUTF(""+ i);
		s=in.readUTF();
		System.out.println(">> L : "+s + " << ");
		Thread.sleep(500);
	    }
	    */
	    //String message = null;
	    
	}catch(Exception e){
	    System.out.println("Server's Terminated ." );}
    }

}