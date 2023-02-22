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
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Tên bài hát</th>
                                        <th>Thể loại nhạc</th>
                                        <th>Lượt đọc</th>
                                        <th>Hình ảnh</th>
                                        <th width="160px">Chức năng</th>
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
												<img width="200px" height="200px" src="<%=request.getContextPath()%>/GiaoDien/admin/assets/img/<%=objSong.getPicture()%>" alt="<%=objSong.getSongName()%>"/>
	                                        </td>
	                                        <td class="center">
	                                            <a href="<%=request.getContextPath()%>/admin/songs/edit-song?sid=<%=objSong.getIdSong()%>" title="" class="btn btn-primary"><i class="fa fa-edit "></i> Sửa</a>
	                                            <a href="#" onclick="showMess(<%=objSong.getIdSong()%>)" title="" class="btn btn-danger"><i class="fa fa-pencil"></i> Xóa</a>
	                                        </td>
                                    	</tr>
                                		<% }  } %>                             									
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
			location.href = "<%=request.getContextPath()%>/admin/songs/del?dsid="+id;
		}
	}
</script>
<script>
    document.getElementById("song").classList.add('active-menu');
</script>

<!-- /. PAGE INNER  -->
<%@ include file="/GiaoDien/admin/inc/footer.jsp" %>