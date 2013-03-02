public class Example5_5 {
	public static void main(String[] args) {
		double n, sum = 0, item = 0;
		boolean computable = true;
		for (int i = 0; i < args.length; i++) {
			try {
				item = Double.parseDouble(args[i]);
				sum += item;
			} catch (NumberFormatException e) {
				System.out.println("Ilegal input : " + e);
				computable = false;
			}
		}
		if (computable) {
			n = sum / args.length;
			System.out.println("Average Number : " + n);
		}
		int number=123455;
		String binaryString=Long.toBinaryString(number);
		String octalString=Long.toOctalString(number);
		System.out.println(binaryString);
		System.out.println(octalString);
	}
}
