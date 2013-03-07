import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class Example9_18 {
	public static void main(String[] args) {
		TimeWin Win = new TimeWin();
	}
}
class TimeWin extends Frame implements
ActionListener{
	TextField text;
	Button bStart, bStop, bContinue;
	Timer time;
	int n=0,start=1;
	
	TimeWin(){
		time=new Timer(1000,this);
		text=new TextField(25);
		bStart=new Button("Time Begin ");
		bStop=new Button("Time Over ");
		bContinue=new Button("Time Continue ");
		bStart.addActionListener(this);
		bStop.addActionListener(this);
		bContinue.addActionListener(this);
		
		setLayout(new FlowLayout());
		add(bStart);
		add(bStop);
		add(bContinue);
		add(text);
		setSize(500,500);
		validate();
		setVisible(true);
		addWindowListener(new WindowAdapter(){
			public void windowClosing (WindowEvent e){
				System.exit(0);
			}
		});
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==time){
			java.util.Date date=new java.util.Date();
			String str=date.toString().substring(11,28);
			text.setText("Time "+str);
			int x=text.getBounds().x;
			int y=text.getBounds().y;
			y=y+20;
			if(y>500)
				y=10;
			text.setLocation(x, y);
					
		}
		else if(e.getSource()==bStart){
			time.start();
		}
		else if(e.getSource()==bStop){
			time.stop();
		}
		else if(e.getSource()==bContinue){
			time.start();
		}
	}
}