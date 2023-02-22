package controller.cland;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Lands;
import model.dao.LandsDAO;

import java.io.IOException;
import java.util.ArrayList;

public class IndexCatPublicController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public IndexCatPublicController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid = Integer.parseInt(request.getParameter("cid"));
		
		LandsDAO listLandsDAO = new LandsDAO();
		ArrayList<Lands> listObjLand = listLandsDAO.getItemsByID(cid);
		request.setAttribute("listObjLand", listObjLand);
		RequestDispatcher rd = request.getRequestDispatcher("/cland/cat.jsp");
		rd.forward(request, response);
	}

}
