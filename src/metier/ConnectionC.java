package metier;

import java.sql.*;

public class ConnectionC {
	
	//private static ConnectionC _instance = null;
	private Connection conn;
	
	public ConnectionC(String baseName) {
		try {
			System.out.println("--------------------CONNECTION EN COURS---------------------");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/"+baseName, "root", "");
			System.out.println("--------------------CONNECTÉ A LA BASE DE DONNÉE---------------------");
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
			System.out.println("-----------CONNECTION TERMINÉE, instance = null");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	*/
	
	
	
}