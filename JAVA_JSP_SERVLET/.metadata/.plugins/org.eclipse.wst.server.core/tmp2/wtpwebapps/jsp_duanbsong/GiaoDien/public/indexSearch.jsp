<%@page import="util.DefineUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/GiaoDien/public/inc/header.jsp"%>
<div class="content_resize">
	<div class="mainbar">
		<%
		String error = request.getParameter("error");
		 if("1".equals(error)){
         	out.print("<p style=\"color: red;\">Không có bài hát bạn cần tìm.</p>");
         }
		SongsDAO songDao = new SongsDAO();
		ArrayList<Songs> listSong = (ArrayList) request.getAttribute("listSong");
		if(listSong != null && listSong.size() > 0){
			int i = 0;
		for (Songs objSong : listSong) {
			i++;
		%>
		<div class="article">
			<h2>
				<a
					href="<%=request.getContextPath()%>/public/detail?dtid=<%=objSong.getIdSong()%>"
					title="Đổi thay"><%=objSong.getSongName()%></a>
			</h2>
			<p class="infopost">Ngày đăng: <%=objSong.getDate_create()%>. Lượt xem: <%=objSong.getCounter()%><a href="<%=request.getContextPath()%>/public/detail?dtid=<%=objSong.getIdSong()%>" class="com"><span><%=i%></span></a></p>
			<div class="clr"></div>
			<div class="img">
				<img src="<%=request.getContextPath()%>/GiaoDien/admin/assets/img/<%=objSong.getPicture()%>" width="177" height="213" alt="<%=objSong.getSongName()%>" class="fl" />
			</div>
			<div class="post_content">
				<p><%=objSong.getPreview_text()%></p>
				<p class="spec"><a href="<%=request.getContextPath()%>/public/detail?dtid=<%=objSong.getIdSong()%>" class="rm">Chi tiết &raquo;</a></p>
			</div>
			<div class="clr"></div>
		</div>
		<%
		}}
		%>		
	</div>
	<div class="sidebar">
		<%@ include file="/GiaoDien/public/inc/leftbar.jsp"%>
	</div>
	<div class="clr"></div>
</div>
<%@ include file="/GiaoDien/public/inc/footer.jsp"%>
