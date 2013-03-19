import circularArray.*;

public class Resize{
    final static int SIZE = 4;
    public static void main(String[] args){	
	CirArray ca = new CirArray(SIZE);
	for(int i = 0; i< 1 << SIZE; i++){
	    ca.put(i, i*10+1);
	}
	 ca.resize(1 << SIZE , 0);
	for (int i = 0 ; i < 1 <<SIZE ;i++){
	    System.out.println(ca.get(i));
	}
    }
}