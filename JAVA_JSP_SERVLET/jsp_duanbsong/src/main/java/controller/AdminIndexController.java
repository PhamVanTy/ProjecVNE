package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Categories;
import model.bean.Contacts;
import model.bean.Songs;
import model.bean.Users;
import model.dao.CatergoriesDAO;
import model.dao.ContactsDAO;
import model.dao.SongsDAO;
import model.dao.UsersDAO;
import util.AuthUtil;


public class AdminIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminIndexController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		CatergoriesDAO catergoriesDAO = new CatergoriesDAO();
		ArrayList<Categories> categories = catergoriesDAO.getItems();
		request.setAttribute("categories", categories);		
		SongsDAO songDao = new SongsDAO();
		ArrayList<Songs> listSong = songDao.getItems();
		request.setAttribute("listSong", listSong);
		UsersDAO userDao = new UsersDAO();
		ArrayList<Users> listUsers = userDao.getUsers();
		request.setAttribute("listUsers", listUsers);
		ContactsDAO contactsDao = new ContactsDAO();
		ArrayList<Contacts> listContacts = contactsDao.getContacts();
		request.setAttribute("listContacts", listContacts);
		RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);		
	}
}
