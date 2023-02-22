<%@page import="model.bean.Friends"%>
<%@page import="model.bean.FriendList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/inc/header.jsp" %>
<div class="content">
	 <div class="container">
		 <div class="content-grids">
			 <div class="col-md-8 content-main">	
			 	<%
			 		FriendList objFrList = (FriendList) request.getAttribute("objFrList");
				%>
				 <h1 class="title"><span>Những người bạn >> </span><%=objFrList.getFlName()%></h1>
				<%
					ArrayList<Friends> listFrs = (ArrayList<Friends>) request.getAttribute("frsListByID");
			 		if(listFrs.size() > 0){
			 			for(Friends objFr : listFrs){		 		
			 	%>
				 <div class="content-grid-sec">
					 <div class="content-sec-info">
							 <h3><a href="<%=request.getContextPath()%>/chi-tiet?did=<%=objFr.getfID()%>&id=<%=objFr.getFlID()%>"><%=objFr.getName()%></a></h3>
							 <h4>Đăng ngày: <%=objFr.getDateCreate()%> - Lượt xem: <%=objFr.getCountNum()%></h4>
							 <p><%=objFr.getDetail()%></p>
							 <img src="<%=objFr.getPicture()%>" alt=""/>
							 <a class="bttn" href="<%=request.getContextPath()%>/chi-tiet?did=<%=objFr.getfID()%>&id=<%=objFr.getFlID()%>">Chi tiết bạn tôi</a>
					 </div>
				 </div>	
				 <%}} %>		 
			 </div>
			 
			 <%@include file="/inc/right-bar.jsp" %>
			 <div class="clearfix"></div>
		 </div>
	 </div>
</div>

<%@include file="/inc/footer.jsp"%>