package sortAlgo;
import java.util.*;

public class SortWithPatialOrder {

	public static void main(String[] args) {
	}
}

class Sort{
	public static  void sortAndPrint(List<Integer> list, LinkedList<Integer> outList,
			int listLen,List<Node> nodeList ){
		if(outList.size() == listLen &&
				patialOrderTest(nodeList, outList)){
			printList(outList);
		}
		
		for(Integer in : list){
			List<Integer> temList = new LinkedList<Integer>(list); 
			temList.remove(list.indexOf(in));
			sortAndPrint(temList, conCat(outList, in), listLen, nodeList );
		}
	}

	private static LinkedList<Integer> conCat(LinkedList<Integer> list, Integer in ){
		LinkedList<Integer> newList = new LinkedList<Integer>(list);
		newList.add(in);
		return newList ;
	}

	private static boolean patialOrderTest(List<Node> list , LinkedList<Integer> outList){
		/**
		 *  Test whether the sequence satisfy the PO, that is if  1 pre 2 ,then 2 ,1 ... will never occurs  .
		 *  To do that ,we record the parent and children nodes for each node 
		 *  Say : 1 has children nodes 2 ,3 ; || 2 has parent node 1; ||  3 has parents nodes 1 ,4 ; || 
		 *  4 has children nodes 3 
		 *  We get a seq 1 ,2 ,3, 4 ; to verify whether it's legal , we eliminate  1 of it's children nodes 2 ,3 
		 *  and parents node 1 of 2, 3 at the same time .
		 *  If all the preLists , aka  parent nodes  , of nodes under test are NULL , we call legal of that sequence  
		 * 	 comprised by these nodes  .
		 *  Sequence referred above is not legal as Node 3 's preList is not empty ( 4 remains left ) . 
		 * 
		 */
		
		LinkedList<Node> newList = new LinkedList<Node>();
		for(Node node : list)
			newList.add((Node)node.clone());

		for(int in : outList){
			if(  newList.get(in - 1).getPreList().size() >  0  ){
				//System.out.println("Now the node is : " + in + " its parent nodes are : " );
				//System.out.println(" I am " + in + ", as I could not be 1 or 4  !!!");
				return false ;
			} 	
			while(newList.get(in - 1).getSucList().size() > 0 ){
				//System.out.println(" I am " + in + " , I could only be 1 or 4 .... ");
				int item = ((LinkedList<Integer>) newList.get(in - 1 ).getSucList()).removeFirst();
				int index = newList.get(item - 1 ).getPreList().indexOf(in); // location of child node of "Node in"
				newList.get(item - 1).getPreList().remove(index);
				//System.out.println("I am Node " + in + " Removed by child node :  " + item );
			}
		}
		return  true ;
	}

	public static void printList(List<Integer> list) {// print list .
		// TODO Auto-generated method stub
		Iterator<Integer> iter=list.iterator();
		while(iter.hasNext())
			System.out.print(iter.next()+ " ");
		System.out.println();
	}
}

class Node implements Cloneable{
	public int val;
	List<Integer> preList; 
	List<Integer> sucList; 
	Node(Integer in, List<Integer> preList , List<Integer> sucList){
		val = in ;
		this.preList = preList;
		this.sucList = sucList ;
	}
	
	public Object clone(){
		Node node = null;
		try{
			node = (Node) super.clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		node.preList = new LinkedList<Integer>();
		node.sucList = new LinkedList<Integer>();
		for(int i : preList)
			node.preList.add(i);
		for(int i : sucList)
			node.sucList.add(i);
		return node;
	}
	public int getVal(){
		return val; 
	}
	public List<Integer> getPreList(){
		return preList ;
	}

	public List<Integer> getSucList(){
		return sucList ;
	}
}




