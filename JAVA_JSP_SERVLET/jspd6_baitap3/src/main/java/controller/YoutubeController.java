package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class YoutubeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public YoutubeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int status = Integer.parseInt(request.getParameter("astatus"));
		if(status == 1) {
			out.print(
					"<div id=\"video-youtube\">"+
						"<iframe width=\"670\" height=\"377\" src=\"https://www.youtube.com/embed/1VbufbrV1Cg\" frameborder=\"0\" allowfullscreen></iframe>"+
					"</div>"
					);			
		}else if(status == 2) {
			out.print(
					"<div id=\"video-youtube\">"+
						"<iframe width=\"670\" height=\"377\" src=\"https://www.youtube.com/embed/Zbx9zxZNFGE\" frameborder=\"0\" allowfullscreen></iframe>"+
					"</div>"
					);
		}else if(status == 3) {
			out.print(
					"<div id=\"video-youtube\">"+
						"<iframe width=\"670\" height=\"377\" src=\"https://www.youtube.com/embed/L2ltn1zSfDY\" frameborder=\"0\" allowfullscreen></iframe>"+
					"</div>"
					);
		}else if(status == 4) {
			out.print(
					"<div id=\"video-youtube\">"+
						"<iframe width=\"670\" height=\"377\" src=\"https://www.youtube.com/embed/AuUwqgy80H0\" frameborder=\"0\" allowfullscreen></iframe>"+
					"</div>"
					);
		}else if(status == 5) {
			out.print(
					"<div id=\"video-youtube\">"+
						"<iframe width=\"670\" height=\"377\" src=\"https://www.youtube.com/embed/-i5iAa2H1Bs\" frameborder=\"0\" allowfullscreen></iframe>"+
					"</div>"
					);
		}
		
	}

}
