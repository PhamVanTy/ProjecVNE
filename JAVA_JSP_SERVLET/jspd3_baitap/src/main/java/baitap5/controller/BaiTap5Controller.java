package baitap5.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

public class BaiTap5Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Random rand;
    public BaiTap5Controller() {
        super();
        rand = new Random();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		int soNN = rand.nextInt(80) + 20;
		request.setAttribute("sonn", soNN);
		RequestDispatcher rd = request.getRequestDispatcher("/baitap5/Random.jsp");
		rd.forward(request, response);
	}

}
