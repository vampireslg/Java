package sortAlgo;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;

public class NodeInitThoughTwoDimArray {
	
	public static LinkedList<Node> nodeInitiation_Array (int[][] tupleArr, int nodeNum, LinkedList<Node> nodeList){
		int num = nodeNum ;
		for( ; nodeNum -- > 0 ; ) {
			nodeList.add(new Node(num - nodeNum, new LinkedList<Integer>(), new LinkedList<Integer>()));
		}
		
		for (int[] item : tupleArr){
			nodeList.get(item[0] - 1).getSucList().add(item[1]);
			nodeList.get(item[1] - 1).getPreList().add(item[0]);
		}
		
		for(Node node : nodeList){ // Trans the preList of parent to that of it's children 
			Iterator<Integer> iter = node.getSucList().iterator();
			while(iter.hasNext()){
				int next = iter.next();
				//Note that the node ID is x - 1 , not x ;
				if(! nodeList.get(next - 1).getPreList().contains(node.getVal())){
					copyList(node.getPreList(), nodeList.get(next - 1).getPreList());
					copyList(nodeList.get(next - 1).getSucList(), node.getSucList());
				}
			}
		}	// for 
		return nodeList ; 	
	}
	
	private static void copyList(List<Integer> List,
			List<Integer> List2) {
		// Need filter repeat items . 
		Iterator<Integer> iter = List.iterator();
		while(iter.hasNext()){
			int item = iter.next();
			if (List2.contains(item))
				continue;
			else {
				//System.out.println(item);
				List2.add(item);
			}
		}
	}

	
}