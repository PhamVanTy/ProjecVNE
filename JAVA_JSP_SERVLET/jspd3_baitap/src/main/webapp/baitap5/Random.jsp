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
			if(request.getAttribute("sonn") != null){
				int soNN = (Integer)request.getAttribute("sonn");
				if(soNN % 2 == 0){
					out.print(soNN + " là số chẵn");
				}else{
					out.print(soNN + " là số lẻ.");
				}
			}
		%>
	</body>
</html>