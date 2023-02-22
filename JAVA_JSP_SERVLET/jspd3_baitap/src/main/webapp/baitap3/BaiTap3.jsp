<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Hình tròn</title>
		<link href="style_baitap_12.css" rel="stylesheet" type="text/css" />
		<link href="reset_css.css" type="text/css" rel="stylesheet">
	</head>
	<body>
		<div class="body">
			<form action="<%=request.getContextPath()%>/xu-ly-hinh-tron" method="post">
			<h3 class="header">Hình tròn</h3>	
			<%			
			if(request.getAttribute("err") != null){
				String err = (String)request.getAttribute("err");
				if(err.equals("c")){
					%>
					<p>Phải nhập 1 trong 2 giá trị</p>	
					<%
				}else if(err.equals("k")){
					%>
					<p>Chỉ được nhập 1 trong 2 giá trị </p>	
					<%
				}
					%>
			<% } %>
				<div class="content">
					<p>
						<label>Diện tích: </label> 
						<input type="text"  value="<%if(request.getAttribute("dientich") == null && request.getAttribute("bankinh") != null){
							out.print(request.getAttribute("dientich1"));
						}else {
							if(request.getAttribute("dientich") != null && request.getAttribute("bankinh") == null){
							out.print(request.getAttribute("dientich"));
							}
						}%>" name="dienTich" />
					</p>
					<p>
						<label>Bán kính: </label> 
						<input type="text"  value="<%if(request.getAttribute("bankinh") == null && request.getAttribute("dientich") != null){
							out.print(request.getAttribute("bankinh1"));
						}else{
							if(request.getAttribute("bankinh") != null && request.getAttribute("dientich") == null){
								out.print(request.getAttribute("bankinh"));
							}
						} %>" name="banKinh" />
					</p>
					<input type="submit" value="Submit" name="submit" />
				</div>
			</form>
		</div>
	</body>
</html>