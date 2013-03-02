public class Example5_11 {
	public static void main(String[] args) {
		StringBuffer s = new StringBuffer("I");
		System.out.println(s);
		int size=s.capacity();
		System.out.println(size);
		s.insert(1, " wish");
		System.out.println(s);
		s.setCharAt(1, '*');
		System.out.println(s);
		s.append(" you happy" );
		s.reverse();
		System.out.println(s);
		String regex="\\w{1,}@\\w{1,}\56\\w{1,}";
		String str1="L@sina.com";
		String str2="l_si@dl.whatever_cn";
		Aux aux=new Aux();
		aux.matchRegex(str2, regex);
	}
}
class Aux{
	public void matchRegex(String str, String regex){
		if(str.matches(regex))
			System.out.println(str+" IS an E-mail address. ");
		else
			System.out.println(str+" IS NOT an E-mail address. ");
		
	}
}