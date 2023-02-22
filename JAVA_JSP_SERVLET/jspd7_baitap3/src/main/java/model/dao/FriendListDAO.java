package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectDBLibrary;
import model.bean.FriendList;
import model.bean.Friends;

public class FriendListDAO {
	private Connection conn;
	private ConnectDBLibrary connectDBLibrary;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;
	public FriendListDAO() {
		connectDBLibrary = new ConnectDBLibrary();
	}
	public ArrayList<FriendList> getItems(){
		ArrayList<FriendList> listFriend = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM friend_list";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				FriendList objListFr = new FriendList(rs.getInt("fl_id"), rs.getString("fl_name"));
				listFriend.add(objListFr);
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
		return listFriend;
	}
	public FriendList getItemFRL(int idListFR) {
		FriendList objFrList = null;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM friend_list WHERE fl_id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idListFR);
			rs = pst.executeQuery();
			if(rs.next()) {
				objFrList = new FriendList(rs.getInt("fl_id"), rs.getString("fl_name"));
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
		return objFrList;
	}
	
		
}
