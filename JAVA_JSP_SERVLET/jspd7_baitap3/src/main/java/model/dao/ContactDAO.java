package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import library.ConnectDBLibrary;
import model.bean.Contact;

public class ContactDAO {
	private Connection conn;
	private ConnectDBLibrary connectDBLibrary;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;
	
	public ContactDAO() {
		connectDBLibrary = new ConnectDBLibrary();
	}

	public int addItem(Contact objContact) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "INSERT INTO contact (name,email,phone,content) VALUES (?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,objContact.getName());
			pst.setString(2,objContact.getEmail());
			pst.setInt(3,objContact.getPhone());
			pst.setString(4,objContact.getContent());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
}
