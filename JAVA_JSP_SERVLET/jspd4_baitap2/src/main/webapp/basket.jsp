<%@page import="ShopHoaController.DoiTuongHoa"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Show danh sách mua</title>
		<link href="reset_css.css" type="text/css" rel="stylesheet" />
		<link href="styles.css" type="text/css" rel="stylesheet" /> 
	</head>
	<body>
		<div class="contain">
			<a href="<%=request.getContextPath()%>/ShowShopHoa">Mua thêm</a>
			<h2>Danh sách hoa đã chọn mua</h2>
			<table class="table">
				<tr>
					<th>ID</th>
					<th>Tên sản phẩm</th>
					<th>Giá</th>
					<th>Số lượng</th>
					<th>Tổng tiền</th>
				</tr>
				<%
					if(session.getAttribute("list") != null){
						ArrayList<DoiTuongHoa> list = (ArrayList<DoiTuongHoa>)session.getAttribute("list");
						float sum = 0;
				%>
					<%
						for(DoiTuongHoa obj:list){
							sum += obj.getNumber() * obj.getPrice();
					%>
						<tr>
							<td><%=obj.getId() %></td>
							<td><%=obj.getName() %></td>
							<td><%=obj.getPrice() %></td>
							<td><%=obj.getNumber() %></td>
							<td><%=obj.getNumber() * obj.getPrice() %></td>
						</tr>
						<%
						}
						%>
						<tr>
							<td colspan="4">Thành tiền: </td>
							<td><%=sum %></td>
						</tr>
				<%}	%>
			</table>
		</div>
	</body>
</html>