package sortAlgo;

import java.util.LinkedList;
import java.util.List;

public class Node implements Cloneable{
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