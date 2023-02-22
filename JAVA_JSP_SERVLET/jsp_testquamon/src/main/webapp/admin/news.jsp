<%@page import="model.bean.Lands"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.LandsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/admin/inc/header.jsp" %>
    <div class="page-content">
    	<div class="row">
 	<%@include file="/admin/inc/left_bar.jsp" %>
		  <div class="col-md-10">

  			<div class="content-box-large">
  				<div class="row">
	  				<div class="panel-heading">
	  					<div class="panel-title ">Quản lý BDS</div>
		  			</div>
				</div>
				<hr>	
				<div class="row">
					<div class="col-md-8">
						<a href="<%=request.getContextPath()%>/admin/show-add-bds" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Thêm</a>

					</div>
                	<div class="col-md-4">
                 	 <div class="input-group form">
                       <input type="text" class="form-control" placeholder="Search...">
                       <span class="input-group-btn">
                         <button class="btn btn-primary" type="button">Search</button>
                       </span>
                  	 </div>
                  	</div>
				</div>

				<div class="row">
  				<div class="panel-body">
  					<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
						<thead>
							<tr>
								<th>ID</th>
								<th>Tên bất động sản</th>
								<th>Mô tả</th>
								<th>Ngày đăng</th>								
								<th>Diện tích</th>
								<th>Địa chỉ</th>
								<th>Hình ảnh</th>
								<th>Chức năng</th>
							</tr>
						</thead>
						<tbody>
							<%
								LandsDAO land = new LandsDAO();
								ArrayList<Lands> listObjLand = land.getItemsLands();
								for(Lands obj : listObjLand){
							%>
							<tr class="odd gradeX">
								<td><%=obj.getlId()%></td>
								<td><%=obj.getlName()%></td>
								<td><%=obj.getDescript()%></td>
								<td class="center"><%=obj.getDate_create()%></td>
								<td><%=obj.getArea() %></td>
								<td><%=obj.getAddress()%></td>
								<td class="center text-center">
									<img src="<%=obj.getPicture()%>" />
								</td>
								<td class="center text-center">
									<a href="" title="" class="btn btn-primary"><span class="glyphicon glyphicon-pencil "></span> Sửa</a>
                                    <a href="" title="" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> Xóa</a>
								</td>
								</tr>
								<%} %>							
						</tbody>
					</table>

					<!-- Pagination -->
					<nav class="text-center" aria-label="...">
					   <ul class="pagination">
					      <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
					      <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
					      <li><a href="#">2</a></li>
					      <li><a href="#">3</a></li>
					      <li><a href="#">4</a></li>
					      <li><a href="#">5</a></li>
					      <li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
					   </ul>
					</nav>
					<!-- /.pagination -->
					
  				</div>
  				</div><!-- /.row -->
  			</div><!-- /.content-box-large -->
		  </div>
		</div>
    </div>

 	<%@include file="/admin/inc/footer.jsp"%>