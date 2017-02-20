package com.raj.shashi.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author vagrant
 *
 */
public class ConnectionCheck {

	private static Connection conn;

	public Connection getConnection() {
		if (conn != null) {
			return conn;
		} else {
			try {
				conn = DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME, JdbcConstants.PASSWORD);
				if (conn != null) {
					System.out.println("connected to mysql!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
}
