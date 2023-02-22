<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/cland/inc/header.jsp"%>

<section id="content_area">
	<div class="clearfix wrapper main_content_area">

		<div class="clearfix main_content floatleft">

			<div class="clearfix slider">
				<ul class="pgwSlider">
					<li><img src="<%=request.getContextPath()%>/cland/images/thumbs/megamind_07.jpg" alt="Paris, France" data-description="Eiffel Tower and Champ de Mars" data-large-src="<%=request.getContextPath()%>/cland/images/slides/megamind_07.jpg" /></li>
					<li><img src="<%=request.getContextPath()%>/cland/images/thumbs/wall-e.jpg"	alt="Montréal, QC, Canada"	data-large-src="<%=request.getContextPath()%>/cland/images/slides/wall-e.jpg" data-description="Eiffel Tower and Champ de Mars" /></li>
					<li><img src="<%=request.getContextPath()%>/cland/images/thumbs/up-official-trailer-fake.jpg" alt="Shanghai, China" data-large-src="<%=request.getContextPath()%>/cland/images/slides/up-official-trailer-fake.jpg"	data-description="Shanghai ,chaina"></li>
				</ul>
			</div>

			<div class="clearfix content">
				<div class="content_title">
					<h2>Bài viết mới</h2>
				</div>
				<%
					if (request.getAttribute("list3Lands") != null) {
						ArrayList<Lands> list3Lands = (ArrayList) request.getAttribute("list3Lands");
						for (Lands obj3Land : list3Lands) {
				%>
				<div class="clearfix single_content">
					<div class="clearfix post_date floatleft">
						<div class="date">
							<h3>27</h3>
							<p>Tháng 3</p>
						</div>
					</div>
					<div class="clearfix post_detail">
						<h2>
							<a href="<%=request.getContextPath()%>/chi-tiet-cat?did=<%=obj3Land.getlId()%>"><%=obj3Land.getlName() %></a>
						</h2>
						<div class="clearfix post-meta">
							<p>
								<span><i class="fa fa-clock-o"></i> Địa chỉ: <%=obj3Land.getAddress()%></span> <span><i class="fa fa-folder"></i> Diện tích: <%=obj3Land.getArea()%>m2</span>
							</p>
						</div>
						<div class="clearfix post_excerpt">
							<img src="<%=request.getContextPath()%>/cland/images/<%=obj3Land.getPicture()%>" alt="" />
							<p><%=obj3Land.getDescript() %></p>
						</div>
						<a href="<%=request.getContextPath()%>/chi-tiet-cat?did=<%=obj3Land.getlId()%>">Đọc thêm</a>
					</div>
				</div>
				<% }} %>

			</div>

			<div class="pagination">
				<nav>
					<ul>
						<li><a href=""> << </a></li>
						<li><a href="">1</a></li>
						<li><a href="">2</a></li>
						<li><a href="">3</a></li>
						<li><a href="">4</a></li>
						<li><a href=""> >> </a></li>
					</ul>
				</nav>
			</div>
		</div>
		<%@include file="/cland/inc/right_bar.jsp"%>
	</div>
	</div>
</section>
<%@include file="/cland/inc/footer.jsp"%>