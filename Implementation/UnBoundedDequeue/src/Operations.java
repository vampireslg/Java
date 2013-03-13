import circularArray.*;
import java.util.Random;
import java.util.*;

public class Operations {
    final static int SIZE = 17;
    public static void main(String[] args) {
	WorkStealing ws; 
	List <UnboundedDEQueue> ubds = new ArrayList<UnboundedDEQueue>(10) ;
	/*for(int i = 0 ; i < 10 ; i ++){
	    ubds.add(UnboundedDEQueue(0));
	}
	*/	
	System.out.println(">>>>");
	System.out.println(ubds.get(0).size());
	//ws = new WorkStealing(ubds.get(1));
	//	ws.start();
    }
		
	
     class WorkStealing extends Thread{
	final static int PUSH_BOUND = 10;
	final static int STEAL_BOUND = 10;// How much times steal is allowed
	UnboundedDEQueue ud ;
	WorkStealing(UnboundedDEQueue ud){
	    this.ud = ud;			
	}
	public void run(){
	    for(int i = 0 ; i < PUSH_BOUND ;i++){
		ud.pushBottom(i*2+1);
	    }
	    Random random = new Random(10) ;
	    while((!ud.isEmpty())){
		print(ud.popBottom());
	    }
	    /*if(ud.isEmpty()){
	      ud.stealWork();
	      }
	    */
	}
    }


    public void print(Object obj){
	System.out.println(obj);
    }
}
