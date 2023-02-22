<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/inc/header.jsp" %>
<div class="contact">
	 <div class="container">
		 <div class="contact-head">
			 <h3>Liên hệ</h3>
			  <form>
				  <div class="col-md-6 contact-left">
						<input type="text" placeholder="Name" required="">
						<input type="text" placeholder="E-mail" required="">
						<input type="text" placeholder="Phone" required="">
				 </div>
				 <div class="col-md-6 contact-right">
						 <textarea placeholder="Message"></textarea>
						 <input type="submit" value="SEND">
				 </div>
				 <div class="clearfix"></div>
			 </form>
		 </div>
	 </div>
</div>
<%@include file="/inc/footer.jsp" %>