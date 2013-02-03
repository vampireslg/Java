import java.util.*;
public class Code13_5 {
	public static void main(String[] args) {
		Stack myStack=new Stack();
		System.out.println("The 1th Fibonacii Number : "+1);
		System.out.println("The 2th Fibonacii Number : "+1);
		myStack.push(new Long(1));
		myStack.push(new Long(1));
		int k=1;
		while(k<=500){
			for(int i=1;i<=2;i++){
				Long F1=(Long)myStack.pop();
				Long F2=(Long)myStack.pop();
				long f1=F1.longValue();
				long f2=F2.longValue();
				System.out.println("The "+(k+2)+"th Fibonacii Number : "+(f1+f2));
				Long temp=new Long(f1+f2);
				myStack.push(temp);
				myStack.push(F2);
				
				
				k++;
			}
			
		}
	}
}
