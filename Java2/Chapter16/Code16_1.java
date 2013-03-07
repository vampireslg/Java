import java.io.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

class AudioClipWindow extends Frame implements ActionListener, Runnable, ItemListener{
    Thread thread;
    Choice choice;
    URL url;
    AudioClip clip;
    Button bPlay, bLoop, bStop;
    String str;
    public void AudioClipWindow(){
	thread = new Thread(this);
	choice.add("wfei.wav");
	choice.addItemListener(this);
	bPlay = new Button("Play");
	bLoop = new Button("Loop");
	bStop = new Button("Stop");
	bPlay.addActionListener (this);
	bLoop.addActionListener (this);
	bStop.addActionListener (this);
	setLayout(new FlowLayout());
	add(choice);
	add(bPlay);
	add(bLoop);
	add(bStop);
	setSize(350,120);
	setVisible(true);
	addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
		    System.exit(0);
		}
	    });
	validate();
    }

    public void itemStateChanged(ItemEvent e){
	str = choice.getSelectedItem();
	if( !(thread.isAlive()) )
	    thread = new Thread(this);
	try {
	    thread.start();
	}catch(Exception ee){}
    }
    public void run(){
	try {
	    File file = new File(str);
	    url = file.toURL();
	    clip = Applet.newAudioClip(url);
	}
	catch(Exception e){
	    System.out.println(e);
	}
    }
    public void actionPerformed(ActionEvent e){
	if(e.getSource() == bPlay)
	    clip.play();
	else if(e.getSource() == bLoop)
	    clip.loop();
	if(e.getSource() == bStop)
	    clip.stop();
    }
}

public class Code16_1{
    public static void main(String[] args){
	AudioClipWindow win = new AudioClipWindow();
	//System.out.println("Wishyoulikeit");
    }
}
				    