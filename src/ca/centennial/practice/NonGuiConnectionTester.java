package ca.centennial.practice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class NonGuiConnectionTester {
	private final static String UserName = "COMP228F14_8";
	private final static String Password = "password";
	private final static String Driver_Name = "oracle.jdbc.driver.OracleDriver";
	private final static String Connection_Str = "jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD";

	public static void main(String[] args) {
		// connectTester();
//		batchProcess();
		 displayTable();
//		callProcedure();
	}

	private static void connectTester() {
		Connection conn = null;
		try {
			// loading driver
			Class.forName(Driver_Name);
			// jdbc:oracle:thin:@<servername>:<portnumber>:<databasename>
			conn = DriverManager.getConnection(Connection_Str, UserName,
					Password);
			System.out.println("Connected");
		} catch (SQLException se) {
			System.out.println("sql error: " + se.toString());
			// se.printStackTrace();
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	private static void displayTable() {
//		String queryStr = "SELECT table_name FROM user_tables";
		String queryStr = "select * from newspaper";
		try {
			Class.forName(Driver_Name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection conn = DriverManager.getConnection(Connection_Str,
				UserName, Password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(queryStr)) {
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void displayView() {
		// same as table
	}

	private static void batchProcess() {
		try {
			Class.forName(Driver_Name);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "INSERT INTO newspaper VALUES (?, ?, ?)";
		try (Connection conn = DriverManager.getConnection(Connection_Str,
				UserName, Password);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			System.out.println("Please input values: (e.g. **, **, **)");
			Scanner scanner = new Scanner(System.in);
			conn.setAutoCommit(false);
			// String inputValue = scanner.nextLine();
			Object[] values = scanner.nextLine().split(",");
			pstmt.setString(1, values[0].toString().trim());
			pstmt.setString(2, values[1].toString().trim());
			pstmt.setInt(3, Integer.parseInt(values[2].toString().trim()));
			pstmt.addBatch();
			pstmt.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void callProcedure() {
		// create a simple function in oracle
		// create or replace function func_calc(a in int, b in int)
		// return int
		// as
		// begin
		// return power(a,b);
		// end;
		// /
		// sho err
		// select func_calc(2,3) from dual;
		
		try {
			Class.forName(Driver_Name);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		
		try(Connection conn = DriverManager.getConnection(Connection_Str, UserName, Password);
//				CallableStatement cs = conn.prepareCall("{call func_calc(?, ?)}");
				CallableStatement cs = conn.prepareCall("{call func_calc(2, 3)}");
						){
			cs.execute();
			ResultSet rs = (ResultSet)cs.getObject(1);
			while(rs.next()){
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
