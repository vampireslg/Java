import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.event.*;
import javax.swing.*;


public class Code11_3{
    public static void main(String[] args){
	new LinWin();
    }
}

class LinWin extends JFrame implements ActionListener, Runnable{
    Button button;
    URL url;
    TextField text;
    JEditorPane editPane;
    byte b[] = new byte [18];
    Thread thread;
    public LinWin(){
	text = new TextField(20);
	editPane = new JEditorPane();
	editPane.setEditable(false);
	button = new Button ("Confirm");
	button.addActionListener(this);
	thread = new Thread(this);
	Panel p = new Panel();
	p.add(new Label("Url ."));
	p.add(text);
	p.add(button);
	ScrollPane scroll = new ScrollPane();
	scroll.add(editPane);
	add(scroll, BorderLayout.CENTER);
	add(p,BorderLayout.NORTH);
	setBounds(60,60,360,300);
	setVisible(true);
	validate();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	editPane.addHyperlinkListener(new HyperlinkListener(){
		public void hyperlinkUpdate(HyperlinkEvent e){
		    if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED){
			try{ editPane.setPage(e.getURL());
			}catch(IOException e1){
			    editPane.setText(" "+e1);
			}
		    }
		}});
    }

    public void actionPerformed(ActionEvent e){
	if(!(thread.isAlive()))
	    thread = new Thread(this);
	try{ thread.start();
	}
	catch(Exception ee){
	    text.setText(" Reading " + ee);
	}
    }

    public void run(){
	try{
	    editPane.setText(null);
	    url = new URL("http://"+text.getText().trim());
	    editPane.setPage(url);
	}catch (Exception eee){
	    text.setText(" "+eee);
	    return;
	}
    }
}	      