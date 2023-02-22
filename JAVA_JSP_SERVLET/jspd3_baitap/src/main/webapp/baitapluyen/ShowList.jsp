<%@page import="baitapluyen.controller.Computer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Hiển thi danh sách</title>
		<link href="reset_css.css" type="text/css" rel="stylesheet" />
		<link href="style_showlist.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<h2>Hiển thị danh sách Computer</h2>
		<a class="add_btn" href="<%=request.getContextPath()%>/show-computer">Add Computer</a>
			
			<table>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
				<%
				if(session.getAttribute("list") != null){
					ArrayList<Computer> list = (ArrayList<Computer>) session.getAttribute("list");
				%>
				<%
					for(Computer obj:list){
						%>
						<tr>
							<td><%=obj.getId() %></td>
							<td><%=obj.getName() %></td>
							<td><%=obj.getPrice() %></td>
							<td><a href="<%=request.getContextPath()%>/UpdateComputer?id_u=<%=obj.getId()%>">Sửa</a>/
							<a href="<%=request.getContextPath()%>/DeleteComputer?id=<%=obj.getId()%>">Xóa</a></td>
						</tr>
					<%}%>
			</table>
			<%}	%>
	</body>
</html>

