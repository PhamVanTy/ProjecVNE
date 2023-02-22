<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/admin/inc/header.jsp" %>

    <div class="page-content">
    	<div class="row">
		   <%@include file="/admin/inc/left_bar.jsp" %>
		  <div class="col-md-10">

	  			<div class="row">
	  				<div class="col-md-12 panel-info">
			  			<div class="content-box-header panel-heading">
		  					<div class="panel-title ">Thêm danh mục</div>
			  			</div>
			  			<form action="<%=request.getContextPath()%>/admin/add-type" method="post">
			  			<div class="content-box-large box-with-header">
				  			<div>
								<div class="row mb-10"></div>
								
								<div class="row">
									<div class="col-sm-6">
																			
										<div class="form-group">
											<label>Loại bất động sản</label>
											<input type="text" name="typeName" class="form-control" placeholder="Nhập loại BDS muốn thêm" />
										</div>
								<%
									if(request.getAttribute("msg")!=null){
										int msg = (Integer) request.getAttribute("msg");
										if(msg == 1){ %>
										<p style="color: red">Thêm danh mục thành công</p>	
									<%	}
									}
								%>
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