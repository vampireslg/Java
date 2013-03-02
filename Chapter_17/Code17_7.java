import javax.swing.*;
import java.awt.*;
public class Code17_7{
    public static void main(String[] args){
	BarWin win=new BarWin();
	win.thread1.start();
	win.thread2.start();
    }
}
class BarWin extends JFrame implements Runnable{
    JProgressBar pbar1,pbar2;
    Thread thread1,thread2;
    JTextField text1, text2;
    BarWin(){
	pbar1=new JProgressBar(0,20);
	pbar2=new JProgressBar(0,100);
	pbar1.setStringPainted(true);
	pbar2.setStringPainted(true);
	text1=new JTextField(10);
	text2=new JTextField(10);
	thread1=new Thread(this);
	thread2=new Thread(this);
	Container con=getContentPane();
	con.setLayout(new FlowLayout());
	con.add(pbar1);
	con.add(text1);
	con.add(pbar2);
	con.add(text2);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100,10,300,100);
	setVisible(true);
	validate();
    }
    public void run(){
	if(Thread.currentThread()==thread1){
	    for(int i=0; i<=100; i++){
		text1.setText("Fobinacci Item: "+i);
		pbar1.setValue(i);
		try{Thread.sleep(500);
		}catch(InterruptedException e){}
	    }
	}
	if(Thread.currentThread()==thread2){
	    long fa1=1,fa2=1,fa=fa1;
	    int i=1;
	    while(i<=100){
		if(i>=3){
		    fa=fa1+fa2;
		    fa1=fa2;
		    fa2=fa;
		}
		text2.setText("Fobinacci Item: "+i);
		pbar2.setValue(i);
		i++;
		try{Thread.sleep(500);}
		catch(InterruptedException e){}
	    }
	}
    }
    long f(int n){
	long fa=0;
	if(n==1||n==2)
	    fa=1;
	else
	    fa=f(n-1)+f(n-2);
	return fa;
    }
}
	    
			     	  