import java.awt.*;
import java.awt.event.*;

public class Example9_14 {
	public static void main(String[] args) {
		new MyFrame();
	}
}
class MyFrame extends Frame implements Runnable, ActionListener{
	Clerk thread0;
        Thread thread1, thread2,thread3;
	static TextArea text;
	Button start=new Button("Waiting for book . ");
	MyFrame(){
		thread0=new Clerk();
		thread1=new Thread(this);
		thread2=new Thread(this);
		thread3=new Thread(this);
		text=new TextArea(10,30);
		start.addActionListener(this);
		add(text,BorderLayout.CENTER);
		add(start,BorderLayout.NORTH);
		setVisible(true);
		setSize(360,300);
		validate();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}	
		});
	}
	public void actionPerformed(ActionEvent e){
		try{
			thread1.start();
			thread2.start();
			thread3.start();
			}
		catch (Exception exp){}
	}
	public void run(){
		if(Thread.currentThread()==thread1)
			thread0.saleRule(20);
		else
		    thread0.saleRule(5);
	}
}

class Clerk{
	int numOfFive=1,numOfTen=0,numOfTwenty=0;
	String s=null;
	public synchronized void saleRule(int money){
		if(money==5){
			numOfFive=numOfFive+1;
			s="Here is your ticket, enjoy ! ";
			MyFrame.text.append("\n"+s);
			System.out.println(numOfFive);
		}
		else if (money==20){
			if(numOfFive<3){
				try {
					wait();
				}
				catch(InterruptedException e){}
			}
			numOfFive=numOfFive-3;
			numOfTwenty=numOfTwenty+1;
			s="Here is your ticket ,and your change .";
			MyFrame.text.append("\n"+s);
			System.out.println(numOfFive);
		}
		notifyAll();
	}
}
