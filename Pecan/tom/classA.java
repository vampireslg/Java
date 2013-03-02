package tom;
public class classA{
	public void getPrimenumber(int n){
		int i, j;
		for(i=1;i<=n;i++){
		for(j=1;j<=i/2;j++){
			if(i%j==0)
				break;
			if(j>i/2)
				System.out.println(" "+i);
		}
		}
	}
}
