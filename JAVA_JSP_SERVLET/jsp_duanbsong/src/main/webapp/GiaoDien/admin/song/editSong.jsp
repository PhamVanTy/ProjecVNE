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
                <h2>Sửa bài hát</h2>
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
                                  String error = request.getParameter("error");
									if("1".equals(error)){
										out.print("<p style=\"color: red;\">Có lỗi khi sữa.</p>");
									}
									if("4".equals(error)){
										out.print("<p style=\"color: red;\">Tên không hợp lệ.</p>");
									}
									String name = request.getParameter("name");
                                 	String cat = request.getParameter("category");                               
                                 	String preview = request.getParameter("preview");
                         			String detail = request.getParameter("detail");
									String picture = "";
                         			Songs objS = (Songs)request.getAttribute("objs");
                         			ArrayList<Categories> list = (ArrayList<Categories>)request.getAttribute("listCat");
                                  	if(objS != null){
                                  		name = objS.getSongName();
                                  		cat = String.valueOf(objS.getId_cat());
                                  		preview = objS.getPreview_text();
                                  		picture = objS.getPicture();
                                  		detail = objS.getDetail_text();
                                  	}
                                  %>                               
                                    <div class="form-group">
                                        <label for="name">Tên bài hát</label>
                                        <input type="text" id="name" value="<%if(name != null && !"4".equals(error)) out.print(name); %>" name="name" class="form-control" />
                                    </div>     
                                                                
                                    <div class="form-group">
                                        <label for="category">Thể loại nhạc</label>
                                        <select id="category" name="category" class="form-control">                                    
                                      <%                                   	                                                                             		
                                        for(Categories obj : list){                                          			
                                  	 %>        		
                                        	<option <%if(cat != null && cat.equals(String.valueOf(obj.getIdCat()))) out.print("selected"); %>  value="<%=obj.getIdCat()%>"><%=obj.getCatName()%></option> 
                                        	<%}%>                                       		                                        
                                        </select>
                                    </div>
                                    <div class="form-group">
                                    <% if(!picture.isEmpty()){ %>
                                        <label for="picture">Hình ảnh cũ: </label>                                        
                                        <img alt="" src="<%=request.getContextPath()%>/GiaoDien/admin/assets/img/<%=picture%>" width="200" height="215"><br/>    
                                        <label style="color: red;">Bạn có muốn xóa bên hình ở trên không: </label> <br/>                          
                                        <input type="radio" name="checkbox" value="yes"/> Có  <input <% if(!picture.isEmpty()) out.print("checked"); %> type="radio" name="checkbox" value="no"/> Không<br/>
                                        <%} %>
                                        <br/><label>Chọn ảnh mới nếu muốn:</label>
                                        <input value="" type="file" name="picture" id="img" />
                                         <label id="selectedBanner"></label>
                                    </div>
                                    <div class="form-group">
                                        <label for="preview">Mô tả</label>
                                        <textarea id="preview" class="form-control" rows="3" name="preview"><%if(preview != null) out.print(preview); %></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label for="detail">Chi tiết</label>
                                        <textarea id="detail" class="form-control ckeditor" id="detail" rows="5" name="detail"><%if(detail != null) out.print(detail); %></textarea>
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
<!--
	function chooseFile(inputFile) {
		if(inputFile.files && inputFile.files[0]){
			var reader = new FileReader();
			reader.onload = function (e) {
				$('#image').attr('src', e.target.result);
			}
			reader.readAsDataURL(inputFile.files[0]);
		}
	}
	-->
	var selDiv = "";
    var storedFiles = [];
    $(document).ready(function () {
      $("#img").on("change", handleFileSelect);
      selDiv = $("#selectedBanner");
    });

    function handleFileSelect(e) {
      var files = e.target.files;
      var filesArr = Array.prototype.slice.call(files);
      filesArr.forEach(function (f) {
        if (!f.type.match("image.*")) {
          return;
        }
        storedFiles.push(f);

        var reader = new FileReader();
        reader.onload = function (e) {
          var html =
            '<img src="' +
            e.target.result +
            "\" data-file='" +
            f.name +
            "alt='Category Image' height='200px' width='200px'>";
          selDiv.html(html);
        };
        reader.readAsDataURL(f);
      });
    }
</script>
<script>
    document.getElementById("song").classList.add('active-menu');
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/GiaoDien/admin/inc/footer.jsp" %>