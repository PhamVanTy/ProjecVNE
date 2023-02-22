package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Categories;
import model.dao.CatergoriesDAO;
import util.AuthUtil;

public class AdminIndexCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminIndexCatController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CatergoriesDAO catergoriesDAO = new CatergoriesDAO();
		ArrayList<Categories> categories = catergoriesDAO.getItems();
		request.setAttribute("categories", categories);
		RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/indexCat.jsp");
		rd.forward(request, response);
	}

}
