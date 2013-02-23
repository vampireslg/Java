import java.io.*;
import java.util.Vector;

public class Miller_Rabin_32{
    public static void main(String[] args){
	/*System.out.println(modular_exponent_32(2,36,37));
	System.out.println(modular_exponent_32(2,18,37));
	System.out.println(modular_exponent_32(2,9,37));
	int d = Integer.numberOfTrailingZeros(64);
	System.out.println(d);
	*/
	long counter = how_many_primes((long)100);
	boolean isPrime= miller_rabin_32(23456789);
	System.out.println("Valar Morghulis ; \nValar Dohaeris : ");
	

	try{
	    RandomAccessFile out=new RandomAccessFile("mrprimes.txt", "rw");
	    FileOutputStream fos=new FileOutputStream("mrprimes.txt");
	    DataOutputStream out_data=new DataOutputStream(fos);
	    out_data.writeBytes(Integer.toString(2)+"\n");
	    for (int i = 3; i < 100; i+=2){
		if (miller_rabin_32(i)){
		    //out.writeBytes(Integer.toString(i)+"\n");
		    out_data.writeBytes(Integer.toString(i)+"\n");
		}
	    }
	    //for (int i=0; i<counter; i++){
		//out.seek(i*4);
		//System.out.println(","+out.readInt());
	    //}
	    out.close();
	}catch(IOException e){}
    }
	

    //Count how many primes below n 
    public static long how_many_primes(long n){
	long prime_counter = 1;
	if (n <= 1) return 0;
	else if (n == 2) return 1;
	else
	    for (long i = 3; i < n; i+=2){
		if (miller_rabin_32(i))
		    prime_counter++;
	    }
	return prime_counter;
    }
    
    public static boolean miller_rabin_32(long n){
	if (n <= 1) return false;
	else if ( n == 2 ) return true;
	else if (miller_rabin_pass_32( 2, n) &&
		 //miller_rabin_pass_32( 3, n) && 
		 //miller_rabin_pass_32( 5, n) &&
		 //miller_rabin_pass_32( 7, n) && 
		 //miller_rabin_pass_32( 11, n) &&
		 //miller_rabin_pass_32( 13, n) &&
		 //miller_rabin_pass_32( 17, n) &&
		 //miller_rabin_pass_32( 19, n) &&
		 //miller_rabin_pass_32( 23, n) && 
	 	 (n <= 7 || miller_rabin_pass_32(7, n)) &&
		 (n <=61 || miller_rabin_pass_32(61, n)))
	    return true;
	else
	    return false;
    }
    
    private static boolean miller_rabin_pass_32(long a, long n){
	long d = n -1;
	// How many zeros d'binary has in the tail
	// E.g. 100100 = 2 ,10000 = 4;
	long s = Long.numberOfTrailingZeros(d);
	long a_to_power = modular_exponent_32(a, d, n);
	if (a_to_power == 1) return true;
	for (long i =  0; i< s-1; i++){
	    if (a_to_power == n-1) return true;
	    a_to_power = modular_exponent_32(a_to_power, 2, n);
	}
	if(a_to_power == n-1) return true;
	return false;
    }

    
    private static long modular_exponent_32(long base, long power, long modulus){
	long result = 1;
	for (long i = 31; i >= 0; i--){
	    result = (result * result) % modulus;
	    if ((power & (1 << i) ) != 0){
		result = (result*base) % modulus;
	    }
	}
	return (long) result;
    }
}