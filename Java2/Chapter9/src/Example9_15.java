class A implements Runnable{
    int i=100,j=0;    
	String name;
	public void run(){
		while(true){
		    j++;
		    System.out.println(name+", And my current number is:  "+i);
		    if(j==5){
			try{suspendThread();
			}
			catch(Exception e){}
		    }
		    try{Thread.sleep(1000);
		    }
		    catch(Exception e){}
		}
	}
    public synchronized void suspendThread() throws InterruptedException{
	wait();
	    }
    public synchronized void reviveThread(){
	notifyAll();
    }
}
public class Example9_15{
    public static void main(String args[]){
	int m=0;
	A target=new A();
	target.name="childThread";
	Thread thread=new Thread(target);
	thread.setName(target.name);
	thread.start();
	while(true){
	    m++;
	    System.out.println("I am the root thread ,the current number is :  "+m);
	    if(m==10){
		System.out.println("\n !!!!!!!!!!!!!!!!!!!!!!!! \n Let "+thread.getName()+" go on with it's work \n!!!!!!!!!!!!!!!!!!!!!!!! \n ");
		try{target.reviveThread();
		}
		catch(Exception e){}
		break;
	    }
	    try {Thread.sleep(1000);}
	    catch(Exception e){}
	}
    }
}
