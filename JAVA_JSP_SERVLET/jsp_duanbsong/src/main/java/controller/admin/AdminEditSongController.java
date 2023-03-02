package controller.admin;

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
public class AdminEditSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SongsDAO dao;
	private CatergoriesDAO catDao;
    public AdminEditSongController() {
        super();
        dao = new SongsDAO();
        catDao = new CatergoriesDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("sid"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath()+"/admin/songs?error=1");
			return;
		}	
		Songs song = dao.getSongByID(id);
		if(song == null) {
			response.sendRedirect(request.getContextPath()+"/admin/songs?error=1");
			return;
		}		
		ArrayList<Categories> listCat = catDao.getItems();
		request.setAttribute("listCat", listCat);
		request.setAttribute("objs", song);
		RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/editSong.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		int scategory = 0;
		try {
			id = Integer.parseInt(request.getParameter("sid"));
			scategory = Integer.parseInt(request.getParameter("category"));
			
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/songs?error=1");
			return;
		}	
		String checkBox = request.getParameter("checkbox");
//		System.out.println(checkBox);
		
		String sname = request.getParameter("name");
		String name = "";
		if(AuthUtil.isName(sname)) {
			name = sname;
		}else {
			CatergoriesDAO catDao = new CatergoriesDAO();
			ArrayList<Categories> listCat = catDao.getItems();
			request.setAttribute("listCat", listCat);
			RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/editSong.jsp?error=4");
			rd.forward(request, response);
			return;
		}
		
		String spreview = request.getParameter("preview");
		String sdetail = request.getParameter("detail");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(new Date());
		Part filePath = request.getPart("picture");
		//get dữ liệu cũ
		Songs song = dao.getSongByID(id);
		if(song == null) {
			response.sendRedirect(request.getContextPath()+"/admin/songs?error=1");
			return;
		}
	 	final String dirParthName = request.getServletContext().getRealPath("/GiaoDien/admin/assets/img");
	 	File dirtFile = new File(dirParthName);
		if(!dirtFile.exists()) {
			dirtFile.mkdirs();
		}
		
		String fileName = FileUtil.getName(filePath);
		String spicture = "";
		if(fileName.isEmpty()) {			
			if(song.getPicture() != null && "yes".equals(checkBox)) {
				String oldFilePathName = dirParthName + File.separator + song.getPicture();
				File oldFile = new File(oldFilePathName);
				if(oldFile.exists()) {
					oldFile.delete();
				}
			} else {
				spicture = song.getPicture();
			}
		}else {
			spicture = FileUtil.rename(fileName);
		}
		
		//đường dẫn file
		String filePathName = dirParthName + File.separator + spicture;
		Songs item = new Songs(id, name, spreview, sdetail, date, spicture, 0, scategory);
		if(dao.editItem(item) > 0) {
			if(!fileName.isEmpty()) {
				String oldFilePathName = dirParthName + File.separator + song.getPicture();
				File oldFile = new File(oldFilePathName);
				if(oldFile.exists()) {
					oldFile.delete();
				}
				//ghi file
				filePath.write(filePathName);
			}
			response.sendRedirect(request.getContextPath()+"/admin/songs?mes=2");
			return;
		}else {
			ArrayList<Categories> listCat = catDao.getItems();
			request.setAttribute("listCat", listCat);
			RequestDispatcher rd = request.getRequestDispatcher("/GiaoDien/admin/editSong.jsp?error=1");
			rd.forward(request, response);
			return;
		}	

	}

}
