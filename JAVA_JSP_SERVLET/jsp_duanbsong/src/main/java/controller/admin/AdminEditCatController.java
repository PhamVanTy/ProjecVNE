package controller.admin;

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
	
    public AdminEditCatController() {
        super();
        // TODO Auto-generated constructor stub
        dao = new UsersDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		int cid = 0;
		try {
			cid = Integer.parseInt(request.getParameter("cid"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/cats?error=1");
			return;
		}
		HttpSession session = request.getSession();
		Users userLogin = (Users) session.getAttribute("userLogin");
		if("admin".equals(dao.getUserByID(userLogin.getId_user()).getUsername())) {
			CatergoriesDAO dao = new CatergoriesDAO();
			Categories objCatEdit = dao.getCatByID(cid);
//			System.out.println(objCatEdit);
			request.setAttribute("objCatEdit", objCatEdit);
			RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/editCat.jsp");
			rd.forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/cats?error=3");
			return;
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid = 0;
		try {
			cid = Integer.parseInt(request.getParameter("cid"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/cats?error=1");
			return;
		}		
		HttpSession session = request.getSession();
		Users userLogin = (Users) session.getAttribute("userLogin");
		if("admin".equals(dao.getUserByID(userLogin.getId_user()).getUsername())) {
			String nameCat = request.getParameter("editCatName");
			Categories objCatEdit = new Categories(cid, nameCat);
			CatergoriesDAO editCatDAO = new CatergoriesDAO();
			if(editCatDAO.editItem(objCatEdit) > 0) {
				response.sendRedirect(request.getContextPath()+"/admin/cats?mes=2");
				return;
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/editCat.jsp?error=2");
				rd.forward(request, response);
				return;
			}	
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/cats?error=3");
			return;
		}
		
	}

}
