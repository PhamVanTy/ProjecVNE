<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/GiaoDien/public/inc/header.jsp" %>
<div class="content_resize">
  <div class="mainbar">
    <div class="article">
      <h2><span>Liên hệ</span></h2>
      <div class="clr"></div>
      <p>Khi bạn có thắc mắc, vui lòng gửi liên hệ, chúng tôi sẽ phản hồi trong thời gian sớm nhất.</p>
    </div>
    <div class="article">
      <h2>Gửi liên hệ đến chúng tôi</h2>
      <div class="clr"></div>
      <form action="" method="post" id="sendemail" >
      		<%
      		String name = request.getParameter("name");
      		String email = request.getParameter("email");
      		String website = request.getParameter("website");
      		String message = request.getParameter("message");
      		if(request.getParameter("error") != null){
				int error = Integer.parseInt(request.getParameter("error"));
				if(error == 1){
					out.print("<p style=\"color: red\">Tên liên hệ trùng.</p>");				
				}	
				if(error == 2){
					out.print("<p style=\"color: red\">Tên liên hệ không đúng định dạng.</p>");				
				}
			}
      		if(request.getParameter("mes") != null){
				int mes = Integer.parseInt(request.getParameter("mes"));
				if(mes == 1){
					out.print("<p style=\"color: green\">Thêm liên hệ thành công.</p>");	
			}}%>
        <ol>
          <li>
            <label for="name">Họ tên (required)</label>
            <input type="text" id="name" value="<%if(name != null) out.print(name); %>" name="name" class="text" />
          </li>
          <li>
            <label for="email">Email (required)</label>
            <input type="email" id="email" value="<%if(email != null) out.print(email); %>" name="email" class="text" />
          </li>
          <li>
            <label for="website">Website</label>
            <input type="text" id="website" value="<%if(website != null) out.print(website); %>" name="website" class="text" />
          </li>
          <li>
            <label>Nội dung</label>
            <textarea id="message" name="message" rows="8" cols="50" class="ckeditor"><%if(message != null) out.print(message); %></textarea>
           <br><label for="message" class="error"></label>
          </li>           
          <li>
            <input type="image" name="imageField" id="imageField" src="<%=request.getContextPath()%>/GiaoDien/public/images/submit.gif" class="send ckeditor" />
            <div class="clr"></div>
          </li>
        </ol>
      </form>
    </div>
  </div>
  <div class="sidebar">
  <%@ include file="/GiaoDien/public/inc/leftbar.jsp" %>
  </div>
  <div class="clr"></div>
</div>
<%@ include file="/GiaoDien/public/inc/footer.jsp" %>
