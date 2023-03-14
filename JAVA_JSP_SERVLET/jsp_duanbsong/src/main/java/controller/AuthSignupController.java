package controller;

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

public class AuthSignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UsersDAO dao;
   
    public AuthSignupController() {
        super();
        dao = new UsersDAO();
    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if(AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/admin");
			return;
		}
    	RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/auth/signup.jsp");
		rd.forward(request, response);
	}
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Users userLogin = (Users) session.getAttribute("userLogin");
		if(userLogin != null) {
			response.sendRedirect(request.getContextPath() + "/admin");
			return;
		}
    	String userSignup = request.getParameter("username");
    	String passSignup = request.getParameter("password");
    	String fullnameSignup = request.getParameter("fullname");
    	Users user = new Users(0, userSignup, passSignup, fullnameSignup);
    	ArrayList<Users> list = dao.getUsers();
    	if(checkName(list, userSignup)) {
    		dao.addUser(user);
    		response.sendRedirect(request.getContextPath() + "/login?mes=1");
    		return;
    	}else {
    		RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/auth/signup.jsp?error=1");
    		rd.forward(request, response);
    		return;
    	}
	}

    public boolean checkName(ArrayList<Users> list, String name) {
    	for (Users users : list) {
			if(users.getUsername().equalsIgnoreCase(name)) {
				return false;
			}
		}
    	return true;
    }
}
