package sortAlgo;

import java.util.*;

public class CheckCheck {
	public static void main(String[] args) {
		//LinkedList<Node> nodeList = new LinkedList<Node>();
		long startTime = System.currentTimeMillis();
		int nodeNum = 4;
		/**
		Tuple<Integer, Integer>[] tuple = new Tuple[3]; 
		tuple[0] = new Tuple<>(1, 2);
		tuple[1] = new Tuple<>(1, 3);
		tuple[2] = new Tuple<>(4, 3);
		NodeInitiationThoughTuple ni = new NodeInitiationThoughTuple(tuple, nodeNum, nodeList);
		//for(Node node : nodeList)
			//System.out.println(node.getVal());
		*/
				
		/**
		int[][] tupleArr = {{1,2},{2,3},{4,3}};
		LinkedList<Node> newNodeList = new LinkedList<Node>() ;
		NodeInitThoughTwoDimArray.nodeInitiation_Array(tupleArr, nodeNum ,newNodeList );
		*/
		
		List<Integer> initList = new LinkedList<Integer>();
		List<Integer> outList = new LinkedList<Integer>();
		
		Tuple<int[][], Integer> methodPro = MethodsProducer.methodsProduce();
		int[][] tupleArr = methodPro.getL();
		nodeNum = methodPro.getR();
		for (int i = 0 ;  i < nodeNum ;  i ++ )   /**initList initiation .*/
			initList.add(i + 1);
		LinkedList<Node> newNodeList = new LinkedList<Node>() ;
		NodeInitThoughTwoDimArray.nodeInitiation_Array(tupleArr, nodeNum ,newNodeList );
		
		Sort.sortAndPrint(initList, (LinkedList<Integer>) outList, initList.size(), newNodeList);
		
		long endTime = System.currentTimeMillis();
		System.out.println("Time------Consumed : "+ (endTime - startTime) + " Millis .");
	}

}