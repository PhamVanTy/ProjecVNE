<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/GiaoDien/public/inc/header.jsp" %>
<div class="content_resize">
  <div class="mainbar">
    <div class="article">
     <%   
    	Songs song = (Songs) request.getAttribute("song");
    %> 
      <h1><%=song.getSongName()%></h1>
      <div class="clr"></div>
      <p>Ngày đăng: <%=song.getDate_create()%>. Lượt xem: <%=song.getCounter()%></p>
      <div class="vnecontent">
           <%=song.getDetail_text()%>
      </div>
    </div>

   <div class="article">
      <h2>Bài viết liên quan</h2>
      <div class="clr"></div>
<%
	Songs objS = (Songs)request.getAttribute("objS");
%>
      <div class="comment"> <a href="<%=request.getContextPath()%>/detail?id=<%=objS.getIdSong()%>"><img src="<%=request.getContextPath()%>/GiaoDien/admin/assets/img/<%=objS.getPicture()%>" width="40" height="40" alt="" class="userpic" /></a>
        <h2><a href="<%=request.getContextPath()%>/detail?id=<%=objS.getIdSong()%>"><%=objS.getSongName()%></a></h2>
        <p><%=objS.getPreview_text()%></p>
      </div>
    </div>  
  </div>
  <div class="sidebar">
  <%@ include file="/GiaoDien/public/inc/leftbar.jsp" %>
  </div>
  <div class="clr"></div>
</div>
<%@ include file="/GiaoDien/public/inc/footer.jsp" %>
