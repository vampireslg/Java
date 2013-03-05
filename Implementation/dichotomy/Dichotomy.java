package dichotomy;
import java.io.*;
import java.util.ArrayList;

public class Dichotomy{
    public static int search(int arr[], int key){
	int start = 0;
	int end = arr.length - 1;
	while(start <= end){
	    int middle = (start + end) /2 ;
	    if(key < arr[middle]){
		end = middle -1;
	    }else if(key > arr[middle]){
		start = middle + 1;
	    }
	    else{
		while(start < middle){
		    int m = (start + middle) / 2;
		    if(key <= arr[m])
			middle = m-1;
		    else if(key > arr[m])
			start = m + 1;
		    else
			return (1+m);
		}
		return (1+middle);
	    }
	}
	return -1;
    }

    public static void print(Object obj){
	System.out.println(obj);
    }
    
}
		
		
    