import java.io.*;
public class Code10_6{
    public static void main(String[] args){
 	char a[]="Tonight 21:39".toCharArray();
	int n=0, m=0;
	try{
	    File f=new File("secret.txt");
	    for(int i=0; i<a.length; i++){
		a[i]=(char)(a[i]^'S');
	    }
	    FileWriter out=new FileWriter(f);
	    out.write(a, 0, a.length);
	    out.close();
	    FileReader in=new FileReader(f);
	    char temp[]=new char[16];
	    System.out.println("SecretCode");
	    while((n=in.read(temp,0,16))!=-1){
		    String s=new String(temp, 0, n);
		    System.out.println(s);
	    }
	    in.close();
	    in=new FileReader(f);
	    System.out.println("RealCode");
	    while((n=in.read(temp,0,16))!=-1){
		for(int i=0; i<n; i++){
		    temp[i]=(char)(temp[i]^'S');
		}
		String s=new String(temp, 0, n);
		System.out.println(s);
	    }
	    System.out.println("\n\n");
	    in.close();
	}catch(IOException e){
	    System.out.println("ERROR : "+e);
	}
    }
}
		