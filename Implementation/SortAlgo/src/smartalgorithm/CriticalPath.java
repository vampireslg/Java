package smartalgorithm;
import java.util.*;

import sortAlgo.*;

public class CriticalPath {
	/**
	 * Find the longest path in DAG .
	 * Return result in form of List .
	 */
	public static void main(String[] args) throws Exception{
	    CriticalPath cp = new CriticalPath();
		int[][] initArry = {{1,8},{8,3},{3,10},{4,5},{5,6},{6,7},{5,7},{7,10},{2,4}};
		LinkedList<Integer> list = new LinkedList<>();
		list = cp.searchCriticalPath(initArry); 
		for(int i : list){
			System.out.println("---------   " + i);
		}
	}
	
	LinkedList<Integer> searchCriticalPath(int[][] initArr){
		// Record heads from which longest path could be found
		LinkedList<Integer> headList = new LinkedList<>();
		LinkedList<Integer> resList = new LinkedList<>();
		int len, resLen = 0 ;
		Tuple<Integer, LinkedList<Integer>> res =	new Tuple<>(resLen,resList);
		for(int[] line : initArr)
			if( ! headList.contains(line[0]))
				headList.add(line[0]);
		for(int[] line : initArr){
			headList.removeFirstOccurrence(line[1]);
		}
		
		len = resLen ;
		for (int i : headList){
			res = getLongestPath( i , initArr , len);
			int newLen = res.getL() ;
			if( newLen > resLen){
				resLen = newLen ;
				resList = res.getR();
			}
		}
		//Reverse resList ;
		headList.clear();
		while(resList.size() > 0)
			headList.add(resList.removeLast());
		return headList; 
	}
	
	 Tuple<Integer, LinkedList<Integer>> getLongestPath(int head, int[][] arr , int len ){
		//Find longest path from i ;
		LinkedList<Integer> list = new LinkedList<>();
		LinkedList<Integer> sucList = new LinkedList<>();
		Tuple<Integer, LinkedList<Integer>> res = new Tuple<>(len, list);
						
		for(int[] line : arr)
			if( line[0] == head)
				sucList.add(line[1]);
		
		int oldLen = len ;
		for (int suc : sucList){
			res = getLongestPath(suc , arr, oldLen); 
			int newLen = res.getL()  + 1; 
			if (newLen > len){
				len = newLen; 
				list = res.getR();
			}
		}
		
		list.add(head);
		/**
		for(int item : list)
				System.out.println("---------head is -----" + head+ "------------item-------  " + item);
		System.out.println("\n");
		*/
		res = new Tuple <>(len , list );
		
		return res ; 
	}
}
