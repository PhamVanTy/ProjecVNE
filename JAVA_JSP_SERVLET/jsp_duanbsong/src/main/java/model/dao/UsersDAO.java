package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Users;
import util.DBConnectionUtil;

public class UsersDAO {
	private Connection conn;
	private DBConnectionUtil dbConnectionUtil;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	public UsersDAO() {
		dbConnectionUtil = new DBConnectionUtil();
	}
	public ArrayList<Users> getUsers(){
		ArrayList<Users> listUser = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT * FROM users ORDER BY id DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Users user = new Users(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("fullname"));
				listUser.add(user);
			}
		} catch (Exception e) {
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
		return listUser;
	}
	public void delUser(int did) {
		conn = dbConnectionUtil.getConnection();
		String sql = "DELETE FROM users WHERE id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, did);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	public int editUser(Users user) {
		int result = 0;
		conn = dbConnectionUtil.getConnection();
		String sql = "UPDATE users SET username=?,password=?,fullname=? WHERE id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getFullname());
			pst.setInt(4, user.getId_user());
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
	public Users getUserByID(int id) {
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT * FROM users WHERE id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()) {
				return new Users(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("fullname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public void addUser(Users user) {		
		conn = dbConnectionUtil.getConnection();
		String sql = "INSERT INTO users (id, username, password, fullname) VALUES (?, ?, ?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, user.getId_user());
			pst.setString(2, user.getUsername());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getFullname());
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
	public Users existUser(String username, String password) {
		Users user = null;
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT * FROM users WHERE username=? AND password=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("id");
				String fullname = rs.getString("fullname");
				user = new Users(id, username, password, fullname);
			}
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
		return user;
	}
}
