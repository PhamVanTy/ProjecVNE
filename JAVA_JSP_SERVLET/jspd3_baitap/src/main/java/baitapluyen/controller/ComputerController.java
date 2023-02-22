package baitapluyen.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

import java.io.IOException;
import java.util.ArrayList;

public class ComputerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Computer> list = new ArrayList<>();
    public ComputerController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		if(request.getParameter("id").trim() != "" && request.getParameter("name").trim() != "" && request.getParameter("price").trim() != "") {
			HttpSession session = request.getSession();
			boolean flag = true;
			int id = Integer.parseInt(request.getParameter("id"));
			String name = (String) request.getParameter("name");
			float price = Float.parseFloat(request.getParameter("price"));
			Computer obj =new Computer(name, id, price);
			if(list.size() > 0) {
				for (Computer computer : list) {
					if(checkID(list, id) && checkName(list, name) && computer.getPrice() > price) {
						computer.setPrice(computer.getPrice());
						flag = true;
						return;
					}else {
						if(checkName(list, name) && checkID(list, id) && computer.getPrice() < price) {
							computer.setPrice(price);
							flag = true;
							return;
						}else {
							if(checkID(list, id) && checkName(list, name) && computer.getPrice() == price) {
								response.sendRedirect(request.getContextPath()+"/show-list-computer?mes=2");
								return;
							}else {
								if(checkID(list, id) && checkName(list, name)) {
									response.sendRedirect(request.getContextPath() + "/show-list-computer?mes=3");
									return;
								}else {
									if(checkID(list, id) && checkName(list, name)== false) {
										response.sendRedirect(request.getContextPath() + "/show-list-computer?mes=4");
										return;
									}else {
										flag = false;
									}
								}
							}
						}
					}
				}
			}
			if(flag == false || list.size() == 0){
				list.add(obj);
			}
			session.setAttribute("list", list);
			response.sendRedirect(request.getContextPath()+"/baitapluyen/ShowList.jsp");
		}else {
			response.sendRedirect(request.getContextPath() + "/show-list-computer?mes=1");
		}
	}
	
	public boolean checkID(ArrayList<Computer> list, int id) {
		for (Computer computer : list) {
			if(computer.getId() == id) {
				return true;
			}
		}
		return false;
	}
	public boolean checkName(ArrayList<Computer> list, String name) {
		for (Computer computer : list) {
			if(computer.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
}
