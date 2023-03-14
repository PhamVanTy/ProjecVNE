<%@page import="util.DefineUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/GiaoDien/public/inc/header.jsp"%>
<div class="content_resize">
	<div class="mainbar">
		<%
			ArrayList<Songs> listS = (ArrayList)request.getAttribute("listSearch");
		int j = 1;
			for(Songs objSong : listS){
				
		%>
		<div class="article">
			<h2>
				<a
					href="<%=request.getContextPath()%>/detail?id=<%=objSong.getIdSong()%>"
					title="Đổi thay"><%=objSong.getSongName()%></a>
			</h2>
			<p class="infopost">Ngày đăng: <%=objSong.getDate_create()%>. Lượt xem: <%=objSong.getCounter()%><a href="<%=request.getContextPath()%>/detail?id=<%=objSong.getIdSong()%>" class="com"><span><%=j%></span></a></p>
			<div class="clr"></div>
			<div class="img">
				<img src="<%=request.getContextPath()%>/GiaoDien/admin/assets/img/<%=objSong.getPicture()%>" width="177" height="213" alt="<%=objSong.getSongName()%>" class="fl" />
			</div>
			<div class="post_content">
				<p><%=objSong.getPreview_text()%></p>
				<p class="spec"><a href="<%=request.getContextPath()%>/detail?id=<%=objSong.getIdSong()%>" class="rm">Chi tiết &raquo;</a></p>
			</div>
			<div class="clr"></div>
		</div>
		<%
			j++;
		}
		int indexS = (int)request.getAttribute("indexSearch");
		int totalS = (int)request.getAttribute("totalSearch");
		int endPageS = (int)request.getAttribute("endPageSearch");
		String nameSave = (String)request.getAttribute("editbox_search");
		%>	
		<p class="pages">
			<small>Trang <%=indexS %> của <%=endPageS %></small>		
			<%	
             	for(int i = 1; i <= endPageS; i++){           	
             %>
			<a class="<%=indexS==i?"active":""%>" href="<%=request.getContextPath()%>/search?indexSearch=<%=i%>&editbox_search=<%=nameSave%>"><%=i%></a> 
			<%}%>			
			<a href="<%=request.getContextPath()%>/search?indexSearch=<%=(indexS < endPageS) ? (indexS+1) : endPageS%>&editbox_search=<%=nameSave%>">&raquo;</a>	
	</div>
	<div class="sidebar">
		<%@ include file="/GiaoDien/public/inc/leftbar.jsp"%>
	</div>
	<div class="clr"></div>
</div>
<%@ include file="/GiaoDien/public/inc/footer.jsp"%>
