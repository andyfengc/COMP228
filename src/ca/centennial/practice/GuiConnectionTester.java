package ca.centennial.practice;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuiConnectionTester extends JFrame {
	private final static String READ_TABLE = "select table_name from user_tables";
	
	private JLabel lblUserName;
	private JLabel lblPassword;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JButton btnClear;	
	private JButton btnConnect;
	private JTextArea txtResult;
	
	public GuiConnectionTester(){
		this.setSize(400, 300);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		buildLayout();
	}
	
	private void buildLayout() {
		// set content panel
		JPanel pnlContent = new JPanel();
		GridLayout mainLayout = new GridLayout(3, 2);
		pnlContent.setLayout(mainLayout);
		// add components
		lblUserName = new JLabel("User Name");
		txtUserName = new JTextField(30);
		pnlContent.add(lblUserName);
		pnlContent.add(txtUserName);
		lblPassword = new JLabel("Password");
		txtPassword = new JTextField(30);
		pnlContent.add(lblPassword);
		pnlContent.add(txtPassword);
		btnClear = new JButton("Clear");
		btnConnect = new JButton("Connect");
		pnlContent.add(btnClear);
		pnlContent.add(btnConnect);
		// set result panel
		JPanel pnlResult = new JPanel();
		txtResult = new JTextArea(5, 50);
		pnlResult.add(txtResult);
		// add major panels
		this.add(pnlContent, BorderLayout.CENTER);
		this.add(pnlContent, BorderLayout.SOUTH);
		
	}

	public static void main(String[] args) {
		GuiConnectionTester gui = new GuiConnectionTester();
	}

}
