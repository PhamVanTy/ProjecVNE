<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/cland/inc/header.jsp" %>
		
		<section id="content_area">
			<div class="clearfix wrapper main_content_area">
			
				<div class="clearfix main_content floatleft">
				
					
					<div class="clearfix content">
						<%
							if(request.getAttribute("objLand") != null){
								Lands objLand = (Lands) request.getAttribute("objLand");
								%>
							
						<h1><%=objLand.getlName()%> </h1>
						<div class="clearfix post-meta">
							<p><span><i class="fa fa-clock-o"></i> <%=objLand.getAddress()%></span> <span><i class="fa fa-folder"></i> Diện tích: <%=objLand.getArea()%>m2</span></p>
						</div>
						
						<div class="vnecontent">
							<p><%=objLand.getDescript()%></p>
						</div>
						<%}
						%>
						<a class="btn" href="">Bài trước</a>
						<a class="btn" href="">Bài kế</a>
					
					</div>
					
						<div class="more_themes">
							<h2>Bất động sản liên quan <i class="fa fa-thumbs-o-up"></i></h2>
							<%
								if(request.getAttribute("list3Land") != null){
									ArrayList<Lands> list3Land = (ArrayList) request.getAttribute("list3Land");
									for(Lands objs : list3Land){ %>
									<div class="more_themes_container">
										<div class="single_more_themes floatleft">
											<img src="<%=request.getContextPath()%>/cland/images/<%=objs.getPicture()%>" alt=""/>
											<a href=""><h2><%=objs.getlName()%></h2></a>
										</div>
									</div>
								<%	}
								}
							%>
							
						</div>
					
				</div>
				<%@include file="/cland/inc/right_bar.jsp" %>
				</div>
			</div>
		</section>
		<%@include file="/cland/inc/footer.jsp" %>