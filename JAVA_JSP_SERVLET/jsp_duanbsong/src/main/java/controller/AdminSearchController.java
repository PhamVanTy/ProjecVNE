package controller;

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
import util.DefineUtil;

public class AdminSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SongsDAO dao;
    public AdminSearchController() {
        super();
        dao = new SongsDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String nameSearch = request.getParameter("search");
		int total = dao.getTotalSearchByName(nameSearch);			
		int endPage = 0;
		endPage = (int) Math.ceil((float)total / DefineUtil.NUMBER_PER_PAGE);
		int index = 1;	
		try {
			index = Integer.parseInt(request.getParameter("indexSearch"));	
		} catch (NumberFormatException e) {
		}	
		int offset = (index - 1) * DefineUtil.NUMBER_PER_PAGE;
		ArrayList<Songs> list = dao.pagingSongByName(nameSearch, offset);
		request.setAttribute("listSearch", list); 
		request.setAttribute("totalSearch", total);
		request.setAttribute("endPageSearch", endPage);
		request.setAttribute("indexSearch", index);	
		request.setAttribute("nameSearch", nameSearch);
		RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/song/indexSongSearch.jsp");
		rd.forward(request, response);
	}

}
