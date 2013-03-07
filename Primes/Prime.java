//package Primes;
import java.math.*;
import java.util.Vector;
import java.io.*;
import static Package.print.Print.*;

public class Prime{
    public static void main(String[] args){
	primes thr=new primes();
	thr.primes(2,1000000000000000l); // 10 ^ 15
	try{
	    RandomAccessFile out=new RandomAccessFile("myprimes.txt", "rw");
	    for(int i = 2 ; i < 1000000; i++){
		if(thr.isPrimeL(i))
		    out.writeBytes(Integer.toString(i)+"\n");
	    }
	    out.close();
	}catch(IOException e){}
    }
}

// Rule out primes
class primes{

    boolean isPrimeL(long number){
	long sqrtNum=(long)(1+Math.sqrt((double)number));
	for(long i=2; i<=sqrtNum; i=(i%2==1)?(i+2):(i+1)){
	    if (number==2||number==3)
		return true;
	    else if (!((number&1)==1))
		return false ;
	    else if (number%i==0)
		return false;
	}
	return true;
    }

    private long startTime,endTime;
    long primes(long minNum,long  maxNum){
	long primeNum=0;
	startTime=System.currentTimeMillis();
	for(long i=minNum; i<maxNum; i++){
	    if(isPrimeL(i)){
		primeNum++;
	    }
	}
	endTime=System.currentTimeMillis();
	print("Time consuming "+(endTime-startTime)/1000 +"s for primes between "+minNum+" and " +maxNum);
       	//System.out.println("Number of Primes between "+minNum+" and "+maxNum+" \n" + primeSet.lastIndexOf(primeSet.lastElement()));
	//primeNum = primeSet.lastIndexOf(primeSet.lastElement());
	//return (primeSet.lastIndexOf(primeSet.lastElement()));
	print(primeNum);//+50847534);
	return primeNum;
    }
}
    