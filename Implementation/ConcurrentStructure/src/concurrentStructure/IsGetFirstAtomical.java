package concurrentStructure;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

public class IsGetFirstAtomical {
	final static int SIZE = 1000000 ;
	public static void main(String[] args) throws Exception {
		/**LinkedList_L<Integer> list = new LinkedList_L<Integer>();
		for(int i = 0 ; i < 100; i++){
			list.addFirst(i);
		}
		RemoveVSGet thread1, thread2;
		thread1 = new RemoveVSGet(list);
		thread2 = new RemoveVSGet(list);
		thread1.start();
		thread2.start();
	}
	*/
		final IsGetFirstAtomical ai = new IsGetFirstAtomical();
	
		new Thread(){
			public void run(){
				for (int i = 0 ; i < 10 ; i++)
					System.out.println(ai.get());
			}
		}.start();
	
		new Thread(){
			public void run(){
				ai.set();
			}
		}.start();
		
		new Thread(){
			public void run(){
				for (int i = 0 ; i < 10 ; i++)
					System.out.println(ai.get());
			}
		}.start();
	}
	
	AtomicInteger atomicInt = new AtomicInteger(0);
	public void set(){
		for(int i = 0 ; i < SIZE ; i ++ )
			atomicInt.set(i);
	}
	
	public int get(){
		return (atomicInt.get());
	}

				
}

class RemoveVSGet extends Thread{
	//The result shows the obviousness of REMOVE & GET 's return is not atomical 
	LinkedList_L<Integer> list;
	private volatile String msg;
	public RemoveVSGet() {
		// TODO Auto-generated constructor stub
	}
	
	public RemoveVSGet(LinkedList_L<Integer> list){
		this.list = list; 
	}
	
	public void run(){
		for(int i = 0 ; i < 10 ; i ++ ){
			System.out.print(this );
			try{
				((LinkedList_L<Integer>)list).removeFirst();
			}catch(NoSuchElementException e){}
		}
	}
}

