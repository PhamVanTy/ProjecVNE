package controller.admin;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Contacts;
import model.dao.ContactsDAO;
import util.AuthUtil;

public class AdminEditContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContactsDAO dao;
    public AdminEditContactController() {
        super();
        dao = new ContactsDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/contacts?error=1");
			return;
		}
		Contacts objContact = dao.getContactByID(id);
		if(objContact == null) {
			response.sendRedirect(request.getContextPath() + "/admin/contacts?error=1");
			return;
		}
		request.setAttribute("objContact", objContact);
		RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/contact/editContact.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/contacts?error=1");
			return;
		}
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String website = request.getParameter("website");
		String message = request.getParameter("message");
		Contacts objContact = dao.getContactByID(id);
		if(objContact == null) {
			response.sendRedirect(request.getContextPath() + "/admin/contacts?error=1");
			return;
		}
		Contacts contact = new Contacts(id, name, email, website, message);
		if(dao.editContact(contact) > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/contacts?mes=2");
			return;
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/contact/editContacts.jsp?error=1");
			rd.forward(request, response);
			return;
		}
	}

}
