package smartalgorithm;

public class RunTest {
	public static void main(String[] args) {
		int i = 2; 
		int j = 2; 
		int k = 3;
		HashNode hn = new HashNode(i, j, k);
		System.out.println("---------" + hn.getL());
		int[][] initArr = {{1,2},{2,3},{4,5},{2,4}};
		HashSort hs = new HashSort();
		hs.initLocMap(initArr);
		
	}
}
