public class Example9_19{
	public static void main(String[] args) {
		ThreadJion a=new ThreadJion();
		a.customer.start();
		a.tvMaker.start();	
	}
}

class ThreadJion implements Runnable{
	TV tv;
	Thread customer, tvMaker;
	ThreadJion(){
		customer=new Thread(this);
		tvMaker=new Thread(this);
		customer.setName("Customer ");
		tvMaker.setName("TVMaker ");
		
	}
	public void run(){
		if(Thread.currentThread()==customer){
			System.out.println(customer.getName()+" is waiting "+tvMaker.getName()+"'s producing");
			try{tvMaker.join();
			}
			catch(InterruptedException e){}
			System.out.println(customer.getName() + " buy tv "+tv.name + " at price of "+tv.price);
			
		}
		else if (Thread.currentThread()==tvMaker){
			System.out.println(tvMaker.getName()+" begin producing ");
			try{tvMaker.sleep(2000);}
			catch(InterruptedException e){}
			tv=new TV("Itv",13084);
			System.out.println(tvMaker.getName()+" is available .");
		}
	}
}

class TV{
	float price;
	String name;
	TV(String name, float price){
		this.name=name;
		this.price=price;
	}
}
