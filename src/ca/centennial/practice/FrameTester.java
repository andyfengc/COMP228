package ca.centennial.practice;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameTester {

	public static void main(String[] args) {
		// set window
		JFrame jf1 = new JFrame("My Frame");
		jf1.setSize(600, 400); // set size as pixels
		jf1.setLocationRelativeTo(null); // center
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.setVisible(true);
		// add a button
		JButton btn1 = new JButton("OK");
		jf1.add(btn1);
		
	}

}
