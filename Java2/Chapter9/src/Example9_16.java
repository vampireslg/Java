import javax.print.attribute.standard.MediaSize.Other;

class MyThread extends Thread{
	int i=0;
	public void run(){
		while(true){
			i++;
			System.out.println("This is thread "+getName()+", the current number : "+i);
			if(i==10){
				try{suspendThread();}
				catch(Exception e){}
			}
			try {Thread.sleep(1000);}
			catch (Exception e) {}
		}
	}
		public synchronized void suspendThread() throws InterruptedException{
			wait();
		}
		public synchronized void reviveThread(){
			notifyAll();
		}
}
class YourThread extends Thread{
	int m=0;
	MyThread otherThread;
	YourThread(MyThread a){
		otherThread=a;
	}
	public void run(){
		 while(true){
	            m++;
	            System.out.println("I am the root thread ,the current number is :  "+m);
	            if(m==10){
	                System.out.println("\n !!!!!!!!!!!!!!!!!!!!!!!! \n Let "+otherThread.getName()+" go on with it's work \n!!!!!!!!!!!!!!!!!!!!!!!! \n ");
	                try{otherThread.reviveThread();
	                }
	                catch(Exception e){}
	                return;
	            }
	            try {Thread.sleep(1000);}
	            catch(Exception e){}
	        }
	}
}
public class Example9_16 {
public static void main(String[] args) {
	MyThread thread1=new MyThread();
	thread1.setName("Thread_1");
	thread1.start();
	YourThread thread2=new YourThread(thread1);
	thread2.setName("Thread_2");
	thread2.start();
}
}