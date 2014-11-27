package ca.centennial.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NonGuiConnectionTester {

	public static void main(String[] args) {
		Connection conn = null;
		try{
			String user = "COMP228F14_8";
			String password = "password";
			// loading driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// jdbc:oracle:thin:@<servername>:<portnumber>:<databasename>
			conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD", user, password);
			System.out.println("Connected");
		}
		catch (SQLException se){
			System.out.println("sql error: " + se.toString());
//			se.printStackTrace();
		}
		catch (ClassNotFoundException ce){
			ce.printStackTrace();
		}
		finally{
			try{
				if (conn != null){
					conn.close();
				}
			}
			catch (SQLException se){
				se.printStackTrace();
			}
		}
	}
}
