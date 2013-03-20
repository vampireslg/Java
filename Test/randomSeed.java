//import java.Math.*;
import java.util.*;

public class randomSeed{
    public static void main(String[] args){
	Random rand = new Random(47);
	for(int i = 0 ; i < 21 ; i ++){

	    if(i % 2 == 0)
		System.out.println(rand.nextInt(10));
	    else
		System.out.println(rand.nextInt(4));
	}



	
    }
    
}