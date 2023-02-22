package baitapluyen.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

public class UpdateComputer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Computer> list = new ArrayList<>();
    public UpdateComputer() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		list = (ArrayList<Computer>)session.getAttribute("list");
		if(request.getParameter("id_u")!=null) {
			int id = Integer.parseInt(request.getParameter("id_u"));
			session.setAttribute("id", id);
			for (Computer item : list) {
				if(id == item.getId()) {
					request.setAttribute("item", item);
					RequestDispatcher rd = request.getRequestDispatcher("/baitapluyen/UpdateList.jsp");
					rd.forward(request, response);
				}
			}
		}
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		list = (ArrayList<Computer>)session.getAttribute("list");
		int id = (Integer)session.getAttribute("id");
		if(request.getParameter("id_update") != null && request.getParameter("name_update") !=  null && request.getParameter("price_update") != null) {
			int id_new = Integer.parseInt(request.getParameter("id_update"));
			String name_new = request.getParameter("name_update");
			float price_new = Float.parseFloat(request.getParameter("price_update"));
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getId() == id) {
					list.get(i).setId(id_new);
					list.get(i).setName(name_new);
					list.get(i).setPrice(price_new);					
				}
			}
			session.setAttribute("list", list);
			response.sendRedirect(request.getContextPath()+"/baitapluyen/ShowList.jsp");
			
		}
		
	}

}
