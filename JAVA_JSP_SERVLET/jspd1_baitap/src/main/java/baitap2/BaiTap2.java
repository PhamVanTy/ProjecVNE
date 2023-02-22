package baitap2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BaiTap2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BaiTap2() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int tongBanGhi = 57;
		int soBanGhiCuaTrang = 10;
		int soTrang = (int)Math.ceil((float) tongBanGhi / soBanGhiCuaTrang);
		out.print("<p>Số trang làm tròn lên: " + soTrang + "</p>");
		out.print("<p>Số trang làm trong xuống: " + tongBanGhi / soBanGhiCuaTrang + "</p>");
	}

}
