package controller.cland;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Categories;
import model.dao.CategoriesDAO;
import model.dao.LandsDAO;

import java.io.IOException;

public class IndexPublicController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public IndexPublicController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LandsDAO list3Land = new LandsDAO();
		request.setAttribute("list3Lands", list3Land.get3ItemsNewLand());
		RequestDispatcher rd = request.getRequestDispatcher("/cland/index.jsp");
		rd.forward(request, response);
	}

}
