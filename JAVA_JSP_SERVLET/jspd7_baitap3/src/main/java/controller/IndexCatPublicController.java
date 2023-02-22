package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.FriendList;
import model.bean.Friends;
import model.dao.FriendListDAO;
import model.dao.FriendsDAO;

import java.io.IOException;
import java.util.ArrayList;

public class IndexCatPublicController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public IndexCatPublicController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idListFR = Integer.parseInt(request.getParameter("cid"));
		FriendsDAO frsDAO = new FriendsDAO();
		FriendListDAO flsDAO = new FriendListDAO();
		ArrayList<Friends> frsListByID = frsDAO.getItemByID(idListFR);
		FriendList objFrList = flsDAO.getItemFRL(idListFR);
		request.setAttribute("frsListByID", frsListByID);
		request.setAttribute("objFrList", objFrList);
		RequestDispatcher rd = request.getRequestDispatcher("/danh-muc.jsp");
		rd.forward(request, response);
	}

}
