package circularArray;

public class CirArray {
	private  int logCapacity ;
	private  int[] currentTasks;
	public CirArray(int myLogCapacity){
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

	public CirArray resize( int bottom, int top ){
	CirArray newTasks = new CirArray(this.logCapacity + 1);
	for (int i = top ;i < bottom ;i++){
	    int tem = get(i);
	    newTasks.put(i,tem);
	}
	return newTasks;
    }
	
	public void print(Object obj){
		System.out.println(obj);
	}
}