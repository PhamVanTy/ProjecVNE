package controller;

import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Categories;
import model.bean.Songs;
import model.dao.CatergoriesDAO;
import model.dao.SongsDAO;
import util.DefineUtil;

public class PublicIndexCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SongsDAO dao;
	private CatergoriesDAO catDao;
    public PublicIndexCatController() {
        super();
        catDao = new CatergoriesDAO();
        dao = new SongsDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try {
			id  = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/not-found");
			return;
		}	

		Categories objCat = catDao.getCatByID(id);
		if(objCat == null) {
			response.sendRedirect(request.getContextPath() + "/cats?error=1");
			return;
		}
		int totalByIDCat = dao.getTotalSongByIDCat(id);
		
		int endPage = (int) Math.ceil((float)totalByIDCat / DefineUtil.NUMBER_PER_PAGE);
		int index = 1;	
		try {
			index = Integer.parseInt(request.getParameter("index"));
		} catch (NumberFormatException e) {
			
		}
		if(index > endPage || index < 1) {
			index = 1;
		}
		int offset = (index - 1) * DefineUtil.NUMBER_PER_PAGE;
		ArrayList<Songs> listSongByIDInPage = dao.pagingSongByID(id, offset);		
		request.setAttribute("listSongByIDInPage", listSongByIDInPage);
		request.setAttribute("index", index);		
		request.setAttribute("totalByIDCat", totalByIDCat);
		request.setAttribute("endPage", endPage);
		request.setAttribute("objCat", objCat);
		RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/public/cat.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
