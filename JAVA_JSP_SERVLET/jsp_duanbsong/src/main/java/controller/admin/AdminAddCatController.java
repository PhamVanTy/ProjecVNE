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

public class AdminAddCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminAddCatController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/addCat.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputName = request.getParameter("name");
		String name = "";
		if(AuthUtil.isName(inputName)) {
			name = inputName;
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/addCat.jsp?error=4");
			rd.forward(request, response);
			return;
		}
		CatergoriesDAO newCatDAO = new CatergoriesDAO();
		Categories objNewCat = new Categories(0, name);
		ArrayList<Categories> listC = newCatDAO.getItems();
		if(checkName(listC, name)) {
			newCatDAO.addItem(objNewCat);
			response.sendRedirect(request.getContextPath() + "/admin/cats?mes=1");
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/addCat.jsp?error=1");
			rd.forward(request, response);
		}
	}
	public boolean checkName(ArrayList<Categories> listC, String name) {
		for (Categories categories : listC) {
			if(categories.getCatName().equalsIgnoreCase(name)) {
				return false;
			}
		}
		return true;
	}
}
