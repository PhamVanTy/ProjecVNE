package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.Users;
import model.dao.UsersDAO;
import util.AuthUtil;

public class AdminEditUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersDAO dao;
    public AdminEditUserController() {
        super();
        dao = new UsersDAO();
        // TODO Auto-generated constructor stub
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
			response.sendRedirect(request.getContextPath() + "/admin/users?error=1");
			return;
		}		
		
		HttpSession session = request.getSession();
		Users userLogin = (Users) session.getAttribute("userLogin");
		if("admin".equals(dao.getUserByID(userLogin.getId_user()).getUsername()) || id == userLogin.getId_user()) {
			Users user = dao.getUserByID(id);
			if(user == null) {
				response.sendRedirect(request.getContextPath() + "/admin/users?error=1");
				return;
			}
			request.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/user/editUser.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/admin/users?error=4");
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/users?error=1");
			return;
		}
		HttpSession session = request.getSession();
		Users userLogin = (Users) session.getAttribute("userLogin");
		if("admin".equals(dao.getUserByID(userLogin.getId_user()).getUsername()) || id == userLogin.getId_user()) {
			String username = request.getParameter("username");
			String password = request.getParameter("pass");
			
			String fullnameInput = request.getParameter("fullname");
			String fullName = "";
			if(AuthUtil.isName(fullnameInput)) {
				fullName = fullnameInput;
			}else {		
				response.sendRedirect(request.getContextPath() + "/admin/users?error=6");				
				return;
			}
			Users obj = dao.getUserByID(id);
			if(obj == null) {
				response.sendRedirect(request.getContextPath() + "/admin/users?error=1");
				return;
			}
			if(password.isEmpty()) {
				password = obj.getPassword();
			}
			Users user = new Users(id, username, password, fullName);
			if(dao.editUser(user) > 0) {
				response.sendRedirect(request.getContextPath() + "/admin/users?mes=2");
				return;
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/user/editUser.jsp?error=1");
				rd.forward(request, response);
				return;
			}
		}else {
			response.sendRedirect(request.getContextPath() + "/admin/users?error=4");
			return;
		}
		
	}

}
