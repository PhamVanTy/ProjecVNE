package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDBLibrary {
	private Connection conn;
	private String url;
	private String user;
	private String pass;
	private String db;
	
	public ConnectDBLibrary() {
		this.db = "myfriends";
		this.url = "jdbc:mysql://localhost:3306/" +db+"?userUnicode=true&characterEncoding=UTF-8";
		this.user = "root";
		this.pass = "";
	}
	public Connection getConnectMySQL() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) {
		ConnectDBLibrary obj = new ConnectDBLibrary();
		System.out.println(obj.getConnectMySQL());
	}
}
