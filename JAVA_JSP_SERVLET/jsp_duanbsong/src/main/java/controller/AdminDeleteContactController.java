package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.ContactsDAO;

public class AdminDeleteContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminDeleteContactController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int did = Integer.parseInt(request.getParameter("id"));
		ContactsDAO dao = new ContactsDAO();
		dao.delContact(did);
		response.sendRedirect(request.getContextPath() + "/admin/contacts");
	}

}
