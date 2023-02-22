package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import library.ConnectDBLibrary;
import model.bean.Lands;

public class LandsDAO {
	private ConnectDBLibrary connectDBLibrary;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	public LandsDAO() {
		connectDBLibrary = new ConnectDBLibrary();
	}
	public ArrayList<Lands> getItemsLands(){
		ArrayList<Lands> listLands = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM lands ORDER BY lid DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Lands land = new Lands(rs.getInt("lid"), rs.getString("lname"), rs.getString("description"), rs.getString("date_create"), rs.getInt("cid"), rs.getString("picture"), rs.getInt("area"), rs.getString("address"), rs.getInt("count_views"));
				listLands.add(land);
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
		return listLands;
	}
	
	public ArrayList<Lands> getItemsByID(int cid){
		ArrayList<Lands> listItemByID = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM lands WHERE cid=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, cid);
			rs = pst.executeQuery();
			while(rs.next()) {
				Lands obj = new Lands(rs.getInt("lid"), rs.getString("lname"), rs.getString("description"), rs.getString("date_create"), rs.getInt("cid"), rs.getString("picture"), rs.getInt("area"), rs.getString("address"), rs.getInt("count_views"));
				listItemByID.add(obj);
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
		return listItemByID;
	}
	
	public ArrayList<Lands> get3ItemsNewLand(){
		ArrayList<Lands> listLands = new ArrayList<>();
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM lands ORDER BY lid DESC LIMIT 3";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Lands land = new Lands(rs.getInt("lid"), rs.getString("lname"), rs.getString("description"), rs.getString("date_create"), rs.getInt("cid"), rs.getString("picture"), rs.getInt("area"), rs.getString("address"), rs.getInt("count_views"));
				listLands.add(land);
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
		return listLands;
	}
	
	public Lands getItemByDID(int did) {
		Lands objDAO = null;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "SELECT * FROM lands WHERE lid=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, did);
			rs = pst.executeQuery();
			if(rs.next()) {
				objDAO = new Lands(rs.getInt("lid"), rs.getString("lname"), rs.getString("description"), rs.getString("date_create"), rs.getInt("cid"), rs.getString("picture"), rs.getInt("area"), rs.getString("address"), rs.getInt("count_views"));
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
		return objDAO;
	}
	
	public ArrayList<Lands> get3Items(int did){
		ArrayList<Lands> list3Lands = new ArrayList<>();
		ArrayList<Lands> listAllLands = getItemsLands();
		ArrayList<Lands> listOLD = new ArrayList<>();
		Random rd = new Random();
		for (Lands lands : listAllLands) {
			if(lands.getlId() != did) {
				listOLD.add(lands);
			}
		}
		int n1 = 0;
		int n2 = 0;
		int n3 = 0;
		int[] arr = new int[3];
		boolean flag = true;
		do {
			n1 = rd.nextInt(listOLD.size());
			n2 = rd.nextInt(listOLD.size());
			n3 = rd.nextInt(listOLD.size());
			if(n1 != n2 && n1 != n3 && n2 != n3) {
				arr[0] = n1;
				arr[1] = n2;
				arr[2] = n3;
				for (Lands land1 : listOLD) {
					if(listOLD.indexOf(land1) == arr[0]) {
						list3Lands.add(land1);
					}
				}
				for (Lands land2 : listOLD) {
					if(listOLD.indexOf(land2) == arr[1]) {
						list3Lands.add(land2);
					}
				}
				for (Lands land2 : listOLD) {
					if(listOLD.indexOf(land2) == arr[2]) {
						list3Lands.add(land2);
					}
				}
				flag = false;
			}else {
				flag = true;
			}
		}while(flag);
		return list3Lands;
	}
	public int addLand(Lands land) {
		int result = 0;
		conn = connectDBLibrary.getConnectMySQL();
		String sql = "INSERT INTO lands(lname, description, date_create, cid, picture, area, address, count_views) VALUES (?,?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, land.getlName());
			pst.setString(2, land.getDescript());
			pst.setString(3, land.getDate_create());
			pst.setInt(4, land.getcId());
			pst.setString(5, land.getPicture());
			pst.setInt(6, land.getArea());
			pst.setString(7, land.getAddress());
			pst.setInt(8, land.getCount());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
