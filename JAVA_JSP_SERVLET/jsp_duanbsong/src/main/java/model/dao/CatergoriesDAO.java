package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Categories;
import util.DBConnectionUtil;

public class CatergoriesDAO {
	private Connection conn;
	private DBConnectionUtil dbConnectionUtil;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	public CatergoriesDAO() {
		dbConnectionUtil = new DBConnectionUtil();
	}
	public ArrayList<Categories> getItems() {
		ArrayList<Categories> cat = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT * FROM categories ORDER BY id DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Categories cattes = new Categories(rs.getInt("id"), rs.getString("name"));
				cat.add(cattes);
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
		return cat;
	}
	public void addItem(Categories objNewCat) {
		conn = dbConnectionUtil.getConnection();
		String sql = "INSERT INTO categories (id, name) VALUES (?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, objNewCat.getIdCat());
			pst.setString(2, objNewCat.getCatName());
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
	public int editItem(Categories objCatEdit) {
		int result = 0;
		conn = dbConnectionUtil.getConnection();
		String sql = "UPDATE categories SET name=? WHERE id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objCatEdit.getCatName());
			pst.setInt(2, objCatEdit.getIdCat());
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
	public Categories getCatByID(int cid) {
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT * FROM categories WHERE id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, cid);
			rs =pst.executeQuery();
			while(rs.next()) {
				return new Categories(rs.getInt("id"), rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void deleteCat(int dcid) {
		conn = dbConnectionUtil.getConnection();
		String sql = "DELETE FROM categories WHERE id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, dcid);
			pst.executeUpdate();
		} catch (Exception e) {
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
