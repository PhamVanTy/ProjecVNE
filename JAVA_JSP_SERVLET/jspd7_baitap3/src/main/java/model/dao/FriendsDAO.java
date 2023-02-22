package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import library.ConnectDBLibrary;
import model.bean.Friends;

public class FriendsDAO {
	private Connection conn;
	private ConnectDBLibrary connectDBLibrary;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;
	public FriendsDAO() {
		connectDBLibrary = new ConnectDBLibrary();
	}
	public ArrayList<Friends> getItems(){
		ArrayList<Friends> listFr = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM friends";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Friends objFr = new Friends(rs.getInt("fid"), rs.getString("fname"), rs.getString("preview"), rs.getString("detail"), rs.getDate("date_create"), rs.getInt("count_number"), rs.getString("picture"), rs.getInt("fl_id"));
				listFr.add(objFr);
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
		return listFr;
	}
	public Friends getItemDID(int idFr) {
		Friends objFr = null;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM friends WHERE fid = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idFr);
			rs = pst.executeQuery();
			if(rs.next()) {
				objFr = new Friends(rs.getInt("fid"), rs.getString("fname"), rs.getString("preview"), rs.getString("detail"), rs.getDate("date_create"), rs.getInt("count_number"), rs.getString("picture"), rs.getInt("fl_id"));
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
		return objFr;
	}
	public ArrayList<Friends> getItemByID(int idListFR) {
		ArrayList<Friends> frsListByID = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM friends WHERE fl_id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idListFR);
			rs = pst.executeQuery();
			while(rs.next()) {
				Friends objFr = new Friends(rs.getInt("fid"), rs.getString("fname"), rs.getString("preview"), rs.getString("detail"), rs.getDate("date_create"), rs.getInt("count_number"), rs.getString("picture"), rs.getInt("fl_id"));
				frsListByID.add(objFr);
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
		return frsListByID;
	}
	public ArrayList<Friends> getItem(int idFr) {
		ArrayList<Friends> list2FR = new ArrayList<>();
		ArrayList<Friends> listFR = getItems();
		ArrayList<Friends> listFROld = new ArrayList<>();
		Random rd = new Random();
		for (Friends friends : listFR) {
			if(friends.getfID() != idFr) {
				listFROld.add(friends);
			}
		}
		int n1 = 0;
		int n2 = 0;
		int[] arr = new int[2];
		boolean flag = true;
		do {
			n1 = rd.nextInt(listFROld.size());
			n2 = rd.nextInt(listFROld.size());
			if(n1 != n2) {
				arr[0] = n1;
				arr[1] = n2;
				for (Friends friends1 : listFROld) {
					if(listFROld.indexOf(friends1) == arr[0]) {
						list2FR.add(friends1);
					}
				}
				for (Friends friends2 : listFROld) {
					if (listFROld.indexOf(friends2) == arr[1]) {
						list2FR.add(friends2);
					}
				}
				flag = false;
			}else {
				flag = true;
			}
		}while(flag);
		return list2FR;
	}
	
}
