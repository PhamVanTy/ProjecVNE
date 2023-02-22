<%@page import="model.bean.DanhMucTin"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>IN RA DANH MUC TIN</title>
	</head>
	<body>
		<h2>Danh sách các danh mục tin</h2>
		<ul>
		<%
			ArrayList<DanhMucTin> listDMT = (ArrayList<DanhMucTin>) request.getAttribute("listDMT");
			for(DanhMucTin objDMT : listDMT){
			%>
			<li><%=objDMT.getTenDMT() %></li>
			<%}%>
			
		</ul>
	</body>
</html>