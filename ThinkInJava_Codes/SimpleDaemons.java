import java.util.concurrent.*;

public class SimpleDaemons implements Runnable{
    public void run(){
	try{
	    while(true){
		TimeUnit.MILLISECONDS.sleep(100);
		System.out.println(Thread.currentThread() + " " + this);
	    }
	}catch(InterruptedException e){
	    System.out.println("Sleep()  Interrupted ");
	}
    }

    public static void main(String[] args){
	for(int i=0; i < 10 ; i ++){
	    Thread daemon = new Thread(new SimpleDaemons());
	    daemon.setDaemon(true);
	    daemon.start();
	}
	System.out.println("All Daemons started");
	try{
	    TimeUnit.MILLISECONDS.sleep(2000);
	    System.out.println("I am awake ");
	}catch(InterruptedException ee){
	}
    }
}