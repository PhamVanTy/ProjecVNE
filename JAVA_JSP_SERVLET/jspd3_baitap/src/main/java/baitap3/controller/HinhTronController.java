package baitap3.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;

public class HinhTronController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public HinhTronController() {
        super();
        // TODO Auto-generated constructor stub
    }

    private static final DecimalFormat decfor = new DecimalFormat("0.00"); 
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("dienTich").trim() != "" && request.getParameter("banKinh").trim() == "") {
			double dienTich = Double.parseDouble(request.getParameter("dienTich"));
			double banKinh = Math.sqrt(dienTich / Math.PI);
			dienTich = Double.parseDouble(decfor.format(dienTich));
			banKinh = Double.parseDouble(decfor.format(banKinh));
			request.setAttribute("dientich1", dienTich);
			request.setAttribute("bankinh", banKinh);
			RequestDispatcher rd = request.getRequestDispatcher("baitap3/BaiTap3.jsp");
			rd.forward(request, response);
			return;
		} else {
			if (request.getParameter("dienTich").trim() == "" && request.getParameter("banKinh").trim() != "") {
				double banKinh = Double.parseDouble(request.getParameter("banKinh"));
				double dienTich = banKinh * banKinh * Math.PI;
				dienTich = Double.parseDouble(decfor.format(dienTich));
				banKinh = Double.parseDouble(decfor.format(banKinh));
				request.setAttribute("dientich", dienTich);
				request.setAttribute("bankinh1", banKinh);
				RequestDispatcher rd = request.getRequestDispatcher("baitap3/BaiTap3.jsp");
				rd.forward(request, response);
				return;
			} else {
				if (request.getParameter("dienTich").trim() == "" && request.getParameter("banKinh").trim() == "") {
					request.setAttribute("err", "c");
					RequestDispatcher rd = request.getRequestDispatcher("baitap3/BaiTap3.jsp");
					rd.forward(request, response);
					return;
				} else {
					if(request.getParameter("dienTich").trim() != "" && request.getParameter("banKinh").trim() != ""){
						request.setAttribute("err", "k");
						RequestDispatcher rd = request.getRequestDispatcher("baitap3/BaiTap3.jsp");
						rd.forward(request, response);
						return;
					}
				}
			}
		}
	}
}
