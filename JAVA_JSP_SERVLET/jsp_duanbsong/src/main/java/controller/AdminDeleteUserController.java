package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.Users;
import model.dao.UsersDAO;

public class AdminDeleteUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersDAO dao;
    public AdminDeleteUserController() {
        super();
        // TODO Auto-generated constructor stub
        dao = new UsersDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/users?error=1");
			return;
		}
		HttpSession session = request.getSession();
		Users userLogin = (Users) session.getAttribute("userLogin");
		Users user = dao.getUserByID(id);
		if("admin".equals(user.getUsername())) {
			response.sendRedirect(request.getContextPath() + "/admin/users?error=5");
			return;
		} else {
			if("admin".equals(userLogin.getUsername())) {
				dao.delUser(id);
				response.sendRedirect(request.getContextPath() + "/admin/users");
			}else {
				response.sendRedirect(request.getContextPath() + "/admin/users?error=5");
				return;
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
