package sortAlgo;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;

public class NodeListInit {
	/**
	 * Return DAG in 	form of LinkedList<Node> list ; 
	 * @param tupleArr
	 * @param nodeNum
	 * @param nodeList
	 * @return
	 */
	//public static LinkedList<Node> nodeInitiation_Array (int[][] tupleArr,
	public static LinkedList<Node> nodeInitiation_Array (int[][] tupleArr,
			int nodeNum){
		int num = nodeNum ;
		LinkedList<Node> nodeList = new LinkedList<>();
		for( ; nodeNum -- > 0 ; ) {
			nodeList.add(new Node(num - nodeNum, 
					new LinkedList<Integer>(), new LinkedList<Integer>()));
		}

		LinkedList<Integer> headsList = new LinkedList<>();
		for (int[] item : tupleArr){
			if( headsList.contains(item[0]))
				continue ;
			else 
				headsList.add(item[0]);
		}

		for(int heads : headsList){
			for(int[] item : tupleArr){
				if (pointed(heads, item[1], tupleArr)){
					if(! nodeList.get(heads - 1).getSucList().contains(item[1]))
						nodeList.get(heads - 1).getSucList().add(item[1]);
					if (!nodeList.get(item[1] - 1).getPreList().contains(heads) )
						nodeList.get(item[1] - 1).getPreList().add(heads);
				}
			}
		}
		return nodeList; 
	}	

	static  boolean pointed(int par, int chi, int[][] arr){
		 // Note that par and chi are all in arr  ;
		boolean res = false ;
		for (int[] item : arr){
			if(item[0] == par && item[1] == chi)
				res = true ;
			else if(item[0] == par && item[1] != chi)
				res = res || pointed(item[1], chi, arr);
		}
		return res; 
	}

	public static void copyList(List<Integer> List,
			List<Integer> List2) {
		// Need filter repeat items . 
		Iterator<Integer> iter = List.iterator();
		while(iter.hasNext()){
			int item = iter.next();
			if (List2.contains(item))
				continue;
			else {
				List2.add(item);
			}
		}
	}

}
