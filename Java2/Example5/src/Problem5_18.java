class CommonDivisor{
	public int f(int m, int n){
		if (m<n){
			int temp=0;
			temp=m;
			m=n;
			n=temp;
		}
		int r=m%n;
		while(r!=0){
			m=n;
			n=r;
			r=m%n;
		}
		return n;
	}
}
class CommonMultiple extends CommonDivisor{
	public int f(int m,int n){
		int divisor=super.f(m,n);
		int mutiple=(m*n)/divisor;
		return mutiple;
	}
}
public class Problem5_18 {
	public static void main(String[] args) {
		CommonDivisor cDivisor=new CommonDivisor();
		int result=cDivisor.f(24,36);
		CommonMultiple cMultiple=new CommonMultiple();
		int multiple=cMultiple.f(19,36);
		System.out.println("The maxCommonDivisor : "+ result);
		System.out.println("The minCommonMultiple: "+ multiple);
	}
}