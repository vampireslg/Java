import java.io.*;
import java.util.*;

public class P2201{
    public static void main(String[] args){
	Scanner lines = new Scanner(System.in);
	int nu = lines.nextInt();

	while(nu > 0){
	    Scanner in = new Scanner(System.in);
	    String[] str = in.next().split(",");
	    int lnu = Integer.parseInt(str[0]);
	    int rnu = Integer.parseInt(str[1]);
	    if (lnu < rnu )
		System.out.println("NO BRAINS");
	    else
		System.out.println("MMM BRAINS");
	    
	    nu--;
	}
    }
}
