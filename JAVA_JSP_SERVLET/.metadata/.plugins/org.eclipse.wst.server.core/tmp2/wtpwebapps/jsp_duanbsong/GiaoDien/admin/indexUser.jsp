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
                <h2>Quản lý người dùng</h2>
            </div>
        </div>
        <%
								String error = request.getParameter("error");
	                            if("1".equals(error)){
	                            	out.print("<p style=\"color: red;\">ID không tồn tại.</p>");
	                            }
	                            if("3".equals(error)){
	                            	out.print("<p style=\"color: red;\">Không đủ phân quyền.</p>");
	                            }
	                            if("4".equals(error)){
	                            	out.print("<p style=\"color: red;\">Không được phân quyền sửa.</p>");
	                            }
	                            if("5".equals(error)){
	                            	out.print("<p style=\"color: red;\">Không được phép xóa.</p>");
	                            }
								if(request.getParameter("mes") != null){
									int mes = Integer.parseInt(request.getParameter("mes"));
									if(mes == 1){
										out.print("<p style=\"color: green;\">Thêm user thành công.</p>");
									}
									if(mes == 2){
										out.print("<p style=\"color: green;\">Sửa user thành công.</p>");
									}
								}
								%>
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
                                    <a href="<%=request.getContextPath()%>/admin/users/add-user" class="btn btn-success btn-md">Thêm</a>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <form method="post" action="">
                                        <input type="submit" name="search" value="Tìm kiếm" class="btn btn-warning btn-sm" style="float:right" />
                                        <input type="search" class="form-control input-sm" placeholder="Nhập tên bài hát" style="float:right; width: 300px;" />
                                        <div style="clear:both"></div>
                                    </form><br />
                                </div>
                            </div>
							
						
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Username</th>  
                                        <th>PassWord</th> 
                                        <th>Fullname</th>                                  
                                        <th width="160px">Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                               <%
                               	ArrayList<Users> listUser = (ArrayList)request.getAttribute("listUser");
                               if(listUser != null || listUser.size() > 0){ 
                            	   for(Users objU : listUser){ %>
                               
                                			<tr>
                                        		<td><%=objU.getId_user()%></td>
                                        		<td class="center"><%=objU.getUsername()%></td>  
                                        		<td class="center"><%=objU.getPassword()%></td> 
                                        		<td class="center"><%=objU.getFullname()%></td> 
                                        		<%if("admin".equals(userLogin.getUsername())){ %>                                     
                                        		<td class="center">
	                                            	<a href="<%=request.getContextPath()%>/admin/users/edit-user?eid=<%=objU.getId_user()%>" title="" class="btn btn-primary"><i class="fa fa-edit "></i> Sửa</a>
	                                            	<a href="#" onclick="showMess(<%=objU.getId_user()%>)" title="" class="btn btn-danger"><i class="fa fa-pencil"></i> Xóa</a>                                       			
                                       			</td>
                                       			<%} else{ %>
                                       				<td class="center">
                                       				<%if(userLogin.getId_user() == objU.getId_user()){ %>
                                       					<a href="<%=request.getContextPath()%>/admin/users/edit-user?eid=<%=objU.getId_user()%>" title="" class="btn btn-primary"><i class="fa fa-edit "></i> Sửa</a>                                      					
                                       				<%} %>
                                       				</td>                                      				
                                       			<%} %>
                                    		</tr>
                                <%}}%>
                                    											
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
			location.href = "<%=request.getContextPath()%>/admin/users/del?did="+id;
		}
	}
</script>
<script>
    document.getElementById("user").classList.add('active-menu');
</script>
<!-- /. PAGE INNER  -->
<%@ include file="/GiaoDien/admin/inc/footer.jsp" %>