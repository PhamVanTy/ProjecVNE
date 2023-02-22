package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import bean.DoiTuongHoa;

public class ShopHoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<DoiTuongHoa> listHoa = new ArrayList<>();
	
    public ShopHoaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("aid").trim() != "" && request.getParameter("aname").trim() != "" && request.getParameter("anumber").trim() != "" && request.getParameter("aprice").trim() != "") {
			int id = Integer.parseInt(request.getParameter("aid"));	
			String name = request.getParameter("aname");
			int number = Integer.parseInt(request.getParameter("anumber"));
			float price = Float.parseFloat(request.getParameter("aprice")); 
			boolean flag = false;
			if(listHoa.size() > 0) {
				for (DoiTuongHoa objHoa : listHoa) {
					if(objHoa.getId() == id && objHoa.getName().equals(name)) {
						objHoa.setNumber(objHoa.getNumber() + number);
						flag = true;
					}
				}
			}
			if(!flag || listHoa.size() == 0) {
				DoiTuongHoa obj = new DoiTuongHoa(name, id, number, price);
				listHoa.add(obj);
			}
			float sum = 0;	
			response.getWriter().print(
						"<table class=\"table\">"
						+ "				<tr>"
						+ "					<th>ID</th>"
						+ "					<th>Tên sản phẩm</th>"
						+ "					<th>Giá</th>"
						+ "					<th>Số lượng</th>"
						+ "					<th>Tổng tiền</th>"
						+ "				</tr>");
			if(listHoa.size() > 0) {
					for(DoiTuongHoa obj:listHoa){
					sum += obj.getNumber() * obj.getPrice();
			response.getWriter().print(
					"<tr>"
					+ "			<td>"+obj.getId()+"</td>"
					+ "			<td>"+obj.getName()+"</td>"
					+ "			<td>"+obj.getPrice()+"</td>"
					+ "			<td>"+obj.getNumber()+"</td>"
					+ "			<td>"+obj.getNumber() * obj.getPrice()+"</td>"
					+ "		</tr>");
					}
			response.getWriter().print(
					"<tr>"
					+ "	<td colspan=\"4\">Thành tiền: </td>"
					+ "	<td>"+sum+"</td>"
					+ "	</tr>"
					);
			}
			
		}else {
			response.getWriter().print("Giỏ hàng rỗng!");
		}
		
	}

}
