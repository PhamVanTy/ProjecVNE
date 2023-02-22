<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			String username = (String)session.getAttribute("username");
			String password = (String)session.getAttribute("password");
			if(username.equals("admin") && password.equals("123456")){
				out.print("Chào!admin");
			}else{
				out.print("Sai username hoặc password.");
			}
		%>
	</body>
</html>