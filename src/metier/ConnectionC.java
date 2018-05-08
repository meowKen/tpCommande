package metier;

import java.sql.*;

public class ConnectionC {
	
	//private static ConnectionC _instance = null;
	private Connection conn;
	
	public ConnectionC(String baseName) {
		try {
			System.out.println("--------------------CONNECTION EN COURS---------------------");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/"+baseName, "root", "");
			System.out.println("--------------------CONNECT� A LA BASE DE DONN�E---------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	
	/*
	public static ConnectionC getInstance(String baseName) {
		if(_instance == null) {
			_instance = new ConnectionC(baseName);
		}
		return _instance;
	}
	
	public void close() {
		try {
			this.conn.close();
			_instance = null;
			System.out.println("-----------CONNECTION TERMIN�E, instance = null");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	*/
	
	
	
}