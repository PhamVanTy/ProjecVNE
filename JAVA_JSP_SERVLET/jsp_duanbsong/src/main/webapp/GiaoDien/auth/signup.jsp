<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<title>Form đăng ký thành viên VinaEnter Edu</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/GiaoDien/auth/styles_signup.css" />
		<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet" />
		<script src="<%=request.getContextPath()%>/GiaoDien/auth/js/jquery-3.2.1.js"></script>
		<script src="<%=request.getContextPath()%>/GiaoDien/auth/js/jquery.validate.min.js"></script>		
		<script src="<%=request.getContextPath()%>/GiaoDien/auth/js/validate_sign.js"></script>		
	</head>
	<body>
	
		<form class="form" action="" method="post">
			<h2>ĐĂNG KÝ THÀNH VIÊN TRANG BSONG VINAENTER EDU</h2>	
			<%
			String error = request.getParameter("error");
			if("1".equals(error)){
				out.print("<p style=\"color: red; \">Đăng ký thành viên không thành công, tên đăng ký trùng.</p>");
			}
			String name = request.getParameter("username");
			String fullname = request.getParameter("fullname");
			
			%>
			<p>
				<label>Tên truy cập (*):</label>
				<input name="username" value="<%if(name != null) out.print(name); %>" type="text" placeholder="Choose your username" />
			</p>
			<p>
				<label>Mật khẩu (*):</label>
				<input name="password" value="" id="password" type="password" placeholder="Creat a new password" />
			</p>
			<p>
				<label>Xác nhận mật khẩu (*):</label>
				<input name="repassword" value="" type="password" placeholder="Confirm your password" />
			</p>
			<p>
				<label>Họ và tên (*):</label>
				<input name="fullname" value="<%if(fullname != null) out.print(fullname); %>" type="text" placeholder="Write your name here.." />
			</p>
			<p>
				<input type="submit" name="submit" value="ĐĂNG KÝ"/>
				<input type="reset" name="reset" value="RESET" />
				<a href="<%=request.getContextPath()%>/login"><input type="button" name="login" value="&lt; Back to LOGIN" /></a>				
			</p>
			<div class="contact">
				<span class="fa fa-phone"></span>0905.051.720
				<span class="fa fa-envelope-o"></span>info@vinaenter.edu.vn
			</div>
		</form>
	</body>
</html>