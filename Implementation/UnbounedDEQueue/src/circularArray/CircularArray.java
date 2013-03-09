package circularArray;

public class CircularArray {
	private int logCapacity ;
	private Runnable[] currentTasks;
	CircularArray(int myLogCapacity){
		logCapacity = myLogCapacity ;
		currentTasks = new Runnable[1 << logCapacity];
	}
	int capacity(){
		return 1 << logCapacity ;
	}
	Runnable get (int i){
		return currentTasks[i % capacity()];
	}
	void put(int i, Runnable task){
		currentTasks[i % capacity()] = task;
	}
	
	CircularArray resize(int bottom, int top){
		CircularArray newTasks = new CircularArray(logCapacity + 1);
		for (int i = top ;i < bottom ;i++){
			newTasks.put(i, get(i));
		}
		return newTasks;
	}
	
}