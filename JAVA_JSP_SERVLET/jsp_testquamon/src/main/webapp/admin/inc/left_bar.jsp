<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="col-md-2">
		  	<div class="sidebar content-box" style="display: block;">
                <!-- Nav-bar -->
				<ul class="nav">
				    <!-- Main menu -->
				    <li class="current"><a href="<%=request.getContextPath()%>/admin/trang-chu"><i class="glyphicon glyphicon-home"></i> Trang chủ</a></li>
				    <li><a href="<%=request.getContextPath()%>/admin/cat.jsp"><i class="glyphicon glyphicon-list"></i> Danh mục BDS</a></li>
				    <li><a href="<%=request.getContextPath()%>/admin/news.jsp"><i class="glyphicon glyphicon-book"></i> Bất động sản</a></li>
				    <li><a href="<%=request.getContextPath()%>/admin/show-add-bds"><i class="glyphicon glyphicon-plus"></i> Thêm</a></li>
				    <li class="submenu">
				         <a href="#">
				            <i class="glyphicon glyphicon-list"></i> Pages
				            <span class="caret pull-right"></span>
				         </a>
				         <!-- Sub menu -->
				         <ul>
				            <li><a href="<%=request.getContextPath()%>/admin/login.jsp">Login</a></li>
				            <li><a href="javascript:void(0)">Signup</a></li>
				        </ul>
				    </li>
				</ul>
				<!-- /.nav-bar -->
             </div>
		  </div>