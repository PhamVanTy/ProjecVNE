package controller.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.CatergoriesDAO;
import model.dao.SongsDAO;

public class AdminDeleteCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminDeleteCatController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dcid = Integer.parseInt(request.getParameter("dcid"));
		CatergoriesDAO dao = new CatergoriesDAO();
		dao.deleteCat(dcid);
		SongsDAO objS = new SongsDAO();
		objS.deleteSongByIDCat(dcid);
		response.sendRedirect(request.getContextPath() +"/admin/cats");
	}

}
