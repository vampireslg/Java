import circularArray.*;
import java.util.Random;
import java.util.*;

public class Operations {
    final static int SIZE = 17;
    public static void main(String[] args) {
	WorkStealing ws; 
	UnboundedDequeue[] ubds = new UnboundedDequeue[10]; 
	for(int i = 0 ; i < 10 ; i ++){
	    ubds[i] = new UnboundedDequeue(0);
	}
	
	System.out.println(">>>>");
	for(int i = 1 ; i < 11 ; i ++){
	    ubds[0].pushBottom(i+ubds[0].getBottom()+1);
	}
	ws = new WorkStealing(ubds[0]);
	ws.start();
    }
		
	
    static class WorkStealing extends Thread{
	final static int PUSH_BOUND = 5;
	final static int STEAL_BOUND = 10;// How much times steal is allowed
	final static int THREADS = 10;
	UnboundedDequeue ud ;
	WorkStealing(UnboundedDequeue ud){
	    this.ud = ud;
	    for(int i = 1; i < 11 ; i ++){
		print(ud.popBottom());
	    }
	    print(" >>>>>" );
	}

	public void run(){
	    /*
	    for(int i = 0 ; i < PUSH_BOUND ;i++){
		ud.pushBottom(i*2+1);
	    }
	    Random random = new Random(47) ;
	    while((!ud.isEmpty())){
		//ud.popBottom();
		print(ud.popBottom());
	    }
	    /*if(ud.isEmpty()){
		ud.stealWork(random.nextInt(THREADS + 1));
	    }
	    */
	    
	}
	//public void stealWork(
    }

    //public static void threadPop


    public static void print(Object obj){
	System.out.println(obj);
    }
}
