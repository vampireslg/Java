import java.util.concurrent.*;
import java.util.*;

class Horse implements Runnable{
    public static int counter = 0;
    private int strides = 0;
    private final int id = counter ++ ;
    private static Random rand = new Random(47);
    private static CyclicBarrier barrier;
    public Horse(CyclicBarrier b){barrier = b;}
    public synchronized int getStrides(){return strides ;}
    public void run(){
	try{
	    while(!Thread.interrupted()){
		synchronized(this){
		    strides += rand.nextInt(3);
		}
		barrier.await();
	    }
	}catch (InterruptedException e){
	    //
	}catch (BrokenBarrierException e){
	    throw new RuntimeException(e);
	}
    }
    public String toString(){return "Horse " + id + " ";}
    public String tracks(){
	StringBuilder s = new StringBuilder();
	for(int i = 0 ; i < getStrides(); i++){
	    s.append("*");
	}
	s.append(id);
	return s.toString();
    }
}

public class HorseRace{
    static final int FINISH_LINE = 75;
    private List<Horse> horses = new ArrayList<Horse>();
    private ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;
    public HorseRace(int nHorse, final int pause){
	barrier = new CyclicBarrier(nHorse, new Runnable(){
		public void run(){
		    StringBuilder s = new StringBuilder();
		    for (int i = 0 ; i < FINISH_LINE; i++){
			s.append("=");
		    }
		    System.out.println(s);
		    for(Horse horse : horses)
			System.out.println(horse.tracks());
		    for(Horse horse : horses)
			if(horse.getStrides() >= FINISH_LINE){
			    System.out.println(horse + "won !");
			    exec.shutdownNow();
			    return;
			}
		    try{
			TimeUnit.MILLISECONDS.sleep(pause);
		    }catch(InterruptedException e){
			System.out.println("barrier-action sleep interrupted");
		    }
		}
	    });
	for(int i = 0 ; i < nHorse; i ++){
	    Horse horse = new Horse(barrier);
	    horses.add(horse);
	    exec.execute(horse);
	}
    }

    public static void main(String[] args){
	int nHorse = 10;
	int pause =300;
	if(args.length > 0){
	    int n = new Integer(args[0]);
	    nHorse = n > 0 ? n : nHorse;
	}
	if(args.length > 1){
	    int p = new Integer(args[1]);
	    pause = p > -1 ? p : pause;
	}
	new HorseRace(nHorse, pause);
    }
}
	    