import java.net.*;
import java.awt.*;
import java.awt.event.*;

class K_Frame extends Frame implements Runnable,ActionListener{
    TextField out_message = new TextField("Send Message to L : ");
    TextArea in_message = new TextArea();
    Button b = new Button("Send Msg Package to L");
    K_Frame(){
	super("K");
	setSize(200,500);setVisible(true);
	b.addActionListener(this);
	add(out_message,"South");add(in_message,"Center"); add(b,"North");
	Thread thread = new Thread(this);
	thread.start();  // take charge of reive of msg
    }

    public void actionPerformed(ActionEvent event){
	byte buffer[] = out_message.getText().trim().getBytes();
	try{
	    InetAddress address = InetAddress.getByName("192.168.8.14");
	    DatagramPacket data_pack = new DatagramPacket (buffer, buffer.length, address, 545);
	    DatagramSocket mail_data = new DatagramSocket();
	    in_message.append("Target Host Adr: " + data_pack.getAddress() + "\n");
	    in_message.append("Target Port: " + data_pack.getPort() + "\n");
	    in_message.append("Data Length : " + data_pack.getLength() + "\n");
	    
	    mail_data.send(data_pack);
	}catch (Exception e){}
    }

    public void run(){
	DatagramPacket pack = null ;
	DatagramSocket mail_data = null;
	byte data[] = new byte[8192];
	try{
	    pack = new DatagramPacket(data, data.length);
	    mail_data = new DatagramSocket(545);
	}catch (Exception e){}
	while(true){
	    if (mail_data == null) break;
	    else
		try{
		    mail_data.receive(pack);
		    int length = pack.getLength();
		    InetAddress address = pack.getAddress();
		    int port = pack.getPort();
		    String message = new String(pack.getData(), 0, length);
		    in_message.append("Message length: " + length + "\n");
		    in_message.append("Msg comes from : " + address + "port: " + port + "\n");
		    in_message.append("Msg is: " + message + "\n");
		}catch (Exception e){}
	}
    }
}

public class UDPK{
    public static void main(String[] args){
	K_Frame k_win = new K_Frame();
	k_win.addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
		    System.exit(0);
		}
	    });
	k_win.validate();
    }
}
	
	