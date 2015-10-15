package cn.com.dhcc.fzep.alarm.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlServerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String sql = " select * from  tb_cfg_device ";
		//String url2005 = "jdbc:sqlserver://127.0.0.1:1443;database=company";
		//String url2000 = "jdbc:microsoft:sqlserver://192.168.18.1:1443;database=ems";
		String url2000 = "jdbc:microsoft:sqlserver://192.168.0.102:1443;database=ems";
		try {
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			System.out.println();
			String user = "sa";
			String password = "sa";
			Connection conn = DriverManager.getConnection(url2000, user, password);
			Statement statement = conn.createStatement();
			ResultSet result ; 
			result = statement.executeQuery(sql);
			System.out.println(result);
			statement.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
