<%@page import="model.dao.CategoriesDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Categories"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/admin/inc/header.jsp" %>

    <div class="page-content">
    	<div class="row">
		   <%@include file="/admin/inc/left_bar.jsp" %>
		  <div class="col-md-10">

	  			<div class="row">
	  				<div class="col-md-12 panel-info">
			  			<div class="content-box-header panel-heading">
		  					<div class="panel-title ">Thêm bất động sản</div>
			  			</div>
			  			<form action="<%=request.getContextPath()%>/admin/add-bds" enctype="multipart/form-data" method="post">
			  			<div class="content-box-large box-with-header">
				  			<div>
								<div class="row mb-10"></div>
								
								<div class="row">
									<div class="col-sm-6">
										<div class="form-group">
											<label for="name">Tên bất động sản</label>
											<input type="text" name="namebds" class="form-control" placeholder="Nhập tên BDS">
										</div>
										
										<div class="form-group">
											<label>Địa chỉ bất động sản</label>
											<input type="text" name="addressbds" class="form-control" placeholder="Nhập địa chỉ BDS" />
										</div>
										
										<div class="form-group">
											<label>Loại bất động sản</label>
											<select class="form-control" name="choice">
											<%
												CategoriesDAO cat = new CategoriesDAO();
												ArrayList<Categories> listCat = cat.getItemCat();
												for(Categories obj : listCat){
													%>													
													<option value="<%=obj.getCid()%>"><%=obj.getcName()%></option>												
											<% } %>
											</select>
										</div>
										
										<div class="form-group">
											<label>Thêm hình ảnh</label>
											<input type="file" name="picture" class="btn btn-default" id="exampleInputFile1">
											<p class="help-block"><em>Định dạng: jpg, png, jpeg,...</em></p>
										</div>
										
										<div class="form-group">
										   <label>Diện tích</label>
										   <input type="text" name="area" class="form-control" placeholder="Nhập diện tích BDS" />
										</div>										
									</div>
									<div class="col-sm-6"></div>

									<div class="col-sm-12">
										<div class="form-group">
										   <label>Chi tiết</label>
										   <textarea class="form-control" name="detail" rows="7"></textarea>
										</div>
									</div>
								</div>

								<hr>
								<%
									if(request.getAttribute("msg") != null){
										int msg = (Integer)request.getAttribute("msg");
										if(msg == 1){%>
											<p style="color: red">Thêm thành công!</p>
									<%} else if(msg == 2){%>
										<p style="color: red">Vui lòng nhập các giá trị trên!</p>
									<%} }%>
									
								<div class="row">
									<div class="col-sm-12">
										<input type="submit" value="Thêm" class="btn btn-success" />
										<input type="reset" value="Nhập lại" class="btn btn-default" />
									</div>
								</div>

							</div>
						</div>
						</form>
			  		</div>
	  			</div><!-- /.row col-size -->
	  		
		  </div><!-- /.col-md-10 -->
		</div><!-- /.row -->
    </div><!-- Page content -->

   	<%@include file="/admin/inc/footer.jsp"%>