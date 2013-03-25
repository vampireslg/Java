package smartalgorithm;
import java.util.*;
import sortAlgo.* ;

public class Versus {
	public  static void main(String[] args) {
		int[] threadArr = { 3};
		int[] methodArr = {5 };
		int nodeNum = 0 ;
		List<Integer> initList = new LinkedList<Integer>();
		List<Integer> outList = new LinkedList<Integer>();
		
		for(int th : threadArr ){
			for(int me : methodArr){
				// -----arr ------ nodeNum--- ARE SHARED
				Tuple<int[][], Integer> methodPro = MethodsProducer.
						methodsProduce( th , me);
				int[][] arr= methodPro.getL();
				
				nodeNum =  th * me; //th * me ;
				// FilterSort 
				FilterSort fs = new FilterSort();
				long timeS = System.currentTimeMillis(); 
				fs.filterPreProcess(arr ,nodeNum);
				long timeE = System.currentTimeMillis(); 
				System.out.println("-----FILTER Sort With Threads * Methods = " +  th + " * " + me + 
						"  Time Consumed : "+ (timeE - timeS) + " Millis -------.");

				
				//BruteSort
				/**
				for (int i = 0 ;  i < nodeNum ;  i ++ )   //initList initiation .
					initList.add(i + 1);
				LinkedList<Node> nodeList = new LinkedList<Node>();
				timeS = System.currentTimeMillis();
				nodeList = 
				NodeListInit.nodeInitiation_Array(arr, nodeNum);
				Sort.sortAndPrint(initList, (LinkedList<Integer>) outList, initList.size(), nodeList);
				timeE = System.currentTimeMillis();
				System.out.println("-----BRUTE  Sort With Threads * Methods = " +  th + " * " + me + 
						"  Time Consumed : "+ (timeE - timeS) + " Millis ------.\n\n");

				initList.clear();
				outList.clear();
				nodeList.clear();
				*/
				
			}
		}
	}
}
