<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Thay thế văn bản</title>
		<link href="reset_css.css" type="text/css" rel="stylesheet">
		<link href="css_bai4.css" type="text/css" rel="stylesheet">
	</head>
	<body>
		<div class="contain">
			<form action="<%=request.getContextPath()%>/xu-ly-thong-tin-thay-the" method="post">
				<h2 class="header">Thay thế chuỗi</h2>
				<div class="content">
					<p class="vbgoc">Đoạn văn gốc</p>
					<input class="textvbGoc" type="text" name="vbGoc" value="<% if(request.getAttribute("vbGoc") != null){
						out.print(request.getAttribute("vbGoc"));
					}%>"/>
					<p class="thaythe">Từ gốc
					<input type="text" name="tuGoc" value="<%if(request.getAttribute("tuGoc")!=null){
						out.print(request.getAttribute("tuGoc"));
					} %>"/> thay thế bằng
					<input type="text" name="tuThayThe" value="<%if(request.getAttribute("tuThayThe")!=null){
						out.print(request.getAttribute("tuThayThe"));
					} %>"/> 
					</p>
					<input class="vbthayThe" type="text" name="vbThayThe" value="<%if(request.getAttribute("vbGoc")!=null && request.getAttribute("tuGoc") != null ){
						String vbThayThe = (String) request.getAttribute("vbThayThe");
						out.print(vbThayThe);
					} %>"/>
					<input class="submit" type="submit" name="submit" value="Thực hiện" />
				</div>				
			</form>
		</div>
	</body>
</html>