import java.io.*;
import static Package.print.Print.*;

public class euler_11{
    public static void main(String[] args){
	int set[][]=new int[20][20];
	try{
	    BufferedReader f=new BufferedReader(new FileReader("euler_11.txt"));
	    String[] contents=null;
	    String line=null;
	    int l=0;
	    while((line=f.readLine())!=null){
		contents = line.split(" ");
		for(int i=0; i<contents.length; i++){
		    set[l][i]=Integer.parseInt(contents[i]);
		}
		l++;
	    }
	    f.close();
	    
	    int max=0,product=0;
	    //Get the maxminum number
	    for(int i=0; i<20; i++){
		for(int j=0; j<20; j++){
		    if(j<17&&i<17){
		       	product=max(set[i][j] * set[i][j+1] * set[i][j+2] * set[i][j+3],
					set[i+1][j] * set[i+2][j] * set[i+3][j] * set[i][j],
					set[i][j] * set[i+1][j+1] * set[i+2][j+2] * set[i+3][j+3]);
			if(j>=3){
			    product=Math.max(product,
					     set[i][j] * set[i+1][j-1] * set[i+2][j-2] * set[i+3][j-3]);
			}
		    }
		    else if(j<17&&i>=17)
			product=(set[i][j] * set[i][j+1] * set[i][j+2] * set[i][j+3]);
		    else if(j>=17&&i<17)
			product=(set[i+1][j] * set[i+2][j] * set[i+3][j] * set[i][j]);
		    
		    max=Math.max(product, max);
		}
	    }
	    print("THE MAXIMUM NUMBER IS\n>>> "+max);
	}catch(IOException e){}
    }

    private static int max(int a, int b, int c){
	    int max=a>b?(a>c?a:c):(b>c?b:c);
	    return max;
	}
}