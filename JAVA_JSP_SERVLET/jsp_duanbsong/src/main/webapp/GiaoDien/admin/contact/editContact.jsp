<%@page import="model.bean.Contacts"%>
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
                <h2>Sửa contact</h2>
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
                                  String name = request.getParameter("name");
                                  String email = request.getParameter("email");
                                  String website = request.getParameter("website");
                                  String message = request.getParameter("message");
                                  Contacts contact = (Contacts)request.getAttribute("objContact");
                                  if(contact != null){
                                	  name = contact.getContactName();
                                	  email = contact.getEmail();
                                	  website = contact.getWebsite();
                                	  message = contact.getMessage();
                                  }
                                  %>                                  
                                    <div class="form-group">
                                        <label for="name">Tên</label>
                                        <input type="text" id="username" value="<%if(name != null) out.print(name);%>" name="username" class="form-control" />
                                    </div>     
                                    <div class="form-group">
                                        <label for="name">Email</label>
                                        <input type="text" id="email" value="<%if(email != null) out.print(email);%>" name="email" class="form-control" />
                                    </div> 
                                    <div class="form-group">
                                        <label for="name">Website</label>
                                        <input type="text" id="website" value="<%if(website != null) out.print(website);%>" name="website" class="form-control" />
                                    </div> 
                                    <div class="form-group">
                                        <label for="name">Message</label>
                                        <input type="text" id="message" value="<%if(message != null) out.print(message);%>" name="message" class="form-control" />
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
    document.getElementById("contact").classList.add('active-menu');
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/GiaoDien/admin/inc/footer.jsp" %>