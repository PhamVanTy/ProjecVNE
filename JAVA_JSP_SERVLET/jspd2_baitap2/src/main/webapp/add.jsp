<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/inc/header.jsp" %>
        
		<div class="container_12">
            <!-- Form elements -->    
            <div class="grid_12">
            
                <div class="module">
                     <h2><span>Thêm tin tức</span></h2>
                        
                     <div class="module-body">
                        <form action="">
                        
                            <div>
                                <span class="notification n-success">Thêm thành công</span>
                            </div>
                            
                            <p>
                                <label>Thêm tin</label>
                                <input type="text" class="input-medium" />
                            </p>
                            
                            <p>
                                <label>Danh mục tin</label>
                                <select class="input-short">
                                    <option value="1">Option 1</option>
                                    <option value="2">Option 2</option>
                                    <option value="3">Option 3</option>
                                    <option value="4">Option 4</option>
                                </select>
                            </p>

							<p>
                                <label>Hình ảnh</label>
                                <input type="file" value="" />
                            </p>
                            
                            <p>
                                <label>Mô tả</label>
                                <textarea rows="7" cols="90" class="input-medium"></textarea>
                            </p>
                            
                            
                            <p>
                                <label>Chi tiết</label>
                                <textarea rows="7" cols="90" class="input-long"></textarea>
                            </p>
                                
                            <fieldset>
                                <input class="submit-green" type="submit" value="Thêm tin" /> 
                                <input class="submit-gray" type="submit" value="Nhập lại" />
                            </fieldset>
                        </form>
                     </div> <!-- End .module-body -->

                </div>  <!-- End .module -->
        		<div style="clear:both;"></div>
            </div> <!-- End .grid_12 -->
                
            <div style="clear:both;"></div>
           
<%@include file="/inc/footer.jsp" %>

