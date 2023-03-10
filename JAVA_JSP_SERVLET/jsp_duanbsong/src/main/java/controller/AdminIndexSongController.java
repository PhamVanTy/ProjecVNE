package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Songs;
import model.dao.SongsDAO;
import util.AuthUtil;
import util.DefineUtil;

public class AdminIndexSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SongsDAO songDao;
    public AdminIndexSongController() {
        super();
        songDao = new SongsDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		int total = songDao.getTotalSong();
		int endPage =(int) Math.ceil((float)total / DefineUtil.NUMBER_PER_PAGE);
		
		int index = 1;	
		try {
			index = Integer.parseInt(request.getParameter("index"));	
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
		if(index > endPage || index < 1) {
			index = 1;
		}
		int offset = (index - 1) * DefineUtil.NUMBER_PER_PAGE;
		
		ArrayList<Songs> list = songDao.pagingSong(offset);	
		request.setAttribute("total", total);
		request.setAttribute("endPage", endPage);
		request.setAttribute("list", list);
		request.setAttribute("index", index);
		RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/song/indexSong.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
