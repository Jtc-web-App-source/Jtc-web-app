package jtc.DBConfuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfiguration {
	public static Connection connection = null;

	public static Connection getConnection() throws Exception {
		String URL = "jdbc:oracle:thin:@localhost:1522:xe";
		String USERNAME = "SYSTEM";
		String PASSWORD = "system";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		return connection;
	}
}
