<%@page import="util.DefineUtil"%>
<%@page import="model.dao.CatergoriesDAO"%>
<%@page import="model.bean.Categories"%>
<%@page import="model.bean.Songs"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/GiaoDien/admin/inc/header.jsp" %>
<%@ include file="/GiaoDien/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Quản lý bài hát</h2>
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
                                    <a href="<%=request.getContextPath()%>/admin/songs/add" class="btn btn-success btn-md">Thêm</a>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <form method="post" action="<%=request.getContextPath()%>/admin/search">
                                        <input type="submit" name="submit" value="Tìm kiếm" class="btn btn-warning btn-sm" style="float:right" />
                                       <%
                                       String nameSearch = request.getParameter("search");
                                       %>
                                        <input type="search" name="search" value="<%if(nameSearch != null) out.print(nameSearch); %>" class="form-control input-sm" placeholder="Nhập tên bài hát" style="float:right; width: 300px;" />
                                        <div style="clear:both"></div>
                                    </form><br />
                                </div>
                            </div>
                            <%
                            String error = request.getParameter("error");
                            if("1".equals(error)){
                            	out.print("<p style=\"color: red;\">ID không tồn tại.</p>");
                            }
                            if("2".equals(error)){
                            	out.print("<p style=\"color: red;\">Có lỗi khi xóa.</p>");
                            }
                            
							if(request.getParameter("mes") != null){
								int mes = Integer.parseInt(request.getParameter("mes"));
								if(mes == 1){
									out.print("<p style=\"color: green;\">Thêm bài hát thành công.</p>");							
								}
								if(mes == 2){
									out.print("<p style=\"color: green;\">Sửa bài hát thành công.</p>");
								}
								if(mes == 3){
									out.print("<p style=\"color: green;\">Xóa bài hát thành công.</p>");
								}
							}
						%> 
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Tên bài hát</th>
                                        <th>Thể loại nhạc</th>
                                        <th>Lượt đọc</th>
                                        <th>Hình ảnh</th>
                                        <%if("admin".equals(userLogin.getUsername())){ %> 
                                        <th width="160px">Chức năng</th>
                                        <%} %>
                                    </tr>
                                </thead>
                                <tbody>
                                <%
                                	CatergoriesDAO catDao = new CatergoriesDAO();
                                	ArrayList<Categories> listCat = catDao.getItems();
                                	ArrayList<Songs> listSong = (ArrayList) request.getAttribute("list");
                                	if(listSong != null && listSong.size() > 0){
                                		for(Songs objSong : listSong){                       		
                                		%>
                                		<tr>
	                                        <td><%=objSong.getIdSong() %></td>
	                                        <td class="center"><%=objSong.getSongName() %></td>
	                                        <%
	                                        	String name = "";
	                                        	for(Categories objCat : listCat){
	                                        		if(objSong.getId_cat() == objCat.getIdCat()){
	                                        			name = objCat.getCatName();
	                                        			 } }%>
	                                        	<td class="center"><%=name%></td>
	                                        
	                                        
	                                        <td class="center"><%=objSong.getCounter() %></td>
	                                        <td class="center">
	                                        <%if(!objSong.getPicture().isEmpty()){ %>
												<img width="200px" height="200px" src="<%=request.getContextPath()%>/GiaoDien/admin/assets/img/<%=objSong.getPicture()%>" alt="<%=objSong.getSongName()%>"/>
	                                       <%} %>
	                                        </td>
	                                        <%if("admin".equals(userLogin.getUsername())){ %> 
	                                        <td class="center">
	                                            <a href="<%=request.getContextPath()%>/admin/songs/edit-song?sid=<%=objSong.getIdSong()%>" title="" class="btn btn-primary"><i class="fa fa-edit "></i> Sửa</a>
	                                            <a href="#" onclick="showMess(<%=objSong.getIdSong()%>)" title="" class="btn btn-danger"><i class="fa fa-pencil"></i> Xóa</a>
	                                        </td>
	                                        <%} %>
                                    	</tr>
                                		<% }  } %>                             
									
                                </tbody>
                            </table>
                            <%
                            int endPage = (Integer)request.getAttribute("endPage");
                       		int index = (Integer)request.getAttribute("index");
                       		int total = (Integer)request.getAttribute("total");
                       		int num = 0;
                       		if(index<endPage){
                       			num = (index-1)*DefineUtil.NUMBER_PER_PAGE+DefineUtil.NUMBER_PER_PAGE;
                       		}else{
                       			num = total;
                       		}
                       		if(listSong != null || listSong.size() > 0){
                            %>
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="dataTables_info" id="dataTables-example_info" style="margin-top:27px">Hiển thị từ <%=(index-1)*DefineUtil.NUMBER_PER_PAGE+1%> đến <%=num%> của <%=total%> bài hát</div>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
                                        <ul class="pagination">
                                        <%
                                        	if(index > 1){ %>
                                        		<li class="paginate_button previous" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous"><a href="<%=request.getContextPath()%>/admin/songs?index=<%=index-1%>">Trang trước</a></li>                                        		
                                        	<%}
                                        %>
                                           <%	
                                           for(int i = 1; i <= endPage; i++){
                                           %>
                                            <li class="paginate_button <%=index==i ? "active" : ""%>" aria-controls="dataTables-example" tabindex="0"><a href="<%=request.getContextPath()%>/admin/songs?index=<%=i%>"><%=i%></a></li>
											<%} %>
											<%
											if(index < endPage){ %>
											<li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next"><a href="<%=request.getContextPath()%>/admin/songs?index=<%=index+1%>">Trang tiếp</a></li>	
											<%}%>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <%} %>
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
			location.href = "<%=request.getContextPath()%>/admin/songs/del?dsid="+id;
		}
	}
</script>
<script>
    document.getElementById("song").classList.add('active-menu');
</script>

<!-- /. PAGE INNER  -->
<%@ include file="/GiaoDien/admin/inc/footer.jsp" %>