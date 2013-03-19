package sortAlgo;
import java.util.ArrayList;

public class ListPrint {
	public static void main(String[] args) {
		ArrayList<Object> list=new ArrayList<Object>();
		list.add("1");list.add("2");list.add("3");
		list.add("4");
		printall(list, "", list.size(), 0);
		int[] arr = {2,1,4,3};
		for(int i : arr)
			System.out.println(i );
	}

	private static void printall(ArrayList<Object> list, String str,
			int size, int i) {
		// TODO Auto-generated method stub
		Print.printAll(list, str, size, i);
	}
}

class Print{
	public static void printAll(ArrayList<Object> candidate, Object out,int length, int outlen){
		if(outlen == length){
			print(out);
			//System.out.println(" ********************* ");
		}
		for (int i = 0; i < candidate.size(); i++) {
			ArrayList<Object> tmList = new ArrayList<Object>(candidate);
			printAll(tmList, out + " " + tmList.remove(i), length ,outlen + 1);
		}
	}
	
	private static void print(Object out) {
		// TODO Auto-generated method stub
		System.out.println(out);
	}
}
