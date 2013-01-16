class MyException extends Exception {
	String message;

	public MyException() {
		// TODO Auto-generated constructor stub
		message = "Exception: Probably improper actions occured !";
	}

	public String toString() {
		return message;
	}
}

class Student {
	public void speak(int m) throws MyException {
		if (m > 1000) {
			MyException exception = new MyException();
			throw exception;
		} else
			System.out.println(m);
	}
}

public class Example5_17 {
	public static void main(String[] args) {
		Student student = new Student();
		try {
			student.speak(10000);
		} catch (MyException e) {
			System.out.println(e.toString());
		}
	}

}
