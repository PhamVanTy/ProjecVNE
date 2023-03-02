package controller.publicc;

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

public class PublicContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContactsDAO dao;
    public PublicContactController() {
    	super();
    	dao = new ContactsDAO();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/public/contact.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inName = request.getParameter("name");
		String name = "";
		if(AuthUtil.isName(inName)) {
			name = inName;
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/public/contact.jsp?error=2");
			rd.forward(request, response);
			return;
		}
		String email = request.getParameter("email");
		String website = request.getParameter("website");
		String mess = request.getParameter("message");	
		Contacts obj = new Contacts(0, name, email, website, mess);		
		ArrayList<Contacts> listContacts = dao.getContacts();
		if(checkName(listContacts, name)) {
			dao.addContact(obj);
			response.sendRedirect(request.getContextPath() + "/publicc/contact?mes=1");
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/public/contact.jsp?error=1");
			rd.forward(request, response);
		}	
	}
	public boolean checkName(ArrayList<Contacts> listC, String name) {
		for (Contacts contacts : listC) {
			if(contacts.getContactName().equalsIgnoreCase(name)) {
				return false;
			}
		}
		return true;
	}
}
