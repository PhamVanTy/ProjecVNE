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
                <h2>Quản lý danh mục</h2>
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
                            <%if("admin".equals(userLogin.getUsername())){ %> 
                                <div class="col-sm-6">
                                    <a href="<%=request.getContextPath()%>/admin/cats/add-cat" class="btn btn-success btn-md">Thêm</a>
                                </div>
                                <%}else{ %>
                                <div class="col-sm-6">                                   
                                </div>
                                <%} %>
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
                            if("3".equals(error)){
                            	out.print("<p style=\"color: red;\">Không được phân quyền.</p>");
                            }if("2".equals(error)){
                            	out.print("<p style=\"color: red;\">Có lỗi khi xóa.</p>");
                            }
                            	if(request.getParameter("mes") != null){
                            		int mes = Integer.parseInt(request.getParameter("mes"));
                            		if(mes == 1){ 
                            			out.print("<p style=\"color: green;\">Thêm thành công.</p>");                          	
                            		}
                            		
									if(mes == 2){
										out.print("<p style=\"color: green;\">Sửa thành công.</p>");
									}
									if(mes == 3){ 
                            			out.print("<p style=\"color: green;\">Xóa thành công.</p>");                          	
                            		} 
                            	}
									%>
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Tên thể loại nhạc</th>  
                                        <%if("admin".equals(userLogin.getUsername())){ %>                                  
                                        <th width="160px">Chức năng</th>
                                        <%} %>
                                    </tr>
                                </thead>
                                <tbody>
                                <%
                                	ArrayList<Categories> items = (ArrayList) request.getAttribute("categories");
                                	if(items != null && items.size() > 0){
                                		for(Categories objCat : items){
                                			%>
                                			<tr>
                                        		<td><%=objCat.getIdCat()%></td>
                                        		<td class="center"><%=objCat.getCatName()%></td>  
                                        		 <%if("admin".equals(userLogin.getUsername())){ %>                                      
                                        		<td class="center">
                                            	<a href="<%=request.getContextPath()%>/admin/cats/edit-cat?cid=<%=objCat.getIdCat()%>" title="" class="btn btn-primary"><i class="fa fa-edit "></i> Sửa</a>
                                            	<a href="#" onclick="showMess(<%=objCat.getIdCat()%>)" title="" class="btn btn-danger"><i class="fa fa-pencil"></i> Xóa</a>
                                       			</td>
                                       			<%} %>
                                    		</tr>
                                	<%	}
                                	} 
                                %>
                                    											
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
			location.href = "<%=request.getContextPath()%>/admin/cats/del?dcid="+id;
		}
	}
</script>
<script>
    document.getElementById("category").classList.add('active-menu');
</script>
<!-- /. PAGE INNER  -->
<%@ include file="/GiaoDien/admin/inc/footer.jsp" %>