<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/cland/inc/header.jsp" %>
		
		<section id="content_area">
			<div class="clearfix wrapper main_content_area">
			
				<div class="clearfix main_content floatleft">
				
					
					<div class="clearfix content">
						<div class="content_title"><h2>Our Works</h2></div>
						
						<div class="clearfix single_work_container">
						<%
							if(request.getAttribute("listObjLand") != null){
								ArrayList<Lands> listObjLand = (ArrayList) request.getAttribute("listObjLand");
								for(Lands obj : listObjLand){
									%>
								<div class="clearfix single_work">
								<img class="img_top" src="<%=request.getContextPath()%>/cland/images/<%=obj.getPicture()%>" alt=""/>
								<h2><%=obj.getlName()%></h2>
								<a href="<%=request.getContextPath()%>/chi-tiet-cat?did=<%=obj.getlId()%>"><p class="caption"><%=obj.getlName()%></p></a>
							</div>
							<%	}
							}
						%>
							<div class="clearfix work_pagination">
								<nav>
									<a class="newer floatleft" href="">< -- Trang trước</a>
									<a class="older floatright" href="">Trang kế -- ></a>
								</nav>
							</div>

						</div>
					</div>
					
				</div>
				<%@include file="/cland/inc/right_bar.jsp" %>
			</div>
		</section>
		<%@include file="/cland/inc/footer.jsp" %>
		
