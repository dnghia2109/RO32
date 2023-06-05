package org.example.utills;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
	private Connection connection;

	public JdbcUtils() {
		
		connection = connect();
	}

	public Connection connect() {
		try {
			String url="jdbc:mysql://localhost:8080/db_user1";
			String username = "root";
			String password = "123";
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("ket noi thanh cong");
			return connection;
		}catch (ClassNotFoundException e) {
			System.out.println("Ket noi that bai");
			e.printStackTrace();
			return null;
		}catch (SQLException e) {
			System.out.println("Ket noi that bai");
			e.printStackTrace();
			return null;
		}

	}
	public void disconnect()  {
		try {
			if(connection!=null)
				connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}	
	}
	
	
}
