<%@page import="model.bean.Contacts"%>
<%@page import="model.bean.Users"%>
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
                <h2>Quản lý liên hệ</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <hr />
        <div class="row">
            <div class="col-md-12">
                <!-- Advanced Tables -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="table-responsive">
                            <div class="row">
                                <div class="col-sm-6">
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <form method="post" action="">
                                        <input type="submit" name="search" value="Tìm kiếm" class="btn btn-warning btn-sm" style="float:right" />
                                        <input type="search" class="form-control input-sm" placeholder="Nhập tên bài hát" style="float:right; width: 300px;" />
                                        <div style="clear:both"></div>
                                    </form><br />
                                </div>
                            </div>
							<%
							String error = request.getParameter("error");
                            if("1".equals(error)){
                            	out.print("<p style=\"color: red;\">ID không tồn tại.</p>");
                            }
							if(request.getParameter("mes") != null){
								int mes = Integer.parseInt(request.getParameter("mes"));
								if(mes == 1){
									out.print("<p style=\"color: green;\">Thêm liên hệ thành công.</p>");
								}											
								if(mes == 2){
									out.print("<p style=\"color: green;\">Sửa liên hệ thành công.</p>");
								}
							}
							%>
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Tên</th>  
                                        <th>Email</th> 
                                        <th>Website</th>   
                                      	<th>Message</th>                                
                                        <th width="160px">Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                               <%
                               		ArrayList<Contacts> listContacts = (ArrayList) request.getAttribute("listContacts");
                               		if(listContacts != null || listContacts.size() > 0){
                               			for(Contacts objContact : listContacts){ %>
                                			<tr>
                                        		<td><%=objContact.getIdContact()%></td>
                                        		<td class="center"><%=objContact.getContactName()%></td>  
                                        		<td class="center"><%=objContact.getEmail()%></td> 
                                        		<td class="center"><%=objContact.getWebsite()%></td> 
                                        		<td class="center"><%=objContact.getMessage()%></td>  
                                        		<%if("admin".equals(userLogin.getUsername())){ %>                                     
                                        		<td class="center">
                                            	<a href="<%=request.getContextPath()%>/admin/contacts/edit-contact?eid=<%=objContact.getIdContact()%>" title="" class="btn btn-primary"><i class="fa fa-edit "></i> Sửa</a>
                                            	<a href="#" onclick="showMess(<%=objContact.getIdContact()%>)" title="" class="btn btn-danger"><i class="fa fa-pencil"></i> Xóa</a>
                                       			</td>
                                       			<%} %>                                       		                                       			
                                    		</tr>
                                <%	}
                               		}%>
                                    											
                                </tbody>
                            </table>
                            
                        </div>

                    </div>
                </div>
                <!--End Advanced Tables -->
            </div>
        </div>
    </div>
</div>
<script>
	function showMess(id) {
		var option = confirm("Bạn có chắc chắn muốn xóa không");
		if(option){
			location.href = "<%=request.getContextPath()%>/admin/contacts/del?did="+id;
		}
	}
</script>
<script>
    document.getElementById("contact").classList.add('active-menu');
</script>
<!-- /. PAGE INNER  -->
<%@ include file="/GiaoDien/admin/inc/footer.jsp" %>