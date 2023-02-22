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

public class DetailCatPublicController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DetailCatPublicController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int did = Integer.parseInt(request.getParameter("did"));
		LandsDAO objDAO = new LandsDAO();
		Lands objLand = objDAO.getItemByDID(did);
		request.setAttribute("objLand", objLand);
		ArrayList<Lands> list3Land = objDAO.get3Items(did);
		request.setAttribute("list3Land", list3Land);
		RequestDispatcher rd = request.getRequestDispatcher("/cland/single.jsp");
		rd.forward(request, response);
	}

}
