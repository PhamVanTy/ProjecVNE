package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.FriendList;
import model.bean.Friends;
import model.dao.FriendListDAO;
import model.dao.FriendsDAO;

import java.io.IOException;
import java.util.ArrayList;

public class DetailPublicController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DetailPublicController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idFr = Integer.parseInt(request.getParameter("did"));
		int idCFr = Integer.parseInt(request.getParameter("id"));
		
		FriendsDAO frDao = new FriendsDAO();		
		FriendListDAO frlDao = new FriendListDAO();
		
		Friends objFr = frDao.getItemDID(idFr);
		
		FriendList objFrList = frlDao.getItemFRL(idCFr);
		
		ArrayList<Friends> list2FR = frDao.getItem(idFr);
		request.setAttribute("list2FR", list2FR);
		request.setAttribute("objFr", objFr);		
		request.setAttribute("objFrList", objFrList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/chi-tiet.jsp");
		rd.forward(request, response);
		
	}

}
