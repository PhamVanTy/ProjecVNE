package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import library.ConnectDBLibrary;
import model.bean.Contacts;

public class ContactDAO {
	private Connection conn;
	private ConnectDBLibrary connectDBLibrary;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	public ContactDAO() {
		connectDBLibrary = new ConnectDBLibrary();
	}
	public int addContact(Contacts objContact) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "INSERT INTO vnecontact (fullname, email, subject, content) VALUES (?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objContact.getFullName());
			pst.setString(2, objContact.getEmail());
			pst.setString(3, objContact.getSubject());
			pst.setString(4, objContact.getContent());
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
