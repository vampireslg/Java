package ct;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Client{
    private static final int PORT = 7788;
    private static ExecutorService exec = Executors.newCachedThreadPool();

    public static void main(String[] args){
	new Client();
    }
    
    public Client(){
	try{
	    Socket socket = new Socket("192.168.1.34", PORT);
	    exec.execute(new SendMsg(socket));
	    System.out.println("[" + socket.getInetAddress() + "] ' Joining ... ");

	    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    String msg;
	    while((msg = br.readLine())!=null){
		System.out.println(msg);
	    }
	}catch(IOException e){
	}
    }

    /*
      Client thread get infor from Servers
    */
    static class SendMsg implements Runnable{
	private Socket socket;

	public SendMsg(Socket socket){
	    this.socket = socket;
	}

	public void run(){
	    try{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
		String msg;

		while(true){
		    msg = br.readLine();
		    pw.println(msg);

		    if(msg.trim().equals("-quit")){
			pw.close();
			br.close();
			exec.shutdownNow();
			break;
		    }
		}
	    }catch (Exception e){
		e.printStackTrace();
	    }
	}
    }
}
	    
      
	
	