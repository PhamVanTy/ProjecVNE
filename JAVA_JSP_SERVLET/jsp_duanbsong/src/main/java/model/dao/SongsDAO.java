package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import model.bean.Songs;
import util.DBConnectionUtil;
import util.DefineUtil;

public class SongsDAO {
	private Connection conn;
	private DBConnectionUtil dbConnectionUtil;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public SongsDAO() {
		dbConnectionUtil = new DBConnectionUtil();
	}

	public ArrayList<Songs> getItems() {
		ArrayList<Songs> listSong = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT * FROM songs ORDER BY id DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Songs songs = new Songs(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getString("date_create"), rs.getString("picture"),
						rs.getInt("counter"), rs.getInt("cat_id"));
				listSong.add(songs);
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
		return listSong;
	}

	public ArrayList<Songs> getItemsByIDCat(int plcid) {
		ArrayList<Songs> listSong = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT * FROM songs WHERE cat_id=" + plcid;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Songs songs = new Songs(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getString("date_create"), rs.getString("picture"),
						rs.getInt("counter"), rs.getInt("cat_id"));
				listSong.add(songs);
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
		return listSong;
	}

	public ArrayList<Songs> getNewItems() {
		ArrayList<Songs> listSong = new ArrayList<>();
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT * FROM songs ORDER BY id DESC limit 4";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Songs songs = new Songs(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getString("date_create"), rs.getString("picture"),
						rs.getInt("counter"), rs.getInt("cat_id"));
				listSong.add(songs);
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
		return listSong;
	}

	public void addSong(Songs song) {	
		conn = dbConnectionUtil.getConnection();
		String sql = "INSERT INTO songs (id, name, preview_text, detail_text, date_create, picture, counter, cat_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, song.getIdSong());
			pst.setString(2, song.getSongName());
			pst.setString(3, song.getPreview_text());
			pst.setString(4, song.getDetail_text());
			pst.setString(5, song.getDate_create());
			pst.setString(6, song.getPicture());
			pst.setInt(7, song.getCounter());
			pst.setInt(8, song.getId_cat());
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

	public Songs getSongByID(int sid) {
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT * FROM songs WHERE id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, sid);
			rs = pst.executeQuery();
			while (rs.next()) {
				return new Songs(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getString("date_create"), rs.getString("picture"),
						rs.getInt("counter"), rs.getInt("cat_id"));
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

	public int editItem(Songs song) {
		int result = 0;
		conn = dbConnectionUtil.getConnection();
		String sql = "UPDATE songs SET name=?,preview_text=?,detail_text=?,picture=?,cat_id=? WHERE id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, song.getSongName());
			pst.setString(2, song.getPreview_text());
			pst.setString(3, song.getDetail_text());
			pst.setString(4, song.getPicture());
			pst.setInt(5, song.getId_cat());
			pst.setInt(6, song.getIdSong());
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

	public int deleteSong(int sid) {
		int result = 0;
		conn = dbConnectionUtil.getConnection();
		String sql = "DELETE FROM songs WHERE id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, sid);
			result = pst.executeUpdate();
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
		return result;
	}

	public void deleteSongByIDCat(int id) {
		conn = dbConnectionUtil.getConnection();
		String sql = "DELETE FROM songs WHERE cat_id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
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

	public Songs getOtherSong(int dtId) {
		ArrayList<Songs> listSongs = getItems();
		ArrayList<Songs> listOther = new ArrayList<>();
		Random rd = new Random();
		for (Songs songs : listSongs) {
			if (songs.getIdSong() != dtId) {
				listOther.add(songs);
			}
		}
		int n1 = rd.nextInt(listOther.size());
		return listOther.get(n1);
	}

	public int getTotalSong() {
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT COUNT(*) total FROM songs";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt("total");
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
		return 0;
	}
	
	public int getTotalSongByIDCat(int idCat) {
		conn = dbConnectionUtil.getConnection();
		String sql = "SELECT COUNT(*) FROM songs WHERE cat_id="+idCat;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				return rs.getInt(1);
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
		return 0;
	}
	
	public ArrayList<Songs> pagingSong(int offset) {
		ArrayList<Songs> list = new ArrayList<>();
		String sql = "SELECT * FROM songs ORDER BY id DESC LIMIT ?, ?";
		conn = dbConnectionUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Songs(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getString("date_create"), rs.getString("picture"),
						rs.getInt("counter"), rs.getInt("cat_id")));
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
		return list;
	}
	
	public ArrayList<Songs> pagingSongByID(int id, int offset) {
		ArrayList<Songs> list = new ArrayList<>();
		String sql = "SELECT * FROM songs WHERE cat_id=? LIMIT ?,?";
		conn = dbConnectionUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setInt(2, offset);
			pst.setInt(3, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Songs(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getString("date_create"), rs.getString("picture"),
						rs.getInt("counter"), rs.getInt("cat_id")));
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
		return list;
	}
	
	public ArrayList<Songs> searchByName(String name) {
		ArrayList<Songs> list = new ArrayList<>();
		String sql = "SELECT * FROM `songs` WHERE name LIKE ?";
		conn = dbConnectionUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, "%" + name + "%");
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Songs(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getString("date_create"), rs.getString("picture"),
						rs.getInt("counter"), rs.getInt("cat_id")));
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
		return list;
	}
	
	public void increaseCounter(int id) {
		String sql = "UPDATE songs SET counter=(counter + 1) WHERE id=?";
		conn = dbConnectionUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
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

	public int getTotalSearchByName(String nameSearch) {
		String sql = "SELECT COUNT(*) totalByName FROM songs WHERE name LIKE ?";
		conn = dbConnectionUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, "%" + nameSearch + "%");
			rs = pst.executeQuery();
			while(rs.next()) {
				return rs.getInt("totalByName");
			}
		} catch (Exception e) {
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
		return 0;
	}
	
	public ArrayList<Songs> pagingSongByName(String name, int offset){
		ArrayList<Songs> list = new ArrayList<>();
		String sql = "SELECT * FROM songs WHERE name LIKE ? ORDER BY id DESC LIMIT ?, ?";
		conn = dbConnectionUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, "%" + name + "%");
			pst.setInt(2, offset);
			pst.setInt(3, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Songs(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getString("date_create"), rs.getString("picture"),
						rs.getInt("counter"), rs.getInt("cat_id")));
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
		return list;		
	}
	
	public static void main(String[] args) {
//		SongsDAO dao = new SongsDAO();
//		ArrayList<Songs> list = dao.pagingSongByID(4, 3);
//		for (Songs songs : list) {
//			
//			System.out.println(songs);
//		}
//		int count = dao.getTotalSearchByName("tìm");
//		System.out.println(count);
	}
}
