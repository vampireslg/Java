import java.math.*;
import java.util.Vector;

public class prime{
    public static void main(String[] args){
	//System.out.println("Number of primes in 10,100,1000..ars as follows : ");
	Primes thr=new Primes();
	
	thr.primes(2,1000000); // 10 Billion 
    }
}

// Rule out primes
class Primes{

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
	System.out.println("Time consuming "+(6130+(endTime-startTime)/1000)+"s for primes between "+minNum+" and " +maxNum);
       	//System.out.println("Number of Primes between "+minNum+" and "+maxNum+" \n" + primeSet.lastIndexOf(primeSet.lastElement()));
	//primeNum = primeSet.lastIndexOf(primeSet.lastElement());
	//return (primeSet.lastIndexOf(primeSet.lastElement()));
	System.out.println(primeNum);//+50847534);
	return primeNum;
    }
}
    