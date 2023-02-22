<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/inc/header.jsp" %>
<div class="contact">
	 <div class="container">
		 <div class="contact-head">
			 <h3>Liên hệ</h3>
			  <%
			  if(request.getAttribute("msg")!=null){
			 	int msg = (Integer)request.getAttribute("msg");
			 	if(msg == 1){%>
			 		<p>Thêm thành công!</p>
				<%} else {%>
					<p>Thêm thành công!</p>
			<%}} %>
			  <form id="form-contact" action="<%=request.getContextPath()%>/them-lien-he" method="post">
				  <div class="col-md-6 contact-left">
						<input type="text" placeholder="Name" name="username" required="">
						<input type="text" placeholder="E-mail"  name="email" required="">
						<input type="text" placeholder="Phone" name="phone" required="" >
				 </div>
				 <div class="col-md-6 contact-right">
						 <textarea placeholder="Message" name="mess"></textarea>
						 <input type="submit" value="SEND">
				 </div>
				 <div class="clearfix"></div>
				
			 </form>
		 </div>
	 </div>
</div>
<script src="<%=request.getContextPath()%>/js/validate_jspd8.js"></script>
<%@include file="/inc/footer.jsp"%>