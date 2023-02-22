package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import library.ConnectDBLibrary;
import model.bean.DanhMucTin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LayDuLieuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LayDuLieuController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnectDBLibrary connectDBLibrary = new ConnectDBLibrary();
		//kết nối sql
		Connection conn = connectDBLibrary.getConnectMySQL();
		//câu truy vấn
		String sql = "SELECT * FROM danhmuctin";
		ArrayList<DanhMucTin> listDMT = new ArrayList<>();
		Statement st = null;
		ResultSet rs;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int idDMT = rs.getInt("id_danhmuctin");
				String tenDMT = rs.getString("tendanhmuctin");
				DanhMucTin objDMT = new DanhMucTin(idDMT, tenDMT);	
				listDMT.add(objDMT);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
//				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("listDMT", listDMT);
		
		//lấy id và tên danh mục tin có idDMT = 3
		String sql2 = "SELECT * FROM danhmuctin WHERE id_danhmuctin=3";
		DanhMucTin dmt = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql2);
			if(rs.next()) {
				dmt = new DanhMucTin(rs.getInt("id_danhmuctin"), rs.getString("tendanhmuctin"));
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
		System.out.println("Đối tượng có id_DMT = 3: "+dmt.toString());
		
		RequestDispatcher rd = request.getRequestDispatcher("/test.jsp");
		rd.forward(request, response);

	}

}
