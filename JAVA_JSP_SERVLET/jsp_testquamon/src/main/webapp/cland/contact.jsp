<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/cland/inc/header.jsp" %>	
		<section id="content_area">
			<div class="clearfix wrapper main_content_area"	>		
				<div class="clearfix main_content floatleft">				
					<div class="clearfix content">						
						<div class="contact_us">						
							<h1>Liên hệ với chúng tôi</h1>							
							<p>
							TRUNG TÂM ĐÀO TẠO LẬP TRÌNH VINAENTER EDU<br />
							Trụ sở: 154 Phạm Như Xương, Liên Chiểu, Đà Nẵng<br />
							Web: <a href="http://vinaenter.edu.vn" title="">www.vinaenter.edu.vn</a>
							</p>
							<form id="form-contact" action="<%=request.getContextPath()%>/gui-lien-he" method="post">
								<p><input type="text" name="name" class="wpcf7-text" placeholder="Họ tên *"/></p>
								<p><input type="text" name="email" class="wpcf7-email" placeholder="Email *"/></p>
								<p><input type="text" name="content" class="wpcf7-text" placeholder="Chủ đề *"/></p>
								<p><textarea class="wpcf7-textarea" name="text" placeholder="Nội dung *"></textarea></p>
								<%
								  if(request.getAttribute("msg")!=null){
								 	int msg = (Integer)request.getAttribute("msg");
								 	if(msg == 1){%>
								 		<p style="color: red">Thêm thành công!</p>
									<%} else  if(msg == 2){%>
										<p style="color: red">Thêm thất bại!</p>
								<%} else {%>
									<p style="color: red">Vui lòng nhập giá trị vào các ô trên!</p>
								 	<%}} %>
								<p><input type="Submit" class="wpcf7-submit" value="Gửi liên hệ"/></p>
							</form> 
						</div>						
					</div>	
				</div>			
				<%@include file="/cland/inc/right_bar.jsp" %>
				</div>
			</div>
		</section>
		
		<%@include file="/cland/inc/footer.jsp"%>