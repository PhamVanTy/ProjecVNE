<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Shop mua hoa</title>
		<link href="reset_css.css" type="text/css" rel="stylesheet" />
		<link href="style_shop.css" type="text/css" rel="stylesheet" />
	</head>
	<body>	
		<form action="<%=request.getContextPath()%>/ShopController" method="post">
			<h2>Mua hoa</h2>			
			<p>Id hoa: <input class="id" type="text" name="id" value="" /> </p>
			<p>Tên hoa: <input class="name" type="text" name="name" value="" /> </p>
			<p>Số lượng: <input class="num" type="text" name="number" value="" /> </p>
			<p>Giá: <input class="price" type="text" name="price" value="" /> </p>
			<%
			if(request.getParameter("msg") != null){
				int msg = Integer.parseInt(request.getParameter("msg"));
				if(msg == 1){
					out.print("<p style='color: red;'>Chưa nhập giá trị</p>");
				}
			}
			%>
			<p><input class="submit" type="submit" name="submit" value="Mua hoa" /></p>
		</form>
	</body>
</html>