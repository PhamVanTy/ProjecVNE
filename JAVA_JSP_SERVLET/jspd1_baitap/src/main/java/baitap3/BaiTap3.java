package baitap3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class BaiTap3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Random rd;
    public BaiTap3() {
        super();
        rd = new Random();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int n = randNum();
		out.println("Số ngẫu nhiên: " + n);
		kiemTraChiaCho3(n, out);
		kiemTraInK(n, out);
	}
	
	public int randNum() {
		int num = rd.nextInt(90) + 10;
		return num;
	}
	public void kiemTraChiaCho3(int n, PrintWriter out) {
		if(n % 3 == 0) {
			out.println("<p>Số này chia hết cho 3.</p>");
		}else {
			out.println("<p>Số này không chia hết cho 3.</p>");
		}
	}
	public void kiemTraInK(int n, PrintWriter out) {
		if(n >= 15 && n <= 90) {
			out.println("<p>Số này nằm trong khoảng 15->90.</p>");
		}else {
			out.println("<p>Số này không nằm trong khoảng 15->90.</p>");
		}
	}

}
