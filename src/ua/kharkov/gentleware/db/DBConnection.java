package ua.kharkov.gentleware.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private final static String url = "jdbc:mysql://localhost/";
	private final static String dbName = "vyacheslav_kozlov_gentleware";
	private final static String driver = "com.mysql.jdbc.Driver";
	private final static String userName = "root";
	private final static String password = "";
	private static Connection conn;

	 static{
		try {
			Class.forName(driver).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {

		try {
			if (conn == null || conn.isClosed()) {
				conn = (Connection) DriverManager.getConnection(url + dbName,
						userName, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return conn;
	}


}
