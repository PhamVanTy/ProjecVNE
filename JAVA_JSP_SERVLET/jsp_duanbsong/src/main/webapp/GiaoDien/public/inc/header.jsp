<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>BSong</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath()%>/GiaoDien/public/css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/GiaoDien/public/css/coin-slider.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/GiaoDien/public/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/GiaoDien/public/js/script.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/GiaoDien/public/js/coin-slider.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/GiaoDien/public/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/GiaoDien/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/GiaoDien/public/js/validate_public.js"></script>
</head>
<body>
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="logo">
        <h1><a href="<%=request.getContextPath()%>/public/trang-chu">BSong <small>Một dự án khóa JAVA tại VinaEnter Edu</small></a></h1>
      </div>
      <div class="menu_nav">
        <ul class="menu_active">
          <li><a href="<%=request.getContextPath()%>/public/trang-chu"><span>Trang chủ</span></a>
          <li><a href="<%=request.getContextPath()%>/public/contact"><span>Liên hệ</span></a></li>
        </ul>
      </div>
      <div class="clr"></div>
      <div class="slider">
        <div id="coin-slider"><a href="#"><img src="<%=request.getContextPath()%>/GiaoDien/public/images/slide1.jpg" width="935" height="307" alt="" /></a> <a href="#"><img src="images/slide2.jpg" width="935" height="307" alt="" /></a> <a href="#"><img src="images/slide3.jpg" width="935" height="307" alt="" /></a></div>
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="content">