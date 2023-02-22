package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.DanhMucTin;
import model.bean.TinTuc;
import model.dao.CatDAO;
import model.dao.NewsDAO;

import java.io.IOException;
import java.util.ArrayList;

public class IndexCatPublicController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public IndexCatPublicController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CatDAO catDAO = new CatDAO();
		NewsDAO newsDAO = new NewsDAO();
//		request.setAttribute("listCat", catDAO.getItems());
		int idDMT = Integer.parseInt(request.getParameter("cid"));
		ArrayList<TinTuc> listTTByID = newsDAO.getItemsByID(idDMT);
		request.setAttribute("listTTByID", listTTByID);
		DanhMucTin objDMT = catDAO.getItem(idDMT);
		request.setAttribute("objDMT", objDMT);
		RequestDispatcher rd = request.getRequestDispatcher("/cat.jsp");
		rd.forward(request, response);
	}

}
