package ca.centennial.test;
/**
 * @author Chen Feng 300720952
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberTableManager {
	private final static String UserName = "COMP228F14_120";
	private final static String Password = "password";
	private final static String Driver_Name = "oracle.jdbc.driver.OracleDriver";
	private final static String Connection_Str = "jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD";

	public static void main(String[] args) {
		MemberTableManager memberManager = new MemberTableManager();
		Connection conn = null;
		
		// open connection
		conn = memberManager.connect(conn);
		
		// display all records
		memberManager.displayMemberTable(conn);
		
		// add a new record
		System.out.println("\nAdd a new record");
		memberManager.addRecord(conn);
		
		// display all records after adding
		memberManager.displayMemberTable(conn);
		
		// delete a record
		System.out.println("\nDelete a record");
		int deleteMemberId = 6;
		memberManager.deleteRecord(conn, deleteMemberId);
		
		// display all records after deleting		
		memberManager.displayMemberTable(conn);
		
		// close connection
		memberManager.disconnect(conn);
	}

	private void disconnect(Connection conn) {
		try{
			conn.close();
			System.out.println("\nDisconnect successful");
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}

	private Connection connect(Connection conn) {
		try {
			Class.forName(Driver_Name);
			conn = DriverManager.getConnection(Connection_Str, UserName, Password);
			System.out.println("Connect successful");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	private void deleteRecord(Connection conn, int memberId) {
		Statement stmt = null;
		try{
			stmt = conn.createStatement();
			String deleteMemberSql = "delete from member where memId=" + memberId;
			int affectedRows = stmt.executeUpdate(deleteMemberSql);
			System.out.println(affectedRows == 1? "Delete successful" : "Delete failed");
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		finally{
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void displayMemberTable(Connection conn) {
		System.out.println("\nCurrent records: ");
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			String getMemberSql = "select * from Member";
			rs = stmt.executeQuery(getMemberSql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int row = 0;
			while (rs.next()) {
				row++;
				String info = "";
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					info += rsmd.getColumnName(i) + ": " + rs.getString(i) + " ";
				}
				System.out.println("Row " + row + ": " + info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void addRecord(Connection conn) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String addMemeberSql = "insert into member (memId, lName, fName, address, numBook) values (6, 'Newton', 'Kevin', '1456 Sheppard', 2)";
			int affectedRows = stmt.executeUpdate(addMemeberSql);
			System.out.println(affectedRows == 1 ? "Add successful" : "Add failed");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
