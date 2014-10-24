package ca.centennial.practice;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LayoutTester extends JFrame {
	public LayoutTester(String title) {
		super(title);
		// build a flow layout
		// buildFlowLayout();
		
		// build a grid layout
		//buildGridLayout();
		
		// build border layout
		buildBorderLayout();
	}

	private void buildBorderLayout() {
		setLayout(new BorderLayout(5, 5));
		this.add(new JButton("East"), BorderLayout.EAST);
		this.add(new JButton("West"), BorderLayout.WEST);
		this.add(new JButton("North"), BorderLayout.NORTH);
		this.add(new JButton("South"), BorderLayout.SOUTH);
		this.add(new JButton("Center"), BorderLayout.CENTER);
		// set appearance
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setSize(500, 300);
		this.setVisible(true);
	}

	private void buildGridLayout() {
		setLayout(new GridLayout(2, 2, 5, 5));
		// add components
		this.add(new JLabel("First Name: "));
		this.add(new JTextField(10));
		this.add(new JLabel("Last Name: "));
		this.add(new JTextField(10));
		// set appearance
		this.setSize(500, 100);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void buildFlowLayout() {
		// set a flow layout
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
		// add components
		add(new JLabel("First Name: "));
		add(new JTextField(10));
		add(new JLabel("Middle"));
		add(new JTextField(1));
		add(new JLabel("Last Name: "));
		add(new JTextField(10));
		// set size
		this.setSize(600, 400);
		// set properties
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// add a window
		LayoutTester lt1 = new LayoutTester("My Layout Frame");

	}
}
