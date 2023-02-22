<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Upload file</title>
		<link href="style.css" type="text/css" rel="stylesheet" />
		<link href="reset_css.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<div class="contain">
			<form action="<%=request.getContextPath() %>/upload-file-controller" method="post" enctype="multipart/form-data">
				<h2>Upload hình ảnh</h2>
				<p>Hình ảnh
				<input type="file" name="file-img" value="" /></p>
				<%
				if(request.getParameter("msg") != null){
					int msg = Integer.parseInt(request.getParameter("msg"));
					if(msg == 1){
						out.print("<p style='color: red;'>Lỗi trong quá trình upload file.</p>");
					}else{
						if(msg == 2){
							out.print("<p style='color: red;'>Vui lòng chọn hình ảnh.</p>");
						}
					}
				}
				%>
				<%
				if(request.getAttribute("filename") != null){
					String fileName = (String) request.getAttribute("filename");
				%>	
				<h3>Hình ảnh sau khi upload</h3>
				<img style="width: 250px; height: 120px" alt="" src="<%=request.getContextPath()%>/files/<%=fileName%>" />
				<%}%>
				<input type="submit" name="submit" value="Up hình"/>
			</form>
		</div>
	</body>
</html>