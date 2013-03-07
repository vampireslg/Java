import java.awt.*;
import java.awt.event.*;
public class Exercise{
    public static void main(String args[]){
	new MyFrame();
    }
}
class MyFrame extends Frame implements Runnable, ActionListener{
    Clerk cleak;
    Thread thread0,thread1,thread2;
    static TextArea text;
    Button start=new Button("Waiting for tickets !" );
    MyFrame(){
	cleak=new Clerk();
	thread0=new Thread(this);
	thread1=new Thread(this);
	thread2=new Thread(this);
	text=new TextArea(10,30);
	start.addActionListener(this);
	add(text,BorderLayout.CENTER);
	add(text,BorderLayout.NORTH);
	setVisible(true);
	setSize(360,300);
	validate();
	addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
		    System.exit(0);
		}
	    });
    }
    public void actionPerformed(ActionEvent e){
	try{thread0.start();
	    thread1.start();
	    thread2.start();
	}
	catch(Exception e){}
    }
    public void run(){
	if(Thread.currentThread==Thread0)
	    clerk.saleRule(20);
	else if(Thread.currentThread==Thread1)
	    clerk.saleRule(10);
	else if(Thread.currentThread==Thread2)
	    clerk.saleRule(5);
    }

    class Clerk{
	int numOfFive=3,numOfTen=0,numOfTwenty=0;
	String s=null;
	public synchronized void saleRule(int money){
	    if(money==5){
		numOfFive+=1;
		s="Here is your ticket Enjoy !";
		MyFrame.text.append("\n"+s);
	    }
	    else if(money==10){
		while (numOfFive<1){
		    try{wait();
		    }
		    catch(InterruptedException e){}
		}
		numOfFive-=1;
		numOfTen+=1;
		s="Here is your ticket Enjoy ! \n And your change .";
		MyFrame.text.append("\n"+s);
	    }
	    else if(money==20){
		while (numOfFive*5+numOfTen*10<15||numOfFive<1){
		    try{wait();
		    }
		    catch(InterruptedException e){}
		}
		if(numOfTen>=1){
		    numOfTen-=1;
		    numOfFive-=1;
		    numOfTwenty+=1;
		}
		else{
		    numOfFive-=3;
		    numOfTwenty+=1;
		}
		s="Here is your ticket Enjoy ! \n And your change .";
		MyFrame.text.append("\n"+s);
	    }
	    notifyAll();
	}
    }

    
		 
	    
	 