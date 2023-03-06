package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Contact;
import model.dao.ContactDAO;

public class AddCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddCatController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("username") != null && request.getParameter("email") != null && request.getParameter("phone") != null && request.getParameter("mess") != null) {
			String name = request.getParameter("username");
			String email = request.getParameter("email");
			int phone = Integer.parseInt(request.getParameter("phone"));
			String mess = request.getParameter("mess");		
			Contact objContact = new Contact(name, email, phone, mess); 
			ContactDAO addContact = new ContactDAO();
			int msg = 0;
			if(addContact.addItem(objContact) > 0) {
				msg = 1;
				request.setAttribute("msg", msg);
			}else {
				msg = 2;
				request.setAttribute("msg", msg);
			}
			RequestDispatcher rd = request.getRequestDispatcher("/lien-he.jsp");
			rd.forward(request, response);
		}
		
	
	}

}
