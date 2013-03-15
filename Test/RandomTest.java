import java.util.*;


public class RandomTest{
    final static int THREADS = 10;
    public static void main(String[] args){
	Random rand = new Random(47);
	List<Integer> list = new ArrayList<Integer>();
	for(int i = 0 ; i < THREADS ; i ++){
	    list.add(i);
	}
	Collections.shuffle(list);
	for(Integer i : list){
	    System.out.println(i);
	}
	//System.out.println(rand.nextInt());
    }
}