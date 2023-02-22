package controller.publicc;

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
		int plcid = 0;
		try {
			plcid  = Integer.parseInt(request.getParameter("plcid"));
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/public/not-found");
			return;
		}	
		ArrayList<Songs> listSongByCat = dao.getItemsByIDCat(plcid);
		Categories objCat = catDao.getCatByID(plcid);
		if(objCat == null) {
			response.sendRedirect(request.getContextPath() + "/public/cats?error=1");
			return;
		}
		int totalByIDCat = dao.getTotalSongByIDCat(plcid);
		
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
		ArrayList<Songs> listSongByIDInPage = dao.pagingSongByID(plcid, offset);
		request.setAttribute("list", listSongByIDInPage);
		request.setAttribute("index", index);
		
		request.setAttribute("totalByIDCat", totalByIDCat);
		request.setAttribute("endPage", endPage);
		request.setAttribute("objCat", objCat);
		request.setAttribute("listSongByCat", listSongByCat);
		RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/public/cat.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}