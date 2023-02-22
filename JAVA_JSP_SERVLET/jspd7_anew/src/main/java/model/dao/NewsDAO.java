package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectDBLibrary;
import model.bean.TinTuc;

public class NewsDAO {
	private Connection conn;
	private ConnectDBLibrary connectDBLibrary;
	private Statement st;
	private ResultSet rs;
	
	public NewsDAO() {
		connectDBLibrary = new ConnectDBLibrary();
	}
	
	public ArrayList<TinTuc> getItems() {
		ArrayList<TinTuc> listTT = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM tintuc ORDER BY id_tintuc DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				TinTuc objTT = new TinTuc(rs.getInt("id_tintuc"), rs.getString("tentintuc"), rs.getString("mota"));
				listTT.add(objTT);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return listTT;
	}

	public ArrayList<TinTuc> getItemsByID(int idDMT) {
		ArrayList<TinTuc> listTTByID = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM `tintuc` WHERE id_danhmuctin="+idDMT;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				TinTuc objTT = new TinTuc(rs.getInt("id_tintuc"), rs.getString("tentintuc"), rs.getString("mota"));
				listTTByID.add(objTT);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listTTByID;
	}

	public TinTuc getItem(int idNews) {
		TinTuc objTT = null;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM tintuc WHERE id_tintuc="+idNews;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				objTT = new TinTuc(rs.getInt("id_tintuc"), rs.getString("tentintuc"), rs.getString("mota"), rs.getString("chitiet"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return objTT;
	}
}
