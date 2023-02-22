<%@page import="model.bean.TinTuc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp" %>
			<div class="content-left fl">
				<%@include file="inc/left_bar.jsp" %>
			</div>
			<div class="content-right fr">
				<h3>Tin tức</h3>
				<div class="main-content items-new">
				<%
					ArrayList<TinTuc> listTT = (ArrayList<TinTuc>)request.getAttribute("listNews");
					if(listTT != null){
						for(TinTuc objTT : listTT){
				%>
					<ul>
						<li>
							<h2>
								<a href="<%=request.getContextPath()%>/chi-tiet?did=<%=objTT.getIdNews()%>" title=""><%=objTT.getName() %></a>
							</h2>
							<div class="item">
								<p><%=objTT.getPreview() %></p>
								<div class="clr"></div>
							</div>
						</li>
						<%} } %>
					</ul>
				</div>
			</div>
<%@include file="inc/footer.jsp" %>