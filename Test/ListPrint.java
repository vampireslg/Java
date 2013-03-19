import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ListPrint {
    /**
       tarlist ..
    */
    public void printAll(ArrayList<Object> candidate, Object out,int length, int outlen){
	if(outlen == length){
	    print(out);
	    //System.out.println(" ********************* ");
	}
	
	for (int i = 0; i < candidate.size(); i++) {

	    ArrayList<Object> tmList = new ArrayList<Object>(candidate);
	    printAll(tmList, out + " " + tmList.remove(i), length ,outlen + 1);
	    
	}
    }

    public void print(Object str){
	System.out.println(str + " ");
    }
     
    public static void main(Object[] args) {
	ArrayList<Object> list=new ArrayList<Object>();
	list.add("1");list.add("2");list.add("3");
	list.add("4");

	ListPrint lp=new ListPrint();
	lp.printAll(list, "", list.size(), 0);
    }
}
