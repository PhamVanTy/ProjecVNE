package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.Users;
import model.dao.UsersDAO;
import util.AuthUtil;

public class AuthLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersDAO dao;
	
    public AuthLoginController() {
        super();
        dao = new UsersDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/admin");
			return;
		}
		//B1: get user, pass trên cookie
		Cookie arr[] = request.getCookies();
		if(arr != null) {
			for (Cookie cookie : arr) {
				if(cookie.getName().equals("userC")) {
					request.setAttribute("username", cookie.getValue());
				}
				if(cookie.getName().equals("passC")) {
					request.setAttribute("password", cookie.getValue());
				}
			}
		}
		
		//B2: set user, pass vào form login
		RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/auth/login.jsp");
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Users user = dao.existUser(username, password);
		if(user != null) {	
			session.setAttribute("userLogin", user);
			//lưu cookie
			Cookie uk = new Cookie("userC", username);
			Cookie pk = new Cookie("passC", password);
			//set thời gian lưu cookie
			uk.setMaxAge(60);
			pk.setMaxAge(60);
			//luu uk và pk lên trình duyệt
			response.addCookie(pk);
			response.addCookie(uk);
			response.sendRedirect(request.getContextPath() + "/admin");
			return;
		}else {
			response.sendRedirect(request.getContextPath() + "/login?error=1");
			return;
		}
	}

}
