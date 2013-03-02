import java.io.*;
import java.net.*;

public class Server{
    public static void main(String[] args){
	ServerSocket server = null ;
	Socket user = null;
	String s = null;	    
	DataInputStream in = null ;
	DataOutputStream out = null ;
	try{server = new ServerSocket(1234);
	}catch(IOException e){
	    System.out.println(e);
	}
	
	try{
	    System.out.println("Waiting for user's call: ");
	    user = server.accept();
	    in = new DataInputStream(user.getInputStream());
	    out = new DataOutputStream(user.getOutputStream());
	    while(true){
		s = in.readUTF();
		int m =Integer.parseInt(s);
		out.writeUTF("Server's Serving .");
		out.writeUTF("Return ." + 2*m);
		System.out.println("Server's get infor. "+s);
		Thread.sleep(500);
	    }
	}catch(Exception e){
	    System.out.println("Server's terminated ." + e);
	}
    }

}