package smartalgorithm;
import java.util.*;
/**
 * 
 * @author gaoang
 *
 * @param <L>
 * @param <P>
 * @param <S>
 */

public class HashNode<L, P, S>{
	L loc ; 
	P pres;
	S sucs; 
	HashNode(L loc, P pres, S sucs){
		this.loc = loc ;
		this.pres = pres; 
		this.sucs = sucs;
	}

	L getL(){
		return loc ;
	}
	
	
	P getP(){
		return pres;
	}

	
	S getS(){
		return sucs;
	}

}
