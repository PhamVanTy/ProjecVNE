package ShopHoaController;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

public class ShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<DoiTuongHoa> list = new ArrayList<>();
    public ShopController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		boolean flag = false;
		if(request.getParameter("id").trim() != "" && request.getParameter("name").trim() != "" && request.getParameter("number").trim() != "" && request.getParameter("price").trim() != "") {
			String name = request.getParameter("name");
			int id = Integer.parseInt(request.getParameter("id"));
			int number = Integer.parseInt(request.getParameter("number"));
			float price = Float.parseFloat(request.getParameter("price"));
			if(list.size() > 0) {
				for (DoiTuongHoa objHoa : list) {
					if(objHoa.getId() == id && objHoa.getName().equals(name) && objHoa.getPrice() == price) {
						objHoa.setNumber(objHoa.getNumber() + number);
						flag = true;
					}
				}
			}
			if(!flag || list.size() == 0) {
				DoiTuongHoa obj = new DoiTuongHoa(name, id, price, number);
				list.add(obj);
			}
			session.setAttribute("list", list);
			response.sendRedirect(request.getContextPath() + "/basket.jsp");
//			request.setAttribute("list", list);
//			RequestDispatcher rd = request.getRequestDispatcher("/basket.jsp");
//			rd.forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath() + "/ShowShopHoa?msg=1");
		}
	}
}
