package sortAlgo;

public class Tuple<A, B> {
	public final  A firstItem; 
	public final B secondItem; 
	
	public Tuple(A a , B b){
		this.firstItem = a ; 
		this.secondItem = b ;
	}
	
	public A getL(){//getParent
		return firstItem ;
	}
	
	public B getR(){ // getChild 
		return secondItem ;
	}
}
