package circularArray;

import java.util.concurrent.atomic.AtomicReference;

public class UnboundedDEQueue {
	private final static int LOG_CAPACITY = 4;
	private volatile CircularArray tasks;
	volatile int bottom;
	AtomicReference<Integer> top;;
	public UnboundedDEQueue(int LOG_CAPACITY){
		tasks = new CircularArray(LOG_CAPACITY);
		top = new AtomicReference<Integer>(0);
		bottom = 0;
	}
	boolean isEmpty(){
		int localTop = top.get();
		int localBottom = bottom ;
		return (localBottom <= localTop);
	}
	
	public void pushBottom(Runnable r){
		int oldBottom = bottom; 
		int oldTop = top.get();
		CircularArray currentTasks = tasks;
		int size = oldBottom - oldTop ;
		if(size >= currentTasks.capacity()-1){
			currentTasks = currentTasks.resize(oldBottom, oldTop);
			tasks = currentTasks;
		}
		tasks.put(oldBottom , r);
		bottom = oldBottom + 1;
	}	// 
	public Runnable popTop(){
		int oldTop = top.get();
		int newTop = oldTop + 1;
		int oldBottom = bottom;
		CircularArray currentTasks = tasks;
		int size = oldBottom - oldTop ;
		if(size <= 0) return null	;
		Runnable r = tasks.get(oldTop);
		if(top.compareAndSet(oldTop, newTop))
			return r;
		return null;
	}
	public Runnable popBottom(){
		CircularArray currentTasks = tasks ;
		bottom-- ;
		int oldTop = top.get();
		int newTop = oldTop + 1;
		int size = bottom - oldTop;
		if(size < 0){
			bottom = oldTop ;
			return null;
		}
		Runnable r = tasks.get(bottom);
		if(size > 0)
			return r;
		if (!top.compareAndSet(oldTop, newTop))
			r = null ;
		bottom = oldTop + 1;
		return r;
	}
}
