package concurrentQueue;
import java.util.LinkedList;
import java.util.*;

public class ConcurrentLinkedListQueue {
	private volatile List<Object> list = new LinkedList<Object>();
	
	public void enqueue(Object obj){
		list.add(obj);
	}
	
	public Object dequeue(Object obj){
		list.removeFirst(obj);
	}
}
