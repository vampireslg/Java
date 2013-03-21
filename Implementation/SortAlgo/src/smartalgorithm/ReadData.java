package smartalgorithm;
import java.io.*;
/**
 * Read from file **.dat to generate An arr for FilterSort.java's input ; 
 * @author gaoang
 *  Date : Mar_20 
 */
public class ReadData {
	int[][] arr ;
	public int[][] arrProduce(String f){
		try{
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String s = null; 
			int row = Integer.parseInt(br.readLine());
			// The first line reveal how many Tuple we have . 
			arr = new int[row][2];
			row = 0 ;
			while((s = br.readLine() ) != null){
				String[] str = s.trim().split("[ ,;]+");
				int odd = 1 ;
				for(String ss : str)
					if( odd == 1){
						arr[row][0] = Integer.parseInt(ss) ;
						odd --;
					}
					else{
						arr[row][1] = Integer.parseInt(ss);
						odd ++;
						row ++ ;
					}
			}
			br.close();
			fr.close();
		}catch(Exception e){e.printStackTrace(); }
		
		return arr ;
		
		
	}
}
