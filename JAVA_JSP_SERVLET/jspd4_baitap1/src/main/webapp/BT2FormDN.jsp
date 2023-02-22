<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Đối tượng Account</title>
		<link href="reset_css.css" type="text/css" rel="stylesheet" />
		<link href="style.css" type="text/css" rel="stylesheet" />
	</head>
	<body>	
		<form action="<%=request.getContextPath()%>/DangNhapController" method="post">
			<h2>Login</h2>
			<p>Tên đăng nhập: <input class="user" type="text" name="username" value=""/></p>
			<p>Mật khẩu: <input class="pass" type="password" name="password" value=""/></p>
			<p><input class="submit" type="submit" value="Đăng nhập" name="submit" /></p>
		</form>
	</body>
</html>