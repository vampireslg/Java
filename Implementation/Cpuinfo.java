import java.io.*;

class Cpuinfor{
    public static void main(String[] args){
	final long BOUND = 100000000000000l;
	long start = System.currentTimeMillis();
	long in = 0 ;
	for (long i = 0 ; i < BOUND; i++){
	    in = in + i;
	}
	long end = System.currentTimeMillis();
	long tc = (end - start) ;
	print("CpuComputationSpeed >> \n" + BOUND*1000/tc + " Times Per Second .");

    }
    public static void print(Object obj){
	System.out.println(obj);
    }
}