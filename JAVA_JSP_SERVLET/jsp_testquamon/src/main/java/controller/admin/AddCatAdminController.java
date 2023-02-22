package controller.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Categories;
import model.dao.CategoriesDAO;

import java.io.IOException;

public class AddCatAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddCatAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newCat = request.getParameter("typeName");
		CategoriesDAO objDAO = new CategoriesDAO();
		Categories cat = new Categories(newCat);
		int msg = 0;
		if(objDAO.getAddItem(cat) > 0) {
			msg = 1;
			request.setAttribute("msg", msg);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/admin/add_type_bds.jsp");
		rd.forward(request, response);
	}

}
