public class Example9_20{
    public static void main(String args[]){
	Daemon a=new Daemon();
	a.A.start();
	a.B.setDaemon(true);
	a.B.start();
    }
}
class Daemon implements Runnable{
    Thread A, B;
    Daemon(){
	A=new Thread(this);
	B=new Thread(this);
    }
    public void run(){
	if(Thread.currentThread()==A){
	    for(int i=1;i<10;i++){
		System.out.println("i = "+i);
		try{Thread.sleep(1000);
		}
		catch(InterruptedException e){}
	    }
	}
	else if(Thread.currentThread()==B){
	    while(true){
		System.out.println("Thread B is Daemon thread .");
		try{Thread.sleep(1000);
		}
		catch(InterruptedException e){}
	    }
	}
    }
}