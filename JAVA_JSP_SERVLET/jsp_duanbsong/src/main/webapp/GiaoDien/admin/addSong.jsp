<%@page import="util.FileUtil"%>
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
                <h2>Thêm bài hát</h2>
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
                                <form action="" role="form" method="post" enctype="multipart/form-data" id="form">
                                 <%
                                 	String name = request.getParameter("name");
                                 	String cat = request.getParameter("category");                               
                                 	String preview = request.getParameter("preview");
                         			String detail = request.getParameter("detail");
                         			ArrayList<Categories> listCat = (ArrayList<Categories>)request.getAttribute("listCat");
									String error = request.getParameter("error");
									if("1".equals(error)){%>
										<p style="color: red">Tên bài hát đã tồn tại</p>
								<%	} %>
                                    <div class="form-group">
                                        <label for="name">Tên bài hát</label>
                                        <input type="text" id="name" value="<%if(name != null) out.print(name); %>" name="name" class="form-control" />
                                    </div>                                  
                                    <div class="form-group">
                                        <label for="category">Danh mục bài hát</label>
                                        <select id="category" name="category" class="form-control">   
                                        	<option value="">--Selected--</option>                                                                  
                                          <%   
                                          if(listCat !=null && listCat.size() > 0){
                                        		for(Categories objCat : listCat){%>
                                        			<option <%if(cat != null && cat.equals(String.valueOf(objCat.getIdCat()))) out.print("selected"); %> value="<%=objCat.getIdCat()%>"><%=objCat.getCatName()%></option>
                                        	<%	}} %>	                                        
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="picture">Hình ảnh</label>
                                        <input type="file" name="picture" value="" />
                                    </div>
                                    <div class="form-group">
                                        <label for="preview">Mô tả</label>
                                        <textarea id="preview" class="form-control" rows="3" name="preview"><%if(preview != null) out.print(preview); %></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>Chi tiết</label>
                                        <textarea id="detail" class="form-control ckeditor" id="detail" rows="5" name="detail"><%if(detail != null) out.print(detail); %></textarea>
                                        <br><label for="detail" class="error"></label>
                                    </div>
                                    <button type="submit" name="submit" class="btn btn-success btn-md">Thêm</button>
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
    document.getElementById("song").classList.add('active-menu');
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/GiaoDien/admin/inc/footer.jsp" %>