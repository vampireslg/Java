import circularArray.*;

public class Operations {
    final static int SIZE = 17;
	public static void main(String[] args) {
	    WorkStealing ws ; 
	    UnboundedDEQueue ud = new UnboundedDEQueue(0);
	    
	    for (int i = 0; i< SIZE ; i++){
		ud.pushBottom(i * 1000 + 1);
		System.out.println(ud.getBottom());
	    }
	    System.out.println(">>>>");
	    ws = new WorkStealing(ud);
	    ws.start();
	}
		
	
    static class WorkStealing extends Thread{
	UnboundedDEQueue ud ;
	WorkStealing(UnboundedDEQueue ud){
	    this.ud = ud;			
	}
	public void run(){
	    int bottomNum = ud.getBottom();
	    while(ud.getBottom()!=-1){
		System.out.println(ud.popBottom());
	    }
	}
		
    }
    
}