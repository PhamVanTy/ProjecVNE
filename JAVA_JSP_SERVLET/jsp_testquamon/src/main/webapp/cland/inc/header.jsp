<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
	<head>
		<title>CLand | VinaEnter Edu</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!--Oswald Font -->
		<link href='http://fonts.googleapis.com/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/cland/css/tooltipster.css" />
		<!-- home slider-->
		<link href="<%=request.getContextPath()%>/cland/css/pgwslider.css" rel="stylesheet">
		<!-- Font Awesome -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/cland/css/font-awesome.min.css">
		<link href="<%=request.getContextPath()%>/cland/style.css" rel="stylesheet" media="screen">	
		<link href="<%=request.getContextPath()%>/cland/responsive.css" rel="stylesheet" media="screen">	
		<script type="text/javascript" src="<%=request.getContextPath()%>/cland/js/jquery.validate.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/cland/js/jquery-2.1.1.min.js"></script>	
		<script type="text/javascript" src="<%=request.getContextPath()%>/cland/js/jquery.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/cland/js/validate_bttest.js"></script>	
	</head>

	<body>
	
		<section id="header_area">
			<div class="wrapper header">
				<div class="clearfix header_top">
					<div class="clearfix logo floatleft">
						<a href="<%=request.getContextPath()%>/cland/trang-chu-land"><h1><span>C</span>Land</h1></a>
					</div>
					<div class="clearfix search floatright">
						<form>
							<input type="text" placeholder="Search"/>
							<input type="submit" />
						</form>
					</div>
				</div>
				<div class="header_bottom">
					<nav>
						<ul id="nav">
							<li><a href="<%=request.getContextPath()%>/cland/trang-chu-land">Trang chủ</a></li>
							<li id="dropdown"><a href="<%=request.getContextPath()%>/cland/cat.jsp">Bất động sản</a>
								<ul>
									<li><a href="<%=request.getContextPath()%>/cland/cat.jsp">Danh mục 1</a></li>
									<li><a href="<%=request.getContextPath()%>/cland/cat.jsp">Danh mục 2</a></li>
									<li><a href="<%=request.getContextPath()%>/cland/cat.jsp">Danh mục 3</a></li>
									<li><a href="<%=request.getContextPath()%>/cland/cat.jsp">Danh mục 4</a></li>
								</ul>
							</li>
							<li><a href="<%=request.getContextPath()%>/cland/single.jsp">Giới thiệu</a></li>
							<li><a href="<%=request.getContextPath()%>/cland/contact.jsp">Liên hệ</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</section>