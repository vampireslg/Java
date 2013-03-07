class DynamicArray{
    public static void main(String[] args){
	Other.main(new String[] {"d", "b"});
    }
}

class Other{
    public static void main(String[] args){
	for(String s : args){
	    System.out.println(s + " ");
	}
    }
}
	    