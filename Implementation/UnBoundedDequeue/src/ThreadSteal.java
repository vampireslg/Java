import circularArray.*;

import java.awt.JobAttributes;
import java.util.*;

public class ThreadSteal {
    final static int SIZE = 500; //How many items in dequeue;
    final static int DEQ_NUM = 1000; // Dequeues' number
    public static void main(String[] args) {
    	System.out.println(" >>> \n ");
    	long startTime = System.currentTimeMillis();
    	WorkStealing[] ws=new WorkStealing[DEQ_NUM];
    	UnboundedDequeue[] uDequeues = new UnboundedDequeue[DEQ_NUM]; 
    	for(int i = 0 ; i < DEQ_NUM ; i ++){
    		uDequeues[i] = new UnboundedDequeue(0);
    		for (int j = 1 ; j <= SIZE ;j ++ ){
    			uDequeues[i].pushBottom(j + 1);
    		}
    		ws[i] = new WorkStealing(uDequeues[i], uDequeues);
    	}
    	/**uDequeues[DEQ_NUM] = new UnboundedDequeue(0);
    	for(int i = 1 ; i < SIZE ; i ++){
    		uDequeues[DEQ_NUM].pushBottom(i * 2 + 1);
    	}
    	ws[DEQ_NUM] = new WorkStealing(uDequeues[DEQ_NUM] , uDequeues);
    	 */
    	for (int i = 0 ; i < DEQ_NUM; i ++ )
    		ws[i].start();
    	//ws[DEQ_NUM].start();
    	
    	for(int i = 0; i < DEQ_NUM ; i++)
    		try{ws[i].join();
    		}catch(Exception e){e.printStackTrace();}
    	
    	long endTime = System.currentTimeMillis();
    	System.out.println(" \nTime consuming: " + (endTime - startTime )+ " Millis \n ") ;
    }
		
    static class WorkStealing extends Thread{
    	final static int STEAL_BOUND = 100;// How much times steal is allowed
    	final static int THREADS = DEQ_NUM; //Thread_Number
    	private int stealTry = 0 ;
    	private int stealItem , stealFai = 0, stealSuc = 0 ;//stealSuc ,how much times succeed in stealing 
    	UnboundedDequeue ud ;
    	UnboundedDequeue[] uDequeues;

    	WorkStealing(UnboundedDequeue deq, UnboundedDequeue[] uDequeues){
    		this.ud = deq;
    		this.uDequeues = uDequeues;
    	}

    	public void run(){
    		//Random number list
    		List<Integer> list = new ArrayList<Integer>();
    		for(int i = 0 ; i < THREADS ; i ++ ){
    			list.add(i);
    		}	
    		Collections.shuffle(list);
    		Random rand = new Random();

    		//print(this + " Started  : ");
    		while(!ud.isEmpty()){
    			if(rand.nextInt(10) > 7) {// with 80% to pop an item ,and 20% to push
    				ud.pushBottom(rand.nextInt(10)+1);
    				//print(this + " push an item in it's uDqueue . " + "<<<<<<<<<<<<<<PUSH ");
    			}
    			else{
    				ud.popBottom();
    				//print(this + " pop an item in it's uDqueue . " + "POP >>>>>>>>>>>>>>>>>");
    			}
    			try{Thread.sleep(rand.nextInt(20));
    			}catch(Exception e){}

    			//print("Item " + ud.popBottom() + "  , POPED  From Bottom By    " +  this );
    		}

    		if(ud.isEmpty()){
    			for(Integer i : list  /**  list Record the thread IDs */){
    				if(stealTry == STEAL_BOUND) break;
    				while(!uDequeues[i].isEmpty()){
    					if((stealItem = uDequeues[i].popTop()) != -1){
    						stealSuc ++ ;
    						//print("Item " + stealItem + " , belongs to Thread "  + i +	
    						//	" ; STEALED By  " + this );
    						try{Thread.sleep(rand.nextInt(50));
    						}catch(Exception e){}
    					}

    					else{
    						stealFai ++ ;
    						stealTry ++;
    						print(this + " Steal 's Failed " );
    						continue;
    					}
    				}
    			}
    		}
    		/**print( this + " :  Mission_Completed_Off_Duty_Now_!!_Succeed_In_Stealing_For : " 
    				+ stealSuc 
    				+ "  Failed_In_Stealing_For  " + stealFai ) ;

    		 */
    	}
    }

    public static void print(Object obj){
    	System.out.println(obj);
    }
}
