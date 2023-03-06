<%@page import="model.bean.Songs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/GiaoDien/public/inc/header.jsp" %>
<div class="content_resize">
  <div class="mainbar">
  <%    
    String error = request.getParameter("error");
    if("1".equals(error)){
    	out.print("<p style=\"color: red;\">ID không tồn tại.</p>");
    }
    Categories objCatByID = (Categories)request.getAttribute("objCat");
    %> 
    <div class="article">     
		<h1><%=objCatByID.getCatName()%></h1>
    </div>
    <%
    ArrayList<Songs> listSongByCat = (ArrayList) request.getAttribute("listSongByIDInPage");
    if(listSongByCat != null && listSongByCat.size() > 0){
    	int i =0;
   		 for(Songs obj : listSongByCat){
   			 i++;
    %>
    <div class="article">
      <h2><a href="<%=request.getContextPath()%>/public/detail?id=<%=obj.getIdSong()%>" title="<%=obj.getSongName()%>"><%=obj.getSongName()%></a></h2>
      <p class="infopost">Ngày đăng: <%=obj.getDate_create() %>. Lượt xem: <%=obj.getCounter()%> <a href="<%=request.getContextPath()%>/public/detail?id=<%=obj.getIdSong()%>" class="com"><span><%=i%></span></a></p>
      <div class="clr"></div>
      <div class="img"><img src="<%=request.getContextPath()%>/GiaoDien/admin/assets/img/<%=obj.getPicture()%>" width="177" height="213" alt="<%=obj.getSongName()%>" class="fl" /></div>
      <div class="post_content">
        <p><%=obj.getPreview_text()%></p>
        <p class="spec"><a href="<%=request.getContextPath()%>/public/detail?id=<%=obj.getIdSong()%>" class="rm">Chi tiết &raquo;</a></p>
      </div>
      <div class="clr"></div>
    </div>
      <%}} else {%> 
      <div class="article">
      	<h1>Chưa có bài hát nào!</h1>
       </div>
      <%} %>
      <%
      	int endPage = (Integer)request.getAttribute("endPage");
 		int index = (Integer)request.getAttribute("index");
 		int total = (Integer)request.getAttribute("totalByIDCat");
 		if(listSongByCat != null && listSongByCat.size() > 0){
      %>
    <p class="pages"><small>Trang <%=index%> của <%=endPage%></small>
   <%	
	for(int i = 1; i <= endPage; i++){      %>
		<a class="<%=index==i?"active":""%>" href="<%=request.getContextPath()%>/public/cats?id=<%=objCatByID.getIdCat()%>&index=<%=i%>"><%=i%></a> 
	<%}%>
    <a href="<%=request.getContextPath()%>/public/cats?index=<%=index < endPage ? (index+1) : endPage%>&id=<%=objCatByID.getIdCat()%>">&raquo;</a></p>
  <%} %>
  </div>
  <div class="sidebar">
      <%@ include file="/GiaoDien/public/inc/leftbar.jsp" %>
  </div>
  <div class="clr"></div>
</div>
<%@ include file="/GiaoDien/public/inc/footer.jsp" %>