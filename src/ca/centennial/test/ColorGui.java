package ca.centennial.test;

/**
 * Color GUI
 * @author Chen 
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ColorGui extends JFrame {
	private final static String My_Name = "Chen Feng";

	private JPanel pnlDream = new JPanel(new BorderLayout());
	private JTextField txtDream = new JTextField("");
	private JPanel pnlStyle = new JPanel(new GridLayout(1, 2, 5, 5));
	private JButton btnRed = new JButton("Red");
	private JButton btnItalic = new JButton("Italic");
	private JPanel pnlControl = new JPanel(new GridLayout(1, 2, 5, 5));
	private JButton btnName = new JButton(My_Name);
	private JButton btnClear = new JButton("Clear Text");

	public ColorGui() {
		// build gui
		buildLayout();
		// add listeners
		addListeners();
	}

	/**
	 * build gui
	 */
	private void buildLayout() {
		// set interface
		this.setTitle("Color Your World");
		setLayout(new GridLayout(3, 1, 5, 5));
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		// add dream textfield
		pnlDream.setBorder(new TitledBorder("See How You can Dream in Color"));
		pnlDream.add(txtDream, BorderLayout.CENTER);
		this.add(pnlDream);

		// add style buttons
		pnlStyle.add(btnRed);
		pnlStyle.add(btnItalic);
		// pnlColor.setSize(100, 10);
		this.add(pnlStyle);

		// add control buttons
		pnlControl.add(btnName);
		pnlControl.add(btnClear);
		this.add(pnlControl);
	}

	/**
	 * add event handlers
	 */
	private void addListeners() {
		// add name button event handler
		btnName.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtDream.setText(My_Name);
				txtDream.setForeground(Color.BLACK);
				txtDream.setFont(null);
			}
		});
		// add color button event handler
		btnRed.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtDream.setText(My_Name);
				txtDream.setForeground(Color.RED);
				txtDream.setFont(null);
			}
		});
		// add style button event handler
		btnItalic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtDream.setText(My_Name);
				txtDream.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 20));
			}
		});
		// add clear button event handler
		btnClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtDream.setFont(null);
				txtDream.setText("");
			}
		});
	}

	public static void main(String[] args) {
		ColorGui color = new ColorGui();
	}

}
