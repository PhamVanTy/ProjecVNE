<%@page import="model.bean.Songs"%>
<%@page import="model.dao.SongsDAO"%>
<%@page import="model.bean.Categories"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.CatergoriesDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<div class="searchform">
  <form id="formsearch" name="formsearch" method="get" action="<%=request.getContextPath()%>/search">
    <span>
    <input name="editbox_search" class="editbox_search" id="editbox_search" maxlength="80" value="" type="text" placeholder="Tìm kiếm bài hát" />
    </span>
    <input  name="button_search" src="<%=request.getContextPath()%>/GiaoDien/public/images/search.jpg" class="button_search" type="image" />
  </form>
</div>
<div class="clr"></div>
<div class="gadget">
  <h2 class="star">Danh mục thể loại nhạc</h2>
  <div class="clr"></div>
  <ul class="sb_menu">
  <%
  	CatergoriesDAO catDao = new CatergoriesDAO();
	  ArrayList<Categories> listCat = catDao.getItems();
	int temp = 0;	
	if(request.getParameter("id") != null){
		temp = Integer.parseInt(request.getParameter("id"));
	}
	  for(Categories objCat : listCat){		  
  %>
    <li class="<%=temp==objCat.getIdCat() ? "active":""%>"><a href="<%=request.getContextPath()%>/cats?id=<%=objCat.getIdCat()%>"><%=objCat.getCatName()%></a></li>
    <%} %>
  </ul>
</div>

<div class="gadget">
  <h2 class="star"><span>Bài hát mới</span></h2>
  <div class="clr"></div>
  <ul class="ex_menu">
  <%
  	SongsDAO songDao = new SongsDAO(); 
  	ArrayList<Songs> listNewSong = songDao.getNewItems();
  	for(Songs objNewSong : listNewSong){
  %>
    <li><a href="<%=request.getContextPath()%>/detail?id=<%=objNewSong.getIdSong()%>"><%=objNewSong.getSongName()%></a><br />
      <%if(objNewSong.getPreview_text().length() > 50) out.print(objNewSong.getPreview_text().substring(0, 50) + "..."); else out.print(objNewSong.getPreview_text());%></li>
    <%} %>
  </ul>
</div>