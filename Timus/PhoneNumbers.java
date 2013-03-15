import java.io.*;

public class PhoneNumbers{
    static final int MAX_INT = 100;
    public static void main(String[] args) throws IOException{
	Map map = new Map();
	System.out.println(map.Map(0,"o"));
	final StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1")));
	int tNumber;
	int[] data = new int[MAX_INT];
	while(in.nextToken() != StreamTokenizer.TT_EOF){
	    if((int)in.nval == -1)
		break;
	    if(in.ttype == StreamTokenizer.TT_NUMBER)
		tNumber = (int)in.nval;
	}
	//while(in.nextToken != -1){
	    
	

    }

}
    class Map{
    int number ;
    String str;
    boolean Map(int n, String s){
	switch(n){
	case 0 :
	    if(s.equals("o")||s.equals("q")||s.equals("z"))
		return true;
	case 1 :
	    if(s.equals("i")||s.equals("j"));
		return true;
	case 2 :
	    if(s.equals("a")||s.equals("b")||s.equals("c"))
		return true;
	case 3 :
	    if(s.equals("d")||s.equals("e")||s.equals("f"))
		return true;
	case 4 :
	    if(s.equals("g")||s.equals("h"))
		return true;
	case 5 :
	    if(s.equals("k")||s.equals("l"))
		return true;
	case 6 :
	    if(s.equals("m")||s.equals("n"))
		return true;
	case 7 :
	    if(s.equals("p")||s.equals("r")||s.equals("s"))
		return true;
	case 8 :
	    if(s.equals("t")||s.equals("u")||s.equals("v"))
		return true;
	case 9 :
	    if(s.equals("w")||s.equals("x")||s.equals("y"))
		return true;
	default : return false;
	}
    }


}