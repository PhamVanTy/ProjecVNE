package controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.bean.Categories;
import model.bean.Songs;
import model.dao.CatergoriesDAO;
import model.dao.SongsDAO;
import util.AuthUtil;
import util.FileUtil;
@MultipartConfig
public class AdminAddSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminAddSongController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		CatergoriesDAO catDao = new CatergoriesDAO();
		ArrayList<Categories> listCat = catDao.getItems();
		request.setAttribute("listCat", listCat);
		RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/song/addSong.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		int id = 0;
		try {
			 id = Integer.parseInt(request.getParameter("category"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/songs?error=1");	
			return;
		}
		String inputName = request.getParameter("name");
		String name = "";
//		String name = myName(inputName);
		if(AuthUtil.isName(inputName)) {
			name = inputName;
		}else {
			CatergoriesDAO catDao = new CatergoriesDAO();
			ArrayList<Categories> listCat = catDao.getItems();
			request.setAttribute("listCat", listCat);
			RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/song/addSong.jsp?error=4");
			rd.forward(request, response);
			return;
		}
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = df.format(new Date());
		String preview = request.getParameter("preview");
		String detail = request.getParameter("detail");
		Part filePath = request.getPart("picture");
		final String dirParthName = request.getServletContext().getRealPath("/GiaoDien/admin/song/assets/img");
		File dirtFile = new File(dirParthName);
		if(!dirtFile.exists()) {
			dirtFile.mkdirs();
		}
		String fileName = FileUtil.getName(filePath);
		String picture = FileUtil.rename(fileName);
		String filePathName = dirParthName + File.separator + picture;
		Songs song = new Songs(0, name, preview, detail, date, picture, 0, id);
		SongsDAO songDAO = new SongsDAO();
		ArrayList<Songs> listS = songDAO.getItems();
		if(AuthUtil.checkNameSong(listS, name)) {
			songDAO.addSong(song);
			if(!fileName.isEmpty()) {
				filePath.write(filePathName);
			}
			response.sendRedirect(request.getContextPath() + "/admin/songs?mes=1");
		}else {
			CatergoriesDAO catDao = new CatergoriesDAO();
			ArrayList<Categories> listCat = catDao.getItems();
			request.setAttribute("listCat", listCat);
			RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/song/addSong.jsp?error=1");
			rd.forward(request, response);
			return;
		}
	}
}

