package ca.centennial.practice;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Microwave extends JFrame {
	public Microwave() {
		buildLayout();
	}

	private void buildLayout() {
		// build buttons part
		JPanel pnlKeypad = new JPanel();
		pnlKeypad.setLayout(new GridLayout(4, 3));
		// build control part
		JPanel pnlControl = new JPanel(new BorderLayout());
		final JTextField txtTime = new JTextField("Time is here....");
		pnlControl.add(txtTime, BorderLayout.NORTH);
		pnlControl.add(pnlKeypad, BorderLayout.CENTER);
		// add keys
		for (int i = 0; i < 9; i++) {
			JButton btnKey = new JButton(String.valueOf(i + 1));
			final int startSecond = (i + 1) * 60;
			btnKey.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					new Thread(new Runnable() {

						@Override
						public void run() {
							txtTime.setText(startSecond + "");
							int currentSecond = startSecond;
							while (currentSecond > 0){
								currentSecond--;
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								txtTime.setText(currentSecond + "");
							}
							if (currentSecond == 0){
								JOptionPane.showMessageDialog(Microwave.this, "Food is ready");
							}
						}
					}).start();
				}
			});
			pnlKeypad.add(btnKey);
		}
		pnlKeypad.add(new JButton(String.valueOf(0)));
		pnlKeypad.add(new JButton("Start"));
		pnlKeypad.add(new JButton("Stop"));
		// build main frame
		this.add(pnlControl, BorderLayout.EAST);
		this.add(new JButton("Food is here"), BorderLayout.CENTER);

	}

	public static void main(String[] args) {
		Microwave mw = new Microwave();
		mw.setTitle("My Microwave");
		mw.setSize(400, 250);
		mw.setDefaultCloseOperation(mw.EXIT_ON_CLOSE);
		mw.setLocationRelativeTo(null);
		mw.setVisible(true);
	}
	
}
