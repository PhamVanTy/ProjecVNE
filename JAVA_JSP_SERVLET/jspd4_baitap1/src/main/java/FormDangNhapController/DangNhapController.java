package FormDangNhapController;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class DangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public DangNhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String usename = request.getParameter("username");
		String password = request.getParameter("password");
		session.setAttribute("username", usename);
		session.setAttribute("password", password);
		response.sendRedirect(request.getContextPath() + "/Welcome.jsp");
	}

}
