package zdy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @MasterService 数据操作模板
 * @author zhangdengyuan
 * @descp 数据库连接管理器（建立连接->操作数据库->释放连接） (抛出异常，让调用者进行处理)
 * @createDate 2014-12-05
 * @lastUpdateDate 2014-12-09
 * @version 1.0
 */
public class DBManager {
	/** 数据库的连接URL */
//	private String url = "jdbc:mysql://192.168.3.11:3306/fuzhoudianyeju";
	private String url = "jdbc:mysql://localhost:3306/fuzhoudianyeju";
	/** 数据库用户名 */
//	 private String userName = "itims";
	private String userName = "root";
	/** 数据库密码 */
//	 private String password = "itims1cstnet2DH";
	private String password = "root";
	/** 数据库连接流 */
	private Connection connection;
	/** 数据库语句流 */
	private Statement statement;
	/** 数据库结果集 */
	private ResultSet resultSet;

	/**
	 * url的取得
	 * 
	 * @return String【url】（url）
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * url的设置
	 * 
	 * @param String【url】（url）
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * userName的取得
	 * 
	 * @return String【userName】（userName）
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * userName的设置
	 * 
	 * @param String【userName】（userName）
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * password的取得
	 * 
	 * @return String【password】（password）
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * password的设置
	 * 
	 * @param String【password】（password）
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * connection的取得
	 * 
	 * @return Connection【connection】（connection）
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * connection的设置
	 * 
	 * @param Connection【connection】（connection）
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	/**
	 * statement的取得
	 * 
	 * @return Statement【statement】（statement）
	 */
	public Statement getStatement() {
		return statement;
	}

	/**
	 * statement的设置
	 * 
	 * @param Statement【statement】（statement）
	 */
	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	/**
	 * resultSet的取得
	 * 
	 * @return ResultSet【resultSet】（resultSet）
	 */
	public ResultSet getResultSet() {
		return resultSet;
	}

	/**
	 * resultSet的设置
	 * 
	 * @param ResultSet【resultSet】（resultSet）
	 */
	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	/**
	 * 打开数据库连接并获取语句流
	 * 
	 * @return boolean【true:打开成功|false:打开失败】
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public void openConnection() throws ClassNotFoundException, SQLException,
			InstantiationException, IllegalAccessException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection = (Connection) DriverManager.getConnection(url, userName,
				password);
		statement = (Statement) connection.createStatement(
				ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
	}

	/** 开启事务 */
	public void openTranscation() throws SQLException {
		/** 禁止自动提交 */
		connection.setAutoCommit(false);
	}

	/** 回滚事务 */
	public void rollbackTranscation() throws SQLException {
		connection.rollback();
	}

	/** 手动提交事务 */
	public void closeTranscation() throws SQLException {
		connection.commit();
	}

	/**
	 * 关闭数据库的数据流
	 * 
	 * @return boolean【true:打开成功|false:打开失败】
	 */
	public void closeConnection() throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}

	/**
	 * 数据库的数据操作
	 * 
	 * @param String【sql】（数据库语句）
	 * @return boolean【true:打开成功|false:打开失败】
	 */
	public ResultSet executeQuery(String sql) throws SQLException {
		resultSet = (ResultSet) statement.executeQuery(sql);
		return resultSet;
	}

	/**
	 * 数据库的数据操作
	 * 
	 * @param String【sql】（数据库语句）
	 * @return boolean【true:打开成功|false:打开失败】
	 */
	public int executeUpdate(String sql) throws SQLException {
		return statement.executeUpdate(sql);
	}
}
