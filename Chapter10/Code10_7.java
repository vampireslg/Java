import java.io.*;
public class Code10_7{
    public static void main(String[] args){
	File infile=new File("Student.txt");
	String contents[]={"Abracadabra", "Bracadabra", "Cadabra"};
	try{
	    FileWriter intone=new FileWriter(infile);
	    BufferedWriter inttwo=new BufferedWriter(intone);
	    for (int i=0; i<contents.length; i++){
		inttwo.write(contents[i]);
		inttwo.newLine();
	    }
	    inttwo.close();
	    intone.close();
	    FileReader outone=new FileReader (infile);
	    BufferedReader outtwo=new BufferedReader(outone);
	    String s;
	    while((s=outtwo.readLine())!=null){
		System.out.println(s+"");
	    }
	    outone.close();
	    outtwo.close();
	}catch(IOException e){
	}
    }
}
