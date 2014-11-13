package ca.centennial.practice;

import javax.swing.JApplet;
import javax.swing.JLabel;

public class FlashingText extends JApplet implements Runnable {
	private JLabel lblMessage = new JLabel("Welcome", JLabel.CENTER);

	public FlashingText() {
		add(lblMessage);
		new Thread(this).start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (lblMessage.getText() == null) {
				lblMessage.setText("Welcome again!");
			} else {
				lblMessage.setText(null);
			}
		}

	}

}
