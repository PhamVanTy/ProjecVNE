package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Songs;
import model.dao.CatergoriesDAO;
import model.dao.SongsDAO;

public class AdminDeleteCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CatergoriesDAO catDao;
	private SongsDAO songDao;
    public AdminDeleteCatController() {
        super();
        catDao = new CatergoriesDAO();
        songDao = new SongsDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() +"/admin/cats?error=1");	
			return;
		}		
		if(catDao.deleteCat(id) > 0) {			
			ArrayList<Songs> listSongByIdCat = songDao.getItemsByIDCat(id);
			for (Songs song : listSongByIdCat) {
				final String dirPathName = request.getServletContext().getRealPath("/GiaoDien/admin/assets/img");
				String picture = song.getPicture();
				if(!picture.isEmpty()) {
					String filePathName = dirPathName + File.separator + picture;
					File file = new File(filePathName);
					if(file.exists()) {
						file.delete();
					}
				}	
			}
			songDao.deleteSongByIDCat(id);
			response.sendRedirect(request.getContextPath() +"/admin/cats?mes=3");
			return;
		}else {
			response.sendRedirect(request.getContextPath() + "/admin/cats?error=2");
			return;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
