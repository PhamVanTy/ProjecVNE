package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.Users;
import model.dao.UsersDAO;
import util.AuthUtil;

public class AdminAddUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminAddUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		HttpSession session = request.getSession();
		Users userLogin = (Users) session.getAttribute("userLogin");
		if(!"admin".equals(userLogin.getUsername())) {
			//không được phép
			response.sendRedirect(request.getContextPath() + "/admin/users?error=3");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/addUser.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		HttpSession session = request.getSession();
		Users userLogin = (Users) session.getAttribute("userLogin");
		if(!"admin".equals(userLogin.getUsername())) {
			//không được phép
			response.sendRedirect(request.getContextPath() + "/admin/users?error=3");
			return;
		}
		String username = request.getParameter("name");
		String uName = "";
		if(AuthUtil.isName(username)) {
			uName = username;
		}else {
		
			RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/addUser.jsp?error=4");
			rd.forward(request, response);
			return;
		}
		String pass = request.getParameter("password");
		String fullnameInput = request.getParameter("fullname");
		String fullName = "";
		if(AuthUtil.isName(fullnameInput)) {
			fullName = username;
		}else {		
			RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/addUser.jsp?error=4");
			rd.forward(request, response);
			return;
		}
		UsersDAO dao = new UsersDAO();
		Users user = new Users(0, uName, pass, fullName);
		ArrayList<Users> listU = dao.getUsers();
		if(checkName(listU, username)) {
			dao.addUser(user);
			response.sendRedirect(request.getContextPath() + "/admin/users?mes=1");
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/addUser.jsp?error=1");
			rd.forward(request, response);
		}
	}
	public boolean checkName(ArrayList<Users> listC, String name) {
		for (Users user : listC) {
			if(user.getUsername().equalsIgnoreCase(name)) {
				return false;
			}
		}
		return true;
	}
}
