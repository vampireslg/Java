package smartalgorithm;
import java.util.*;

public class HashSort {
	/**
	 * @author gaoang
	 * @category
	 *  Incomplete : unsuitable to sort with repeat items , say [1,2] [1,2] occurs twice in initArray .
	 * 
	 */
	
	final int MAX = 10000 ;
	int nodeNum ,tNum , perm = 0 ;
	HashSort(int t, int n){
		nodeNum = n;
		tNum = t;
	}

	void printResult(int[][] arr ){
		LinkedList<Integer> criticalList = new LinkedList<>();
		CriticalPath cp = new CriticalPath()	;
		criticalList = cp.searchCriticalPath(arr);
		int restArr[] = new int[nodeNum - criticalList.size()];
		int index = 0;
		for(int i = 1 ; i <= nodeNum ; i ++)
			if( ! criticalList.contains(i)){
				restArr[index ++ ] = i;
			}

		HashMap<Integer, Integer> locMap = initLocMap(arr); 
		HashMap<Integer, int[]> nodeMap = initNodeMap(arr);
		filterAndPrint(locMap, nodeMap, 0 , restArr);
		System.out.println("-----Totally--Permuataion ---- " + perm);
	}

	HashMap<Integer, Integer> initLocMap(int[][] initArr){
		//locMap Key : location ; Value : node's value .
		CriticalPath cp = new CriticalPath();
		LinkedList<Integer> criticalL =  cp.searchCriticalPath(initArr);
		HashMap<Integer, Integer> locMap = new HashMap<>();
		int con = 0 ;
		locMap.put(con++, nodeNum);
		for (int item : criticalL){
			locMap.put(con ++ , item);
		}

		for(; con <= nodeNum; ){// Rest location other than critical ones stores 0 ;
			locMap.put(con ++ , 0 );
		}

		return locMap ;
	}

	HashMap<Integer, int[]>  initNodeMap(int[][] initArr){
		//nodeMap stores nodes location_precursor_successor array ,first slot in which stores 
		// location this node in the critical path (initiation value 0 ); 
		//Second slot and the third each stores location of the its last precursor(if none stores 2)
		// and that of its first successor (if none stores 2*threads number + 3)in this array .

		HashMap<Integer, int[]> nodeMap = new HashMap<>();
		int[][] nodeArr = new int[nodeNum + 1][2*tNum + 3];

		for(int i = 0 ; i <= nodeNum; i ++ ){
			int pre = 2 , suc= 2*tNum + 3  ;	//2 means the 3rd slot in array ; store successor from tail to head .
			nodeArr[i][0] = 0 ;						//INIT location is 0 ;
			for(int[] row : initArr){
				if(row[0] == i ){ 						//row[1] is its successor .
					nodeArr[i][-- suc] = row[1];
				}
				else if(row[1] == i ){				//row[0] is its precursor 
					nodeArr[i][ ++ pre ] = row[0];
				}
			}
			nodeArr[i][1] = pre; 
			nodeArr[i][2] = suc ;
			nodeArr[i][0] = MAX ;
		}

		int loc = 1 ;
		CriticalPath cp = new CriticalPath();
		LinkedList<Integer> criticalL =  cp.searchCriticalPath(initArr);
		for(int item : criticalL){ 					// Location of critical nodes is set to 1 .. critical's length  .
			nodeArr[item][0] = loc ++ ; 
		}

		int cr= 0 ;
		for(; cr <= nodeNum; ){	// 
			nodeMap.put(cr, nodeArr[cr]);
			cr ++ ;
		}
		return nodeMap ;
	}


	void filterAndPrint(HashMap<Integer, Integer> locMap, HashMap<Integer, int[]> nodeMap ,
			int index, int[] restArr){ // index indicates the to be inserted element's index in restArr
		if( index == restArr.length) {//Means all the nodes been in the critical path .
			//System.out.print("----Permutaion:-- >>>>> " );
			//System.out.format("%3s    ", ++ perm) ;
			//printMap(locMap);
			++ perm ;
		}

		else{
			int[] locArr = new int[nodeNum + 1];
			int[] nodeArr = new int[nodeNum + 1]; 
			for(int key : locMap.keySet()){ // Store primitive critical nodes order 
				locArr[key] = locMap.get(key); // get(key) returns value
			}
			
			for(int key : nodeMap.keySet()){ //Stores primitive location before recursion
				nodeArr[key] = nodeMap.get(key)[0];
			}
			int insNode , lpre, fsuc , loc2ins ;
			insNode = restArr[index];	//node to be inserted .
			lpre = lastPreLocation(locMap, nodeMap, insNode);
			fsuc = firstSucLocation(locMap, nodeMap, insNode);
			loc2ins = lpre ;
			for( ;  ++ loc2ins <= fsuc ;){
				alterMap(locMap,nodeMap,loc2ins,insNode);
				shiftMap(locMap, loc2ins, insNode); 
				filterAndPrint(locMap, nodeMap, index + 1, restArr); 
				//Reverse back .
				int cr = 0 ;
				for(int n : locArr){
					locMap.remove(cr);
					locMap.put(cr ++ , n);
				}
				cr = 0 ;
				for (int loc : nodeArr){
					nodeMap.get(cr ++ )[0] = loc;
				}
			}
		}
	}

	void alterMap(HashMap<Integer, Integer> hm , HashMap<Integer ,int[] > nMap, int loc , int node){
		//Change the first slot of nMap's values (which are arrays )
		int tem, i = loc , mapLen; 
		mapLen = hm.get(0);
		nMap.get(node)[0] = loc ;
		for(; i  <= mapLen; i ++ ){	
			tem = hm.get(i); 	//The value of node ;
			nMap.get(tem)[0] ++ ;


		}
	}

	void shiftMap(HashMap<Integer, Integer> hm , int loc , int node){
		int temp , mapLen; 
		mapLen = hm.get(0) ;
		for(; mapLen >= loc ;){
			temp = hm.get(mapLen - 1); 
			hm.put(mapLen, temp);	
			mapLen -- ;
		}
		hm.put(loc, node);
	}

	int lastPreLocation(HashMap<Integer, Integer> locMap, HashMap<Integer, int[]> nodeMap, int n){
		int loc , pid , pnode , pnodeloc ; 
		loc = 0 ; pid = nodeMap.get(n)[1]; 
		if( pid == 2) //Means there is no precursor ;
			;
		else{ 
			for(int i = 3 ; i <= pid ; i ++){
				pnode = nodeMap.get(n)[i];
				pnodeloc = nodeMap.get(pnode)[0] ;
				loc = loc > pnodeloc ? loc : pnodeloc ; 
			}
		}
		return loc ;
	}

	int firstSucLocation(HashMap<Integer, Integer> locMap, HashMap<Integer, int[]> nodeMap, int n){
		int loc , sid , snode , snodeloc ; 
		loc = nodeNum ; sid = nodeMap.get(n)[2]; 
		if( sid == loc) //Means there is no successor ;
			;
		else{ 
			for(int i = 2*tNum + 2 ; i >= sid ; i -- ){
				snode = nodeMap.get(n)[i];
				snodeloc = nodeMap.get(snode)[0] ;
				loc = loc < snodeloc ? loc : snodeloc ; 
			}
		}
		for(int i : locMap.keySet())	//Return the smaller one of LOC and critical path length in locMap ;
			if(locMap.get(i) == 0)
				loc = loc < i ? loc : i;
		return loc ;
	}


	void printMap(HashMap<Integer, Integer> hm){
		Iterator<Map.Entry<Integer, Integer>> iter = hm.entrySet().iterator();
		int num = nodeNum ;
		while(iter.hasNext()){	
			Map.Entry<Integer, Integer> et =  (Map.Entry<Integer, Integer>) iter.next() ;
			int node = et.getValue() ;
			if(node == num){
				num += 1; 
			}
			else 
				System.out.print("--" + node);
		}
		System.out.println();
	}

	//EOF -HashSor
}