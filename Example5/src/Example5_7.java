import java.util.*;

public class Example5_7 {
	public static void main(String[] args) {
		String s = "I am Gary Host, Aron Swarz died seveval days ago .";
		StringTokenizer analysize = new StringTokenizer(s, " ,");
		int number = analysize.countTokens();
		while (analysize.hasMoreTokens()) {
			String str = analysize.nextToken();
			System.out.println(str);
			System.out.println(analysize.countTokens() + " words remain .");
		}
	}
}
