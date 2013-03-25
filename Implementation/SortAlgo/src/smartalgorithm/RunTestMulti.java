package smartalgorithm;

import java.util.LinkedList;

import javax.naming.directory.SearchControls;

import org.omg.CORBA.portable.RemarshalException;

import sortAlgo.MethodsProducer;
import sortAlgo.Tuple;

public class RunTestMulti {
	public static void main(String[] args) throws InterruptedException {

		int[][] initArr = {{1,2},{2,3},{3,4},{5,6},{6,7},{7,8}};
		//int[][] initArr = {{1,2},{2,3},{4,3},{5,2}};
		HashSort hs = new HashSort(2, 6);
		System.out.println("-----------------------Test------------------------");
		//hs.printResult(newArr);
		
		int[] threadArr = {3,4,5};
		int[] methodArr = {4,5,6};
		int nodeNum = 0;
		FilterSort fs = new FilterSort();
		for(int th : threadArr ){
			for(int me : methodArr){
				// -----arr ------ nodeNum--- ARE SHARED
				Tuple<int[][], Integer> methodPro = MethodsProducer.
						methodsProduce( th , me);
				//ReadData rd = new ReadData();
				int[][] arr= methodPro.getL();
						//methodPro.getL();
				
				nodeNum =  th * me; //th * me ;
				
				// **************************************************
				
				LinkedList<Integer> headList = new LinkedList<>();
				for(int[] line : arr)
					if( ! headList.contains(line[0]))
						headList.add(line[0]);
				for(int[] line : arr){
					headList.removeFirstOccurrence(line[1]);
				}
				FilterSort fs1 = new FilterSort() ;
				System.out.println("-----Head Items ------");
				fs1.printList(headList);
				System.out.println("---------------------------I am the lovely cutting line ------------------------------");
				
				int co = 0 ; 
				for(int head : headList){
					co ++ ;
				}
				DivideWork dw[] = new DivideWork[co] ;
				co = 0 ;
				long timeS = System.currentTimeMillis() ;
				for(int head : headList){
					dw[co]= new DivideWork(arr, head, nodeNum );
					dw[co].start();
					co ++ ;
				}
				for(int i = 0 ;  i < co ; i++)
					dw[i].join() ;
				
				long timeE = System.currentTimeMillis(); 
				System.out.println("----- Multi Sort With Threads * Methods = " +  th + " * " + me + 
						"  Time Consumed : "+ (timeE - timeS) + " Millis -------.");
			}
		}
		
	}
}
