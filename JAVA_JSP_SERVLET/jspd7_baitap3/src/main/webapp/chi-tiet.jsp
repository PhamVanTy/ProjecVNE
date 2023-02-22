<%@page import="model.bean.Friends"%>
<%@page import="model.bean.FriendList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/inc/header.jsp" %>
<div class="content">
	 <div class="container">
		 <div class="content-grids">
			 <div class="col-md-8 content-main">
				 <div class="content-grid">
					 <div class="content-grid-head">
					 <%
					 	FriendList objFrList = (FriendList) request.getAttribute("objFrList");
					 %>
						 <h3><%=objFrList.getFlName()%></h3>
						 <%
						 	Friends objFrs = (Friends) request.getAttribute("objFr");
						 	if(objFrs != null){
						 %>
						 <h4>Đăng ngày: <%=objFrs.getDateCreate()%> - Lượt xem: <%=objFrs.getCountNum()%></h4>
						 <div class="clearfix"></div>
					 </div>
					 <div class="content-grid-single">
						 <h3><%=objFrs.getName() %></h3>
						 <div class="detail_text">
							 <span><%=objFrs.getPreview() %></span>
							 <img class="single-pic" src="<%=objFrs.getPicture()%>" alt="">
							 <p><%=objFrs.getDetail() %></p>
						 </div>
						 <% } %>
						 <div class="comments">
						 <h3>Bạn thân khác của tôi</h3>
						 <%
						 	if(request.getAttribute("list2FR") != null){
						 		ArrayList<Friends> list2FR = (ArrayList<Friends>)request.getAttribute("list2FR");
						 		for(Friends objOFR : list2FR){
						 %>
							 <div class="comment-grid">
								 <img src="<%=objOFR.getPicture()%>" alt="">
								 <div class="comment-info">
								 <h4><a href="<%=request.getContextPath()%>/chi-tiet?did=<%=objOFR.getfID()%>&id=<%=objOFR.getFlID()%>"><%=objOFR.getName()%></a></h4>
								 <p><%=objOFR.getDetail()%></p>
								 </div>
								 <div class="clearfix"></div>
							 </div>
						 	<% }} %>
						</div>
					  </div>
					 
				 </div>			 			 
			 </div>
			 
			 <%@include file="/inc/right-bar.jsp" %>
			 <div class="clearfix"></div>
		 </div>
	 </div>
</div>

<%@include file="/inc/footer.jsp"%>