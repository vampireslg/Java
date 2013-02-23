
public class DataRace {
	public static void main(String[] args) {
		Process pro=new Process();
		pro.setNum(5000);
		pro.thread1.start();
		pro.thread2.start();
	}
}
class Process implements Runnable {
	private int number=0;
        private int con1=0, con2=0;
        private int readnum=0;
	Thread thread1, thread2;
	Process(){
		thread1=new Thread(this);
		thread1.setName("Thread___1");
		thread2=new Thread(this);
		thread2.setName("Thread___2");
	}
    public void setNum(int mount){
	number=mount;
    }
    public void run() {
	while(number > 0){
	    if  (Thread.currentThread()==thread1){
		number=number + 1;con1 = con1 + 1;
		//System.out.println("I am thread 1, number remains : " + number);
		if(number > 100000){
		    System.out.println(thread1.getName() + " is a dead thread "+ ",I have run for "+con1+" times" );
		    return;
		}
	    }
	    else if (Thread.currentThread()==thread2){
		readnum = number; readnum = readnum -1;
		number=readnum;con2 = con2 + 1;
		//System.out.println("I am thread 2, number remains : " + number);
		if(number <=0 ){
		    System.out.println(thread2.getName() + " is a dead thread "+",I have run for "+con2+" times");
		    return;
		}
	    } 
	    
	}
    }
}
