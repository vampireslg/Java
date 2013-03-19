package sortAlgo;

import java.util.LinkedList;

public  class NodeInitiationThoughTuple{
	int nodeNum ;
	/**public NodeInitiation() {
	}
	*/
	
	public NodeInitiationThoughTuple(Tuple<Integer, Integer>[] tuple, int nodeNum, LinkedList<Node> nodeList){
		this.nodeNum = nodeNum ;
		for( ; this.nodeNum -- > 0 ; ) {
			nodeList.add(new Node(this.nodeNum, new LinkedList<Integer>(), new LinkedList<Integer>()));
		}
		
		for (Tuple<Integer, Integer> tup :  tuple){
			nodeList.get(tup.getL() - 1).getSucList().add(tup.getR());
			nodeList.get(tup.getR() - 1).getPreList().add(tup.getL());
		}
		//return nodeList; 
	}
	
}
