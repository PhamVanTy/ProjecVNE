package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Contacts;
import util.DBConnectionUtil;

public class ContactsDAO {
	private Connection conn;
	private DBConnectionUtil dbConnectionUtil;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	public ContactsDAO() {
		dbConnectionUtil = new DBConnectionUtil();
	}
	public ArrayList<Contacts> getContacts(){
		ArrayList<Contacts> listContacts = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT * FROM contacts ORDER BY id DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Contacts contact = new Contacts(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("website"), rs.getString("message"));
				listContacts.add(contact);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listContacts;
	}
	public void addContact(Contacts obj) {

		conn = dbConnectionUtil.getConnection();
		String sql = "INSERT INTO contacts (id, name, email, website, message) VALUES (?, ?, ?, ?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, obj.getIdContact());
			pst.setString(2, obj.getContactName());
			pst.setString(3, obj.getEmail());
			pst.setString(4, obj.getWebsite());
			pst.setString(5, obj.getMessage());
			pst.executeUpdate();
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
	}
	public Contacts getContactByID(int id) {
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT * FROM contacts WHERE id="+id;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				return new Contacts(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("website"), rs.getString("message"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public int editContact(Contacts obj) {
		int result = 0;
		conn = dbConnectionUtil.getConnection();
		String sql = "UPDATE contacts SET name=?, email=?, website=?, message=? WHERE id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, obj.getContactName());
			pst.setString(2, obj.getEmail());
			pst.setString(3, obj.getWebsite());
			pst.setString(4, obj.getMessage());
			pst.setInt(5, obj.getIdContact());
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
	public void delContact(int did) {
		conn = dbConnectionUtil.getConnection();
		String sql = "DELETE FROM contacts WHERE id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, did);
			pst.executeUpdate();
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
		
	}
	
}
