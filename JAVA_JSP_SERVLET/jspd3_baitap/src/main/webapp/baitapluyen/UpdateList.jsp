<%@page import="baitapluyen.controller.Computer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Update data</title>
		<link href="reset_css.css" type="text/css" rel="stylesheet" />
		<link href="style_btluyen.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<div class="contain">
		<%
		Computer item = null;
		if(request.getAttribute("item")!=null){
			item = (Computer)request.getAttribute("item");
		}
		%>
			<form action="<%=request.getContextPath()%>/UpdateComputer" method="post" >
				<h2 class="header">Đối tượng Computer</h2>
				<p class="id">ID: <input type="text" name="id_update" value="<%
					if(item!=null){
						out.print(item.getId());
					}
				%>" /></p>
				<p class="name">Name: <input type="text" name="name_update" value="<%
					if(item!=null){
						out.print(item.getName());
					}
				%>" /></p>
				<p class="price">Price: <input type="text" name="price_update" value="<%
					if(item!=null){
						out.print(item.getPrice());
					}
				%>" /></p>
				<p class="submit"><input name="submit" type="submit" value="Update" /></p>
			</form>
		</div>
	</body>
</html>