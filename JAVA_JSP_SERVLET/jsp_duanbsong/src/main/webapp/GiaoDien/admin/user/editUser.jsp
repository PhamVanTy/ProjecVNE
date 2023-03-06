<%@page import="model.bean.Users"%>
<%@page import="model.bean.Songs"%>
<%@page import="model.bean.Categories"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.CatergoriesDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/GiaoDien/admin/inc/header.jsp" %>
<%@ include file="/GiaoDien/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Sửa user</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <hr />
        <div class="row">
            <div class="col-md-12">
                <!-- Form Elements -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-12">
                                <form action="" role="form" method="post" id="form">
                                  <%
                                  String error = request.getParameter("error");
									if("1".equals(error)){
										out.print("<p style=\"color: red;\">Có lỗi khi sửa.</p>");
									}
									if("4".equals(error)){
										out.print("<p style=\"color: red;\">Tên fullname không hợp lệ.</p>");
									}
                                  	String name = request.getParameter("name");
                                  	String fullName = request.getParameter("fullname");
                                	Users userEdit = (Users)request.getAttribute("user");
                                  	if(userEdit != null){
                                  		name = userEdit.getUsername();
                                  		fullName = userEdit.getFullname();
                                  	}
                                  %>                               
                                    <div class="form-group">
                                        <label for="name">Username</label>
                                        <input type="text" id="username" value="<%if(name != null && !"4".equals(error)) out.print(name);%>" name="username" readonly="readonly" class="form-control" />
                                    </div>     
                                    <div class="form-group">
                                        <label for="name">Password</label>
                                        <input type="text" id="password" value="" name="pass" class="form-control" />
                                    </div> 
                                    <div class="form-group">
                                        <label for="name">Fullname</label>
                                        <input type="text" id="fullname" value="<%if(fullName != null && !"4".equals(error)) out.print(fullName);%>" name="fullname" class="form-control" />
                                    </div>                                                                                             
                                    <button type="submit" name="submit" class="btn btn-success btn-md">Lưu</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End Form Elements -->
            </div>
        </div>
        <!-- /. ROW  -->
    </div>
    <!-- /. PAGE INNER  -->
</div>
<script>
    document.getElementById("user").classList.add('active-menu');
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/GiaoDien/admin/inc/footer.jsp" %>