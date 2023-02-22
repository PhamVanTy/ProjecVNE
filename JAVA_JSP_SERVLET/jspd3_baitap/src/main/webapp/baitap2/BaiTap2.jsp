<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="style_baitap_12.css" type="text/css" rel="stylesheet">
		<link href="reset_css.css" type="text/css" rel="stylesheet">
	</head>
	<body>
		<div class="body">
		<form action="<%=request.getContextPath()%>/xu-ly-cau-chao" method="post">
			<h3 class="header">In câu chào</h3>
			<div class="content">
				<p>
					<label>Nhập tên </label> 
					<input type="text" name="hoTen" value="<%if (request.getAttribute("hoTen") != null) {out.print(request.getAttribute("hoTen"));}%>" />
				</p>
				<p>
					Câu chào:
					<%
						String hoTen = (String) request.getAttribute("hoTen");
						if (request.getAttribute("hoTen") != null && request.getAttribute("hoTen") != "") {
							out.print("Chào bạn " + hoTen);
						}
					%>
				</p>
				<input type="submit" value="In câu chào" name="submit" />
			</div>

		</form>
	</div>
	</body>
</html>