package concurrentQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Queue_With_Stealing extends Thread{
	final static int STEAL_BOUND = 100; 
	ConcurrentLinkedListQueue[] conQueue;
	ConcurrentLinkedListQueue clq;
	int clqID;
	//Thread[] thread=new Thread[THREAD_NUM];
	public Queue_With_Stealing(ConcurrentLinkedListQueue clq, int clqID, ConcurrentLinkedListQueue[] conQueue) {
		this.clq = clq;
		this.clqID = clqID;
		this.conQueue = conQueue;
	}
	
		public void run(){
			List<Integer> randList = new ArrayList<Integer>();
			for(int i = 0 ; i < this.conQueue.length; i ++){
				if(i == clqID)
					continue;
				randList.add(i);
			}
			System.out.println(clqID);
			Collections.shuffle(randList);
			
			while(!clq.isEmpty()){
				//Steal starts
				//Pick a victim randomly ;
				int stealTry = 0 ; 
				while(stealTry < STEAL_BOUND){
			}
				break;
		}
	}
}
class ConcurrentLinkedListQueue {
	AtomicReference<Node>  queue; 
	public ConcurrentLinkedListQueue() {
		// TODO Auto-generated constructor stub
	}
	ConcurrentLinkedListQueue(AtomicReference<Node> queue){
		this.queue = queue;
	}
	public void enqueue(Object obj){//Note that enQuene and deQueue may occurs concurrently 
		//when only One Node remains .
		Node newNode = new Node(obj);
		//Node tailNode = ; 
	}
	
	//public Object dequeue(){
	
	//}
	
	public boolean isEmpty(){
		return false;
	}
}


class initQueue{
	Node head = new Node(null);
	Node tail = head ;
}

class Node{
	Object val ; 
	AtomicReference<Node> next; 
	public Node(Object obj){
		val  = obj;
		next = new AtomicReference<Node> (null);
	}
}