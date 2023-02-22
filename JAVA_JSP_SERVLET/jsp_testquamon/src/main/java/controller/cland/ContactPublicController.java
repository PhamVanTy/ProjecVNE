package controller.cland;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Contacts;
import model.dao.ContactDAO;

import java.io.IOException;

public class ContactPublicController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ContactPublicController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int msg = 0;
		if(request.getParameter("name").trim() != "" && request.getParameter("email").trim() != "" && request.getParameter("content").trim() != "" && request.getParameter("text").trim() != "") {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String content = request.getParameter("content");
			String text = request.getParameter("text");
			Contacts obj = new Contacts(name, email, text, content);
			ContactDAO addContact = new ContactDAO();
			
			if(addContact.addContact(obj) > 0) {
				msg = 1;
				request.setAttribute("msg", msg);
			}else {
				msg = 2;
				request.setAttribute("msg", msg);
			}
		} else {
			msg = 3;
			request.setAttribute("msg", msg);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/cland/contact.jsp");
		rd.forward(request, response);
	}

}
