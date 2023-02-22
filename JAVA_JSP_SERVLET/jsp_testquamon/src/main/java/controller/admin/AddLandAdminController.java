package controller.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Lands;
import model.dao.LandsDAO;
import util.FileUtil;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
@MultipartConfig
public class AddLandAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddLandAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int msg = 0;
		LandsDAO objLand = new LandsDAO();
		String name = request.getParameter("namebds");
		String address = request.getParameter("addressbds"); 
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = df.format(new Date());
		String fileName = FileUtil.upload("picture", request);	
		int area = Integer.parseInt(request.getParameter("area"));
		String detail = request.getParameter("detail");
		int cid = Integer.parseInt(request.getParameter("choice"));
		Lands land = new Lands(0, name, detail, date, cid, fileName, area, address, 0);
		if(objLand.addLand(land) > 0) {
			msg = 1;
			request.setAttribute("msg", msg);
		} else {
			msg = 2;
			request.setAttribute("msg", msg);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/admin/add.jsp");
		rd.forward(request, response);
	}
	
}
