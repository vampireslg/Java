package circularArray;

public class CircularArray {
    private static int logCapacity ;
    private static int[] currentTasks;
    public CircularArray(int myLogCapacity){
	logCapacity = myLogCapacity ;
	currentTasks = new int[1 << logCapacity];
    }
    public int capacity(){
	return 1 << logCapacity ;
    }
    public int get (int i){
	return currentTasks[i % capacity()];
    }
    public void put(int i, int task){
	this.currentTasks[i % capacity()] = task;
	//System.out.println(task+" ---- ");
    }
	
    public CircularArray resize( int bottom, int top ){
	int[] oldTasks = new int[capacity()];
	for (int i = top ;i < bottom ; i++){
	    oldTasks[ i % capacity()] = get(i);
	}
	CircularArray newTasks = new CircularArray(this.logCapacity + 1);
	for (int i = top ;i < bottom ;i++){
	    int tem = oldTasks[i % capacity()];
	    newTasks.put(i,tem);
	}
	return newTasks;
    }

    public void print(Object obj){
	System.out.println(obj);
    }
}