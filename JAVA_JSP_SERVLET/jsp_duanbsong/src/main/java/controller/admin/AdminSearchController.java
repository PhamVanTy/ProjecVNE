package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Songs;
import model.dao.SongsDAO;
import util.AuthUtil;

public class AdminSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminSearchController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String nameSearch = request.getParameter("search");
		SongsDAO dao = new SongsDAO();
		ArrayList<Songs> list = dao.searchByName(nameSearch);
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/indexSongSearch.jsp");
		rd.forward(request, response);
	}

}
