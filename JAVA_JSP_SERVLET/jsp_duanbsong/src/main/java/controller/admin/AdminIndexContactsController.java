package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Contacts;
import model.dao.ContactsDAO;
import util.AuthUtil;

public class AdminIndexContactsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminIndexContactsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		ContactsDAO dao = new ContactsDAO();
		ArrayList<Contacts> listContacts = dao.getContacts();
		request.setAttribute("listContacts", listContacts);
		RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/contact/indexContacts.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
