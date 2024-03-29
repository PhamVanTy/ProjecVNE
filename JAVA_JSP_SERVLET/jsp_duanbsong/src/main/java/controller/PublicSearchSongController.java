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
import util.DefineUtil;

public class PublicSearchSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SongsDAO dao;
    public PublicSearchSongController() {
        super();
        dao = new SongsDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name_search = request.getParameter("name_search");
			int total = dao.getTotalSearchByName(name_search);			
			int endPage = 0;
			endPage = (int) Math.ceil((float)total / DefineUtil.NUMBER_PER_PAGE);
			int index = 1;	
			try {
				index = Integer.parseInt(request.getParameter("index"));	
			} catch (NumberFormatException e) {
			}	
			int offset = (index - 1) * DefineUtil.NUMBER_PER_PAGE;
			ArrayList<Songs> list = dao.pagingSongByName(name_search, offset);
			request.setAttribute("listSearch", list); 
			request.setAttribute("totalSearch", total);
			request.setAttribute("endPageSearch", endPage);
			request.setAttribute("indexSearch", index);	
			request.setAttribute("name_search", name_search);	
			RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/public/indexSearch.jsp");
			rd.forward(request, response);
			return;
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/not-found");
			return;
		} 	
	}

}
