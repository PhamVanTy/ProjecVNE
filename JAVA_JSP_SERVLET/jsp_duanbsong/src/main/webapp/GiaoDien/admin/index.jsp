<%@page import="model.bean.Contacts"%>
<%@page import="model.bean.Users"%>
<%@page import="model.bean.Songs"%>
<%@page import="model.bean.Categories"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/GiaoDien/admin/inc/header.jsp" %>
<%@ include file="/GiaoDien/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>TRANG QUẢN TRỊ VIÊN</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <hr />
        <%
        	ArrayList<Categories> listCat = (ArrayList<Categories>) request.getAttribute("categories");
        	ArrayList<Songs> listSong = (ArrayList<Songs>) request.getAttribute("listSong");
        	ArrayList<Users> listUsers = (ArrayList<Users>) request.getAttribute("listUsers");
        	ArrayList<Contacts> listContacts = (ArrayList<Contacts>) request.getAttribute("listContacts");
        	if(listCat != null && listSong != null && listCat.size() > 0 && listSong.size()>0){%>
         
        <div class="row">
            <div class="col-md-4 col-sm-4 col-xs-4">
                <div class="panel panel-back noti-box">
                    <span class="icon-box bg-color-green set-icon">
                    <i class="fa fa-bars"></i>
                </span>
                    <div class="text-box">
                        <p class="main-text"><a href="<%=request.getContextPath()%>/admin/cats" title="">Quản lý danh mục</a></p>
                        <p class="text-muted">Có <%=listCat.size()%> danh mục</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-4">
                <div class="panel panel-back noti-box">
                    <span class="icon-box bg-color-blue set-icon">
                    <i class="fa fa-bell-o"></i>
                </span>
                    <div class="text-box">
                        <p class="main-text"><a href="<%=request.getContextPath()%>/admin/songs" title="">Quản lý bài hát</a></p>
                        <p class="text-muted">Có <%=listSong.size()%> bài hát</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-4">
                <div class="panel panel-back noti-box">
                    <span class="icon-box bg-color-brown set-icon">
                    <i class="fa fa-rocket"></i>
                </span>
                    <div class="text-box">
                        <p class="main-text"><a href="<%=request.getContextPath()%>/admin/users" title="">Quản lý người dùng</a></p>
                        <p class="text-muted">Có <%=listUsers.size()%> người dùng</p>
                    </div>
                </div>
            </div>
        </div>
	<%}
        %>
    </div>
</div>
<script>
    document.getElementById("index").classList.add('active-menu');
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/GiaoDien/admin/inc/footer.jsp" %>