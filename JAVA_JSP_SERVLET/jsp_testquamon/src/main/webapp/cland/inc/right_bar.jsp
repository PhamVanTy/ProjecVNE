<%@page import="model.bean.Lands"%>
<%@page import="model.dao.LandsDAO"%>
<%@page import="model.dao.CategoriesDAO"%>
<%@page import="model.bean.Categories"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="clearfix sidebar_container floatright">
					<div class="clearfix sidebar">
						<div class="clearfix single_sidebar category_items">
							<h2>Danh mục bất động sản</h2>
							<ul>
							<%
								CategoriesDAO listC = new CategoriesDAO();
									ArrayList<Categories> listCat = listC.getItemCat();
									for(Categories objCat : listCat){
								%>										
								<li class="cat-item"><a href="<%=request.getContextPath()%>/show-danh-muc?cid=<%=objCat.getCid()%>"><%=objCat.getcName() %></a>(12)</li>							
								<% } %>
							</ul>
						</div>

						<div class="clearfix single_sidebar">
							<div class="popular_post">
								<div class="sidebar_title"><h2>Xem nhiều</h2></div>
								<ul>
								<%
									LandsDAO land = new LandsDAO();
									ArrayList<Lands> listLands = land.getItemsLands();
									for(Lands objLand : listLands){
								%>
									<li><a href="<%=request.getContextPath()%>/chi-tiet-cat?did=<%=objLand.getlId()%>"><%=objLand.getlName()%></a></li>
									<% } %>
								</ul>
							</div>
							</div>
						
						<div class="clearfix single_sidebar">
							<h2>Danh mục hot</h2>
							<ul>
							<%
								CategoriesDAO listCategoriesDAO = new CategoriesDAO();
									ArrayList<Categories> listCategories = listC.getItemCat();
									for(Categories obj : listCategories){
								%>	
								<li><a href="<%=request.getContextPath()%>/show-danh-muc?cid=<%=obj.getCid()%>"><%=obj.getcName() %><span>(12)</span></a></li>
								<% } %>
							</ul>
						</div>
					</div>
				</div>