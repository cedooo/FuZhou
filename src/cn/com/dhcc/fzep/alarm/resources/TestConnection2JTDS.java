package cn.com.dhcc.fzep.alarm.resources;

import java.sql.*;

public class TestConnection2JTDS {
	public static void main(String[] args) throws SQLException {
		String sql = " select top 5 * from  tb_cfg_device  ";
		//String url = "jdbc:jtds:sqlserver://192.168.0.102/otdr-server-db";
		String url = "jdbc:jtds:sqlserver://192.168.1.17/otdr-server-db";
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = DriverManager.getConnection(url, "sa", "123");
		System.out.println("connected");
		Statement statement = conn.createStatement();
		ResultSet result;
		result = statement.executeQuery(sql);
		while(result.next()){
			System.out.println(result.getString("devname"));
		}
		statement.close();

	}
};