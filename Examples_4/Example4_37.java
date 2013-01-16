public class Example4_37 {
	public static void main(String args[]){
		char a[]={'a','b','c','d','e'};
		for(int i=0;i<a.length;i++){
			if(Character.isLowerCase(a[i])){
				a[i]=Character.toUpperCase(a[i]);
			}
			else if(Character.isLowerCase(a[i])){
				a[i]=Character.toLowerCase(a[i]);
			}
		}
		for(int i=0; i<a.length; i++){
			System.out.print(" "+a[i]);z
		}
	}

}
