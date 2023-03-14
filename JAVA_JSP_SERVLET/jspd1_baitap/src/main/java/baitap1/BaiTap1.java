package baitap1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BaiTap1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BaiTap1() {
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
		String tenHoa = "Hoa mẫu đơn";
		int giaBan = 120000;
		int soLuong = 4;
		int thanhTien = giaBan * soLuong;
		out.println("<p>Tên hoa: "+ tenHoa +"</p>");
		out.println("<p>Giá bán: " + giaBan + " VND -- Số lượng: "+soLuong+"</p>");
		out.println("<p>Thành tiền: "+ thanhTien+" VND</p>");
	}

}
