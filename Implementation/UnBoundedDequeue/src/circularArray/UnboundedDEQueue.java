package circularArray;
import java.util.concurrent.atomic.AtomicReference;
import static print.Print.*;

public class UnboundedDEQueue {
    //private final static int LOG_CAPACITY = 4;
    private volatile CircularArray tasks;
    volatile int bottom;
    AtomicReference<Integer> top;;
    public UnboundedDEQueue(int LOG_CAPACITY){
	tasks = new CircularArray(LOG_CAPACITY);
	top = new AtomicReference<Integer>(0);
	bottom = 0;
    }
    public boolean isEmpty(){
	int localTop = top.get();
	int localBottom = bottom ;
	return (localBottom <= localTop);
    }
	
    public void pushBottom(int r){
	int oldBottom = bottom; 
	int oldTop = top.get();
	CircularArray currentTasks = tasks;
	int size = oldBottom - oldTop ;
	if(size > currentTasks.capacity()-1){
	    currentTasks = currentTasks.resize(oldBottom, oldTop);
	    tasks = currentTasks;
	}
	tasks.put(oldBottom , r);
	bottom = oldBottom + 1;
    }	
    public int popTop(){
	int oldTop = top.get();
	int newTop = oldTop + 1;
	int oldBottom = bottom;
	int size = oldBottom - oldTop ;
	if(size <= 0) return -1	;
	int r = tasks.get(oldTop);
	if(top.compareAndSet(oldTop, newTop))
	    return r;
	return -1;
		
    }
    public int popBottom(){
	CircularArray currentTasks = tasks ;
	bottom-- ;
	int oldTop = top.get();
	int newTop = oldTop + 1;
	int size = bottom - oldTop;
	if(size < 0){
	    bottom = oldTop ;
	    return -1;
	}
	int r = tasks.get(bottom);
	if(size > 0)
	    return r;
	if (!top.compareAndSet(oldTop, newTop))
	    r = -1 ;
	bottom = oldTop + 1;
	return r; 
   }
    public int getBottom(){
	int oldTop = top.get();
	int oldBottom = bottom - 1;
	if(oldBottom - oldTop >= 0)
	    return tasks.get(oldBottom);
	return -1;
	
    }
    
    public int size(){
	int oldTop = top.get();
	return (bottom - oldTop);
    }
    
    
}

class CircularArray {
    private static int logCapacity ;
    private static int[] currentTasks;
    public CircularArray(int myLogCapacity){
	this.logCapacity = myLogCapacity ;
	this.currentTasks = new int[1 << logCapacity];
    }
    public int capacity(){
	return 1 << logCapacity ;
    }
    public int get (int i){
	return this.currentTasks[i % capacity()];
    }
    public void put(int i, int task){
	this.currentTasks[i % capacity()] = task;
    }
	
    public CircularArray resize(int bottom, int top){
	int[] oldTasks = new int[bottom - top];
	for (int i = 0 ; i < bottom - top; i++){
	    oldTasks[i] = get(i);
	}
	CircularArray newTasks = new CircularArray(this.logCapacity + 1);
	for (int i = top ;i < bottom ;i++){
	    newTasks.put(i, oldTasks[i+top]);
	}
	return newTasks;
    }
	
}
