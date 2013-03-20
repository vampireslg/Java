package smartalgorithm;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import sortAlgo.*;
public class FilterSort {
	public  static void main(String[] args) throws Exception{
	int[] threadArr = {3, 5};
		int[] methodArr = {2, 3, 5};
		int nodeNum = 0 ;
				
		for(int th : threadArr ){
			for(int me : methodArr){
				// -----arr ------ nodeNum--- ARE SHARED
				Tuple<int[][], Integer> methodPro = MethodsProducer.
						methodsProduce( th , me);
				int[][] arr= methodPro.getL();
				
				nodeNum =  th * me; //th * me ;
				// FilterSort 
				long timeS = System.currentTimeMillis(); 
				FilterSort.filterPreProcess(arr ,nodeNum);
				long timeE = System.currentTimeMillis(); 
				System.out.println("-----FILTER Sort With Threads * Methods = " +  th + " * " + me + 
						"  Time Consumed : "+ (timeE - timeS) + " Millis -------.");
			}
		}
	} //Main
	
	/**
	 * Filter out those sequences that would never occur .
	 * Input int[][] array , output ALL possible sequence .
	 */
	public static void filterPreProcess(int[][] arr, int nodeNum){
		LinkedList<Integer> criticalList = new LinkedList<>();
		criticalList = CriticalPath.searchCriticalPath(arr);
		int restArr[] = new int[nodeNum - criticalList.size()];
		int index = 0 ;
		for(int i = 1 ; i <= nodeNum ; i ++)
			if( ! criticalList.contains(i)){
				restArr[index ++ ] = i;
				//System.out.println("-----------rest--nodes---- " + i);
			}
		LinkedList<Node> nodeList = 
		NodeListInit.nodeInitiation_Array(arr, nodeNum );
		filterAndPrint(criticalList, nodeList, restArr, nodeNum ); 
	}

	public static void filterAndPrint(LinkedList<Integer> criticalList, LinkedList<Node> nodeList, 
			int[] restArr, int nodeNum){
		/*Let's ProProcess  to Print Them All */
		if (criticalList.size() == nodeNum ){
			//printList(criticalList);
		}
		
		if(restArr.length > 0){
			int insertItem = restArr[0] ;
			int counter = 0 ;
			
			int[] eRestArr = new int[restArr.length - 1]; 
			for(int i = 1 ; i < restArr.length ;i ++ )
				eRestArr[i - 1] = restArr[i];
			
			/* Locate the location of items being last one contains insertItem as its SUC 
			 * and first one as its PRE
			 * */
			int lpl = lastPreLoc(insertItem, criticalList, nodeList ); 
			int fsl = firstSucLoc(insertItem, criticalList, nodeList ); 

			counter = lpl ;
			for(;counter < fsl; ){
				LinkedList<Integer> oldCriList = new LinkedList<>();
				NodeListInit.copyList(criticalList, oldCriList);
				oldCriList.add(counter ,insertItem) ;
				filterAndPrint(oldCriList, nodeList, eRestArr, nodeNum) ;
				counter ++;
			}
		
		}
	}
	
	 static int lastPreLoc(int item, LinkedList<Integer> list , LinkedList<Node> nodeList ){
		 /* Return 0 means no item in criticalPath as its PRE , loc is the last location([1 .. size()]) of node as its PRE */
		 int loc = 0 ,aux = 0 ;
		 for(int citem : list ){
			 aux ++;
			 if(nodeList.get(citem - 1).getSucList().contains(item))
				 loc = aux ;
		 }
		 return loc ;
	 }
	 
	  static int firstSucLoc(int item, LinkedList<Integer> list , LinkedList<Node> nodeList ){
		  /* Return list.size()means no item in criticalPath as its SUC , loc is the first location ([0..size - 1])of node as its SUC */
		 int loc = list.size() + 1 ,aux = 0 ;
		 for(int citem : list ){
			 aux ++ ;
			 if(nodeList.get(item - 1).getSucList().contains(citem))
				 return aux ;
		 }
		 return loc ;
	 }
	
	public static void printList(List<Integer> list) {// print list .
		Iterator<Integer> iter=list.iterator();
		while(iter.hasNext())
			System.out.print(iter.next()+ " ");
		System.out.println();
	}
}
