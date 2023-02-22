package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.TinTuc;
import model.dao.NewsDAO;

import java.io.IOException;

public class DetailPublicController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DetailPublicController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idNews = Integer.parseInt(request.getParameter("did"));
		NewsDAO newsDAO = new NewsDAO();
		TinTuc objTT = newsDAO.getItem(idNews);
		request.setAttribute("objTT", objTT);
		RequestDispatcher rd = request.getRequestDispatcher("/detail.jsp");
		rd.forward(request, response);
	}

}
