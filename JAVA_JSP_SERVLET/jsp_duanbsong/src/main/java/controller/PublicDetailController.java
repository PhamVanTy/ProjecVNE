package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Songs;
import model.dao.SongsDAO;

public class PublicDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SongsDAO dao;
    public PublicDetailController() {
        super();
        dao = new SongsDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try {
		 id =	Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/not-found");
			return;
		}
		if(id > 0) {
			dao.increaseCounter(id);
		}
	    Songs song = dao.getSongByID(id);
	    if(song == null) {
	    	response.sendRedirect(request.getContextPath() + "/not-found");
			return;
	    }
      	Songs objS = dao.getOtherSong(id);
      	request.setAttribute("objS", objS);
		request.setAttribute("song", song);
		RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/public/detail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
