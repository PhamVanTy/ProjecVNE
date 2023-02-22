package controller.publicc;

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
		int dtId = 0;
		try {
		 dtId =	Integer.parseInt(request.getParameter("dtid"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/public/not-found");
			return;
		}
		if(dtId > 0) {
			dao.increaseCounter(dtId);
		}
	    Songs song = dao.getSongByID(dtId);	    
      	Songs objS = dao.getOtherSong(dtId);
      	request.setAttribute("objS", objS);
		request.setAttribute("song", song);
		RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/public/detail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
