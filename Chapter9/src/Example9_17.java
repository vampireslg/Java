import java.awt.*;
import java.awt.event.*;

public class Example9_17 {
	public static void main(String[] args) {
		Win win = new Win();
	}
}

class Win extends Frame implements Runnable, ActionListener {
	Thread moveOrStop;
	Button start, suspend, revive, terminate;
	Label moveLabel;
	boolean move = false, die = false;

	Win() {
		moveOrStop = new Thread(this);
		start = new Button("Thread start");
		suspend = new Button("Thread suspend");
		revive = new Button("Thread revive");
		terminate = new Button("Thread terminate");
		start.addActionListener(this);
		suspend.addActionListener(this);
		revive.addActionListener(this);
		terminate.addActionListener(this);
		moveLabel = new Label("I am moving !");
		moveLabel.setBackground(Color.yellow);
		setLayout(new FlowLayout());
		add(start);
		add(suspend);
		add(revive);
		add(terminate);
		add(moveLabel);
		setSize(300, 200);
		validate();
		setVisible(true);
		addWindowFocusListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start) {
			try {
				move = true;
				moveOrStop.start();
			} catch (Exception event) {
			}
		} else if (e.getSource() == suspend) {
			move = false;
		} else if (e.getSource() == revive) {
			move = true;
			reviveThread();
		} else if (e.getSource() == terminate) {
			die = true;
		}
	}

	public void run() {
		while (true) {
			while (!move) {
				try {
					suspendThread();
				} catch (InterruptedException e1) {
				}
			}
			int x = moveLabel.getBounds().x;
			int y = moveLabel.getBounds().y;
			x=x + 20;
			if (x >= 200)
				x = 10;
			moveLabel.setLocation(x, y);
			try {
				moveOrStop.sleep(200);
			} catch (InterruptedException e2) {
			}
			if (die == true)
				return;
		}
	}

	public synchronized void suspendThread() throws InterruptedException {
		wait();
	}

	public synchronized void reviveThread() {
		notifyAll();
	}
}