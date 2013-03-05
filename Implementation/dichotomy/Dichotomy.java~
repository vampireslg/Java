package dichotomy;
import java.io.*;

public class Dichotomy{
    static int loc = 0;
    public static int dic(int a[], int xFactor, int left, int right){
	int flag = (a[0] < a[1]) ? 1:0;
	if (left > right || ((left == right) && !(a[left] == xFactor))) return loc;
	loc = (left + right) / 2;
	if(flag == 1){
	    if (xFactor == a[loc])
		return loc;
	    else if (xFactor < a[loc])
		return dic(a, xFactor, left , loc - 1);
	    else
		return dic(a, xFactor, loc+1 , right);
	}else{
	    if (xFactor == a[loc])
		return loc;
	    else if (xFactor < a[loc])
		return dic(a, xFactor, loc + 1 , right );
	    else
		return dic(a, xFactor, left , loc - 1 );
	}
    }
}