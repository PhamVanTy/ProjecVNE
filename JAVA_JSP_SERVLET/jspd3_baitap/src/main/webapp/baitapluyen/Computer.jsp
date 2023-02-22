<%@page import="baitapluyen.controller.Computer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Computer</title>
		<link href="reset_css.css" type="text/css" rel="stylesheet" />
		<link href="style_btluyen.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<div class="contain">
		<%
		Computer item = null;
		if(request.getAttribute("item") != null){
			
		}
		%>
			<form action="<%=request.getContextPath()%>/computer-controller" method="post" >
				<h2 class="header">Đối tượng Computer</h2>
				<p class="id">ID: <input type="text" name="id" value="" /></p>
				<p class="name">Name: <input type="text" name="name" value="" /></p>
				<p class="price">Price: <input type="text" name="price" value="" /></p>
				<%
					if(request.getParameter("mes") != null){
						int mes = Integer.parseInt(request.getParameter("mes"));
						switch(mes){
						case 1:
							out.print("<p style='color: red;'>Bạn chưa nhập các giá trị.</p>");
							break;
						case 2:
							out.print("<p style='color: red;'>Đối tượng đã có trong danh sách.</p>");					
							break;
						case 3:
							out.print("<p style='color: red;'>Trùng tên và ID của đối tượng đã có trong danh sách.</p>");						
							break;
						case 4:
							out.print("<p style='color: red;'>Trùng ID với đối tượng đã có trong danh sách.</p>");						
							break;
						}
						%>
					<%}
				%>
				<p class="submit"><input type="submit" name="submit" value="Thêm"/></p>
				
			</form>
		</div>
	</body>
</html>