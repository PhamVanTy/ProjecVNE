package baitap4.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ThayTheVanBanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ThayTheVanBanController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		String vbGoc = request.getParameter("vbGoc");
		String[] arvbGoc = vbGoc.split(" ");
		String tuGoc = request.getParameter("tuGoc");
		String tuThayThe = request.getParameter("tuThayThe");
		if(vbGoc.trim() != "" && tuGoc.trim() != "" && tuThayThe.trim() != ""){
			String[] arvbThayThe = thayTheVB(arvbGoc, tuThayThe, tuGoc);
			String vbThayThe = convertStringArrayToString(arvbThayThe, " ");
			request.setAttribute("vbGoc", vbGoc);
			request.setAttribute("tuGoc", tuGoc);
			request.setAttribute("tuThayThe", tuThayThe);
			request.setAttribute("vbThayThe", vbThayThe);
			RequestDispatcher rd = request.getRequestDispatcher("/baitap4/BaiTap4.jsp");
			rd.forward(request, response);
			return;
		}
	}
	public String convertStringArrayToString(String[] strArr, String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (String str : strArr){
			sb.append(str).append(delimiter);
		}
		return sb.substring(0, sb.length() - 1);
	}
	public String[] thayTheVB(String[] arr, String tuThay, String tuGoc){
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].equals(tuGoc)){
				arr[i] = tuThay;
			}
		}
		return arr;
	}

}
