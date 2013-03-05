import java.io.*;
import static dichotomy.Dichotomy.*;
import java.util.ArrayList;

class DichotomyQues{
    
    public static void main(String[] args){
	int arr[] = new int[2013];
	try{
	    RandomAccessFile in = new RandomAccessFile("repeatPrimes", "rw");
	    //RandomAccessFile in = new RandomAccessFile("1000primes.txt", "rw");
	    long length = in.length();
	    String str = null;
	    int i = 0;
	    while((str = in.readLine()) != null){
		arr[i] = Integer.parseInt(str.trim());
		i++;
	    }
	    in.close();
	}catch(IOException e){}
	for (int i = 0 ; i < arr.length; i++){
	    print(search(arr, arr[i]));
	}
    }
	
    public static void print(Object obj){
	System.out.println(obj);
    }
}
