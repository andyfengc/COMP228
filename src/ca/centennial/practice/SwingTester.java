package ca.centennial.practice;

import javax.swing.JOptionPane;

public class SwingTester {

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "welcome to java world");
		System.out.println("welcome ");
		String input = JOptionPane.showInputDialog("Please input a value");
		System.out.println("Your input is " + input);
	}

}
