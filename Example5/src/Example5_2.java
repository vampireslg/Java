public class Example5_2 {

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		// TODO Auto-generated method stub
		int number = 0;
		String s = "student,proxy,whatever,engineer,school,end,endof";
		for (int i = 0; i < s.length(); i++) {
			if (s.regionMatches(i, "en", 0, 2))
				number++;
		}
		System.out.println("number: " + number);
	}

}
