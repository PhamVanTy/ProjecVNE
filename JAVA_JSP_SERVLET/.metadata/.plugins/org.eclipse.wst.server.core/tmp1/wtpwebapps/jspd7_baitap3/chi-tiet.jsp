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
						 <h4>Đăng ngày: <%=objFrs.getDateCreate() %> - Lượt xem: <%=objFrs.getCountNum() %></h4>
						 <div class="clearfix"></div>
					 </div>
					 <div class="content-grid-single">
						 <h3><%=objFrs.getName() %></h3>
						 <div class="detail_text">
							 <span><%=objFrs.getPreview() %></span>
							 <img class="single-pic" src="<%=objFrs.getPicture() %>" alt="">
							 <p><%=objFrs.getDetail() %></p>
						 </div>
						 <% } %>
					<!-- 
					<div class="comments"> 
							 <h3>Bạn thân khác của tôi</h3>
							 <div class="comment-grid">
								 <img src="images/anh2.jpg" alt="">
								 <div class="comment-info">
								 <h4><a href="chi-tiet.jsp">Nguyễn Văn Hùng</a></h4>
								 <p>Hùng sinh ra trong một gia đình giỏi IT. Bố Hùng hiện đang là cố vấn sản phẩm chủ lực của Microsoft. Mẹ cũng là 1 lập trình viên cừ khôi tại tập đoàn VinaEnter.</p>
								 </div>
								 <div class="clearfix"></div>
							 </div>
							 
							 <div class="comment-grid">
								 <img src="images/anh1.jpg" alt="">
								 <div class="comment-info">
								 <h4><a href="chi-tiet.jsp">Trần Nguyễn Gia Huy</a></h4>
								 <p>Huy là bạn của tôi hồi còn mẫu giáo. Tôi còn nhớ cậu nói: Bạn thích ăn kẹo không mình mang đến cho...</p>
								 </div>
								 <div class="clearfix"></div>
							 </div>	
						</div>
					 -->	
					  </div>
					 
				 </div>			 			 
			 </div>
			 
			 <%@include file="/inc/right-bar.jsp" %>
			 <div class="clearfix"></div>
		 </div>
	 </div>
</div>

<%@include file="/inc/footer.jsp"%>