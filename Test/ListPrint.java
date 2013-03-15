import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ListPrint {
    /**
       tarlist ..
    */
    public void printAll(ArrayList<String> candidate, String out,int length, int outlen){
	if(outlen == length){
	    print(out);
	    //System.out.println(" ********************* ");
	}
	
	for (int i = 0; i < candidate.size(); i++) {

	    ArrayList<String> tmList = new ArrayList<String>(candidate);
	    printAll(tmList, out + " " + tmList.remove(i), length ,outlen + 1);
	    
	}
    }

    public void print(String str){
	System.out.println(str + " ");
    }
     
    public static void main(String[] args) {
	ArrayList<String> list=new ArrayList<String>();
	list.add("1");list.add("2");list.add("3");
	list.add("4");

	ListPrint lp=new ListPrint();
	lp.printAll(list, "", list.size(), 0);
    }
}
