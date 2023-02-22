<%@page import="model.bean.Friends"%>
<%@page import="model.bean.FriendList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/inc/header.jsp" %>
<div class="content">
	 <div class="container">
		 <div class="content-grids">
			 <div class="col-md-8 content-main">				 
				 <h1 class="title">Những người bạn</h1>
				 <%
				 	ArrayList<Friends> listFriends = (ArrayList<Friends>)request.getAttribute("friends");
				 	if(listFriends != null){	
						for(Friends objFr : listFriends){
				 %>
				 <div class="content-grid-sec">
					 <div class="content-sec-info">
							 <h3><a href="<%=request.getContextPath()%>/chi-tiet?did=<%=objFr.getfID()%>"><%=objFr.getName()%></a></h3>
							 <h4>Đăng ngày: <%=objFr.getDateCreate()%> - Lượt xem: <%=objFr.getCountNum() %></h4>
							 <p><%=objFr.getPreview()%></p>
							 <img src="<%=objFr.getPicture()%>" alt=""/>
							 <a class="bttn" href="<%=request.getContextPath()%>/chi-tiet?did=<%=objFr.getfID()%>">Chi tiết bạn tôi</a>
					 </div>
				 </div>
				 <% } }%>			 
			 </div>
			 
			 <%@include file="/inc/right-bar.jsp"%>
			 <div class="clearfix"></div>
		 </div>
	 </div>
</div>

<%@include file="/inc/footer.jsp"%>