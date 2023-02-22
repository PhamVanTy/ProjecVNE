package baitapluyen.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

public class DeleteComputer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Computer> list = new ArrayList<>();
 
    public DeleteComputer() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		list = (ArrayList<Computer>)session.getAttribute("list");
		int id = Integer.parseInt(request.getParameter("id"));
		for (int i = 0; i < list.size(); i++) {
			if(id == list.get(i).getId()) {
				list.remove(i);
			}
		}
		session.setAttribute("list", list);
		response.sendRedirect(request.getContextPath() + "/baitapluyen/ShowList.jsp");
	}
}
