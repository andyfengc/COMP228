package ca.centennial.practice;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GuiOracleTestSimple extends JFrame {
	private JPanel pnl;
	private JLabel lblUser, lblPassword;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private JButton btnTest;
	private JTextArea txtDisplay;

	public GuiOracleTestSimple() {
		pnl = new JPanel();
		lblUser = new JLabel("User: ");
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword = new JLabel("Password: ");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		txtUser = new JTextField(20);
		txtPassword = new JPasswordField(20);

		pnl.setLayout(new GridLayout(3, 3, 5, 5));
		pnl.add(lblUser);
		pnl.add(txtUser);
		pnl.add(new JLabel());
		pnl.add(lblPassword);
		pnl.add(txtPassword);
		pnl.add(new JLabel());

		btnTest = new JButton("Test");
		ButtonHandler handler = new ButtonHandler();
		btnTest.addActionListener(handler);
		pnl.add(btnTest);

		add(pnl, BorderLayout.CENTER);

		txtDisplay = new JTextArea(10, 5);
		add(txtDisplay, BorderLayout.SOUTH);
	}

	private class ButtonHandler implements ActionListener {
		private final static String UserName = "COMP228F14_8";
		private final static String Password = "password";
		private final static String Driver_Name = "oracle.jdbc.driver.OracleDriver";
		private final static String Connection_Str = "jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD";

		@Override
		public void actionPerformed(ActionEvent e) {
			String user = txtUser.getText();
			String password = txtPassword.getText();
			Connection conn = null;
			if (user == null || user.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter user name");
			} else if (password == null || password.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter password");
			} else {
				try {
					connect(user, password);
					txtDisplay.setText("Connected!");
				} finally {
					disconnect(conn);
				}
			}
		}

		private void disconnect(Connection conn) {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		private Connection connect(String user, String password) {
			Connection conn = null;
			try {
				Class.forName(Driver_Name);
				DriverManager.getConnection(Connection_Str, user, password);
				JOptionPane.showMessageDialog(null, "Connect successfully!");
			} catch (SQLException se) {
				JOptionPane.showMessageDialog(null, se.getMessage());
				se.printStackTrace();
			} catch (ClassNotFoundException ce) {
				JOptionPane.showMessageDialog(null, ce.getMessage());
				ce.printStackTrace();
			}
			return conn;
		}

	}

	public static void main(String[] args) {
		GuiOracleTestSimple app = new GuiOracleTestSimple();
		app.setSize(600, 300);
		app.setVisible(true);
		app.setDefaultCloseOperation(app.EXIT_ON_CLOSE);
	}
}
