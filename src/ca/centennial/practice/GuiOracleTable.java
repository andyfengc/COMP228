package ca.centennial.practice;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GuiOracleTable extends JFrame {
	private final static String Driver_Name = "oracle.jdbc.driver.OracleDriver";
	private final static String Connection_Str = "jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD";

	private JPanel pnl;
	private JLabel lblUser, lblPassword;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private JButton btnDelete, btnSelect, btnCreate;
	JTextArea txtDisplay;

	public GuiOracleTable() {
		pnl = new JPanel();
		lblUser = new JLabel("User: ");
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword = new JLabel("Password: ");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);

		txtUser = new JTextField(20);
		txtPassword = new JPasswordField(20);
		pnl.setLayout(new GridLayout(3, 3, 5, 5));
		// add controls
		pnl.add(lblUser);
		pnl.add(txtUser);
		pnl.add(new JLabel());
		pnl.add(lblPassword);
		pnl.add(txtPassword);
		pnl.add(new JLabel());

		btnDelete = new JButton("delete");
		btnSelect = new JButton("select");
		btnCreate = new JButton("Create");
		pnl.add(btnDelete);
		pnl.add(btnSelect);
		pnl.add(btnCreate);
		add(pnl, BorderLayout.CENTER);
		txtDisplay = new JTextArea(10, 5);
		add(txtDisplay, BorderLayout.SOUTH);
		// add handlers
		CreateHandler createHandler = new CreateHandler();
		btnCreate.addActionListener(createHandler);
	}

	private class CreateHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String user = txtUser.getText();
			String password = txtPassword.getText();
			Connection conn = null;
			try {
				conn = connect(user, password);
				if (conn != null) {
					createTable(conn);
				}
			} finally {
				disconnect(conn);
			}
		}

	}

	private class DeleteHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private class SelectHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private Connection connect(String user, String password) {
		Connection conn = null;
		try {
			Class.forName(Driver_Name);
			conn = DriverManager.getConnection(Connection_Str, user, password);
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

	private void disconnect(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void createTable(Connection conn){
		try{
			int n;
			Statement st = conn.createStatement();
			String selectStatement = "select * from emp1";
			try{
				ResultSet rs = st.executeQuery(selectStatement);
			}
			catch (SQLException e){
				if (e.getMessage().indexOf("ORA-00942") != -1){
					String createSql = "create table emp1(empno number(4), name varchar2(20), time timestamp);";
					n = st.executeUpdate(createSql);
				}
			}
		n = st.executeUpdate("insert into emp1 values(1239, 'syed', CURRENT_TIMESTAMP)");
		n = st.executeUpdate("insert into emp1 values(1240, 'andy', CURRENT_TIMESTAMP)");
		n = st.executeUpdate("insert into emp1 values(1241, 'john', CURRENT_TIMESTAMP)");
		n = st.executeUpdate("insert into emp1 values(1241, 'jimmy', CURRENT_TIMESTAMP)");
		ResultSet rs = st.executeQuery(selectStatement);
		ResultSetMetaData md = rs.getMetaData();
		int row = 0;
		String info = " ";
		while (rs.next()){
			for (int i = 1; i <= md.getColumnCount(); i++){
				info += md.getColumnName(i) + ": " + rs.getString(i) + "\n";
				row += 1;
			}
		}
			txtDisplay.setText(info);
			rs.close();
		}
		catch (SQLException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		GuiOracleTable app = new GuiOracleTable();
		app.setSize(600, 300);
		app.setVisible(true);
		app.setDefaultCloseOperation(app.EXIT_ON_CLOSE);
	}

}
