/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.0.27
 * Generated at: 2023-03-01 04:42:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.GiaoDien.public_;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import util.DefineUtil;
import model.bean.Songs;
import model.dao.SongsDAO;
import model.bean.Categories;
import java.util.ArrayList;
import model.dao.CatergoriesDAO;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/GiaoDien/public/inc/header.jsp", Long.valueOf(1676431616614L));
    _jspx_dependants.put("/GiaoDien/public/inc/leftbar.jsp", Long.valueOf(1677645733474L));
    _jspx_dependants.put("/GiaoDien/public/inc/footer.jsp", Long.valueOf(1676454338544L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("model.dao.SongsDAO");
    _jspx_imports_classes.add("model.bean.Categories");
    _jspx_imports_classes.add("model.bean.Songs");
    _jspx_imports_classes.add("util.DefineUtil");
    _jspx_imports_classes.add("java.util.ArrayList");
    _jspx_imports_classes.add("model.dao.CatergoriesDAO");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>BSong</title>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/GiaoDien/public/css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath());
      out.write("/GiaoDien/public/css/coin-slider.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/GiaoDien/public/js/jquery-3.2.1.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/GiaoDien/public/js/script.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/GiaoDien/public/js/coin-slider.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/GiaoDien/public/js/jquery.validate.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/GiaoDien/ckeditor/ckeditor.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/GiaoDien/public/js/validate_public.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"main\">\r\n");
      out.write("  <div class=\"header\">\r\n");
      out.write("    <div class=\"header_resize\">\r\n");
      out.write("      <div class=\"logo\">\r\n");
      out.write("        <h1><a href=\"");
      out.print(request.getContextPath());
      out.write("/public/trang-chu\">BSong <small>Một dự án khóa JAVA tại VinaEnter Edu</small></a></h1>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"menu_nav\">\r\n");
      out.write("        <ul class=\"menu_active\">\r\n");
      out.write("          <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/public/trang-chu\"><span>Trang chủ</span></a>\r\n");
      out.write("          <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/public/contact\"><span>Liên hệ</span></a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"clr\"></div>\r\n");
      out.write("      <div class=\"slider\">\r\n");
      out.write("        <div id=\"coin-slider\"><a href=\"#\"><img src=\"");
      out.print(request.getContextPath());
      out.write("/GiaoDien/public/images/slide1.jpg\" width=\"935\" height=\"307\" alt=\"\" /></a> <a href=\"#\"><img src=\"images/slide2.jpg\" width=\"935\" height=\"307\" alt=\"\" /></a> <a href=\"#\"><img src=\"images/slide3.jpg\" width=\"935\" height=\"307\" alt=\"\" /></a></div>\r\n");
      out.write("        <div class=\"clr\"></div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"clr\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"content\">");
      out.write("<div class=\"content_resize\">\r\n");
      out.write("	<div class=\"mainbar\">\r\n");
      out.write("		");

		String error = request.getParameter("error");
		 if("1".equals(error)){
        	out.print("<p style=\"color: red;\">Không có bài hát bạn cần tìm.</p>");
        }
		
		ArrayList<Songs> listSong = (ArrayList) request.getAttribute("list");
		if(listSong != null && listSong.size() > 0){
			int j = 0;
			for (Songs objSong : listSong) {
				j++;
		
      out.write("<div class=\"article\">\r\n");
      out.write("			<h2>\r\n");
      out.write("				<a\r\n");
      out.write("					href=\"");
      out.print(request.getContextPath());
      out.write("/public/detail?dtid=");
      out.print(objSong.getIdSong());
      out.write("\"\r\n");
      out.write("					title=\"");
      out.print(objSong.getSongName());
      out.write('"');
      out.write('>');
      out.print(objSong.getSongName());
      out.write("</a>\r\n");
      out.write("			</h2>\r\n");
      out.write("			<p class=\"infopost\">Ngày đăng: ");
      out.print(objSong.getDate_create());
      out.write(". Lượt xem: ");
      out.print(objSong.getCounter());
      out.write("<a href=\"");
      out.print(request.getContextPath());
      out.write("/public/detail?dtid=");
      out.print(objSong.getIdSong());
      out.write("\" class=\"com\"><span>");
      out.print(j);
      out.write("</span></a></p>\r\n");
      out.write("			<div class=\"clr\"></div>\r\n");
      out.write("			<div class=\"img\">\r\n");
      out.write("				<img src=\"");
      out.print(request.getContextPath());
      out.write("/GiaoDien/admin/assets/img/");
      out.print(objSong.getPicture());
      out.write("\" width=\"177\" height=\"213\" alt=\"");
      out.print(objSong.getSongName());
      out.write("\" class=\"fl\" />\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"post_content\">\r\n");
      out.write("				<p>");
      out.print(objSong.getPreview_text());
      out.write("</p>\r\n");
      out.write("				<p class=\"spec\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/public/detail?dtid=");
      out.print(objSong.getIdSong());
      out.write("\" class=\"rm\">Chi tiết &raquo;</a></p>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"clr\"></div>\r\n");
      out.write("		</div>\r\n");
      out.write("		");

		}}
		

			int endPage = (Integer) request.getAttribute("endPage");
			int index = (Integer) request.getAttribute("index");
			int total = (Integer) request.getAttribute("total");			
			
      out.write("<p class=\"pages\">\r\n");
      out.write("			<small>Trang ");
      out.print(index);
      out.write(" của ");
      out.print(endPage);
      out.write("</small>		\r\n");
      out.write("			");
	
             	for(int i = 1; i <= endPage; i++){           	
             
      out.write("<a class=\"");
      out.print(index==i?"active":"");
      out.write("\" href=\"");
      out.print(request.getContextPath());
      out.write("/public/trang-chu?index=");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</a> \r\n");
      out.write("			");
}
      out.write("<a href=\"");
      out.print(request.getContextPath());
      out.write("/public/trang-chu?index=");
      out.print(index < endPage ? (index+1) : endPage);
      out.write("\">&raquo;</a>\r\n");
      out.write("			\r\n");
      out.write("		</p>\r\n");
      out.write("	</div>\r\n");
      out.write("	<div class=\"sidebar\">\r\n");
      out.write("		");
      out.write("<div class=\"searchform\">\r\n");
      out.write("  <form id=\"formsearch\" name=\"formsearch\" method=\"get\" action=\"");
      out.print(request.getContextPath());
      out.write("/public/search\">\r\n");
      out.write("    <span>\r\n");
      out.write("    <input name=\"editbox_search\" class=\"editbox_search\" id=\"editbox_search\" maxlength=\"80\" value=\"\" type=\"text\" placeholder=\"Tìm kiếm bài hát\" />\r\n");
      out.write("    </span>\r\n");
      out.write("    <input  name=\"button_search\" src=\"");
      out.print(request.getContextPath());
      out.write("/GiaoDien/public/images/search.jpg\" class=\"button_search\" type=\"image\" />\r\n");
      out.write("  </form>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"clr\"></div>\r\n");
      out.write("<div class=\"gadget\">\r\n");
      out.write("  <h2 class=\"star\">Danh mục thể loại nhạc</h2>\r\n");
      out.write("  <div class=\"clr\"></div>\r\n");
      out.write("  <ul class=\"sb_menu\">\r\n");
      out.write("  ");

  	CatergoriesDAO catDao = new CatergoriesDAO();
	  ArrayList<Categories> listCat = catDao.getItems();
	int temp = 0;	
	if(request.getParameter("plcid") != null){
		temp = Integer.parseInt(request.getParameter("plcid"));
	}
	  for(Categories objCat : listCat){		  
  
      out.write("<li class=\"");
      out.print(temp==objCat.getIdCat() ? "active":"");
      out.write("\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/public/cats?plcid=");
      out.print(objCat.getIdCat());
      out.write('"');
      out.write('>');
      out.print(objCat.getCatName());
      out.write("</a></li>\r\n");
      out.write("    ");
} 
      out.write("</ul>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"gadget\">\r\n");
      out.write("  <h2 class=\"star\"><span>Bài hát mới</span></h2>\r\n");
      out.write("  <div class=\"clr\"></div>\r\n");
      out.write("  <ul class=\"ex_menu\">\r\n");
      out.write("  ");

  	SongsDAO songDao = new SongsDAO(); 
  	ArrayList<Songs> listNewSong = songDao.getNewItems();
  	for(Songs objNewSong : listNewSong){
  
      out.write("<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/public/detail?dtid=");
      out.print(objNewSong.getIdSong());
      out.write('"');
      out.write('>');
      out.print(objNewSong.getSongName());
      out.write("</a><br />\r\n");
      out.write("      ");
if(objNewSong.getPreview_text().length() > 50) out.print(objNewSong.getPreview_text().substring(0, 50) + "..."); else out.print(objNewSong.getPreview_text());
      out.write("</li>\r\n");
      out.write("    ");
} 
      out.write("</ul>\r\n");
      out.write("</div>");
      out.write("</div>\r\n");
      out.write("	<div class=\"clr\"></div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("  <div class=\"footer\">\r\n");
      out.write("    <div class=\"footer_resize\">\r\n");
      out.write("      <p class=\"lf\">Copyright &copy; <a href=\"#\">VinaEnter Edu</a>. All Rights Reserved</p>\r\n");
      out.write("      <p class=\"rf\">Code by Gia Huy - Khóa JAVA17</a></p>\r\n");
      out.write("      <div style=\"clear:both;\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
