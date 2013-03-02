package ct;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class ChatServer{
    private static final int PORT = 7788;
    private static List<Socket> list = new ArrayList<Socket>(); //Conserve chaters.
    private ExecutorService exec;
    private ServerSocket server;

    public static void main(String[] args){
	new ChatServer();
    }

    public  ChatServer(){
	try{
	    server = new ServerSocket(PORT);
	    exec = Executors.newCachedThreadPool();
	    System.out.println("SERVEVISE'S ENABLED ...\nNow U Can Have a Chat .");

	    Socket client = null;
	    while(true){
		client = server.accept(); // Accept user
		list.add(client);
		exec.execute(new ChatTask(client));
	    }
	}catch (IOException e){
	    e.printStackTrace();
	}
    }


    static class ChatTask implements Runnable{
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;
	private String msg;


	public ChatTask(Socket socket)throws IOException{
	    this.socket = socket;
	    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    msg = "["+this.socket.getInetAddress()+"] Joined In Chatroom ..";
	    sendMsg();
	}

	public void run(){
	    try{
		while((msg = br.readLine())!=null){
		    if(msg.trim().equals("-quit")){
			list.remove(socket);
			pw.close();
			br.close();
			msg = "["+socket.getInetAddress() +"] 's Leaving . ";
			socket.close();

			sendMsg();
		    }else{
			msg = "[" + socket.getInetAddress() + "] : " + msg;
			sendMsg();
		    }
		}
	    }catch (IOException e){
		e.printStackTrace();
	    }
	}

	/*
	 *Send Message to all .
	 */
	private void sendMsg() throws IOException{
	    System.out.println(msg);
	    for (Socket client : list){
		pw = new PrintWriter(client.getOutputStream(), true);
		pw.println(msg);
	    }
	}
    }
}