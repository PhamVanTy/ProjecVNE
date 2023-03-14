package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.Categories;
import model.bean.Users;
import model.dao.CatergoriesDAO;
import model.dao.UsersDAO;
import util.AuthUtil;

import java.io.IOException;

public class AdminEditCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersDAO dao;
	private CatergoriesDAO catDAO;
    public AdminEditCatController() {
        super();
        // TODO Auto-generated constructor stub
        dao = new UsersDAO();
        catDAO = new CatergoriesDAO();
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
			response.sendRedirect(request.getContextPath() + "/admin/cats?error=1");
			return;
		}
		HttpSession session = request.getSession();
		Users userLogin = (Users) session.getAttribute("userLogin");
		if("admin".equals(dao.getUserByID(userLogin.getId_user()).getUsername())) {
			
			Categories objCatEdit = catDAO.getCatByID(id);
			request.setAttribute("objCatEdit", objCatEdit);
			RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/cat/editCat.jsp");
			rd.forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/cats?error=3");
			return;
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/cats?error=1");
			return;
		}
		
		HttpSession session = request.getSession();
		Users userLogin = (Users) session.getAttribute("userLogin");
		if("admin".equals(dao.getUserByID(userLogin.getId_user()).getUsername())) {
			String inputName = request.getParameter("editCatName");
			String nameCat = "";
			if(AuthUtil.isName(inputName)) {
				nameCat = inputName;
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/cat/editCat.jsp?error=4");
				rd.forward(request, response);
				return;
			}
			
			Categories objCatEdit = new Categories(id, nameCat);
			if(catDAO.editItem(objCatEdit) > 0) {
				response.sendRedirect(request.getContextPath()+"/admin/cats?mes=2");
				return;
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/cat/editCat.jsp?error=1");
				rd.forward(request, response);
				return;
			}	
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/cats?error=3");
			return;
		}
		
	}

}
