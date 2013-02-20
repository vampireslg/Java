import java.math.*;
import java.util.Vector;

public class prime{
    public static void main(String[] args){
	System.out.println("Number of primes in 10,100,1000..ars as follows : ");
	Primes thr=new Primes();
	//long primes_10=thr.primes(1,10);
	//long primes_100=thr.primes(11,100)+primes_10;
	//System.out.println(primes_100);
	/*	thr.primes(1,10);
	thr.primes(1,100);
	thr.primes(1,1000);
	thr.primes(1,10000);
	thr.primes(1,100000);
	//One Million
	thr.primes(1,1000000);
	//thr.primes(1,10000000);
	//thr.primes(1,100000000);
	// One Billion
	thr.primes(100000000,1000000000); 
	//thr.primes(1,10000000000);
	*/
	thr.primes(2,1000000000);
    }
}

// Rule out primes
class Primes{

    boolean isPrimeL(long number){
	long sqrtNum=(long)(Math.sqrt((double)number));
	for(long i=2; i<=sqrtNum; i++){
	    if (number%i==0)
		return false ;
	}
	return true;
    }
    //primes between minNum, maxNum
    //Timing for computation
    private long startTime,endTime;
    long primes(long minNum,long  maxNum){
	//Vector primeSet=new Vector();
	long primeNum=0;
	startTime=System.currentTimeMillis();
	for(long i=minNum; i<maxNum; i++){
	    if(isPrimeL(i)){
		primeNum++;
		//primeSet.add(i);
	    }
	}
	endTime=System.currentTimeMillis();
	System.out.println("Time consuming "+(endTime-startTime)/1000+"s for primes between "+minNum+" and " +maxNum);
       	//System.out.println("Number of Primes between "+minNum+" and "+maxNum+" \n" + primeSet.lastIndexOf(primeSet.lastElement()));
	//primeNum = primeSet.lastIndexOf(primeSet.lastElement());
	//return (primeSet.lastIndexOf(primeSet.lastElement()));
	System.out.println(primeNum);
	return primeNum;
    }
}
    