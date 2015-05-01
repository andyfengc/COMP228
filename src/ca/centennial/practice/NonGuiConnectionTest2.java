package ca.centennial.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NonGuiConnectionTest2 {
	private final static String UserName = "COMP228F14_8";
	private final static String Password = "password";
	private final static String Driver_Name = "oracle.jdbc.driver.OracleDriver";
	private final static String Connection_Str = "jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD";

	public static void main(String[] args) {
		Connection conn = null;
		try{
			Class.forName(Driver_Name);
			conn = DriverManager.getConnection(Connection_Str, UserName, Password);
			System.out.println("connected");
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		finally{
			try{
				if (conn != null){
					conn.close();
				}
			}
			catch (SQLException e){
				e.printStackTrace();
			}
		}
	}

}
