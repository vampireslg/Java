
public class Example5_8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c[],d[];
		String s="IWishYouHaveTheSameFeeling";
		c=new char[30];
		s.getChars(5, 26, c,0);
		System.out.println(c);
		d=new char[s.length()];
		s.getChars(5, 8, d, 0 );
		s.getChars(1, 5, d, 3);
		s.getChars(0, 1, d, 7);
		s.getChars(8, 26, d, 8);
		System.out.println(d);
		String str="GUCASIACAS";
		char b[]=str.toCharArray();
		for (int i=0; i<b.length; i++){
			b[i]=(char)(b[i]^'t');
		}
		String secret=new String(b);
		System.out.println("Secret code : "+secret );
		for (int i=0; i<b.length; i++){
			b[i]=(char)(b[i]^'t');
		}
		String code=new String(b);
		System.out.println(b);
	}

}
