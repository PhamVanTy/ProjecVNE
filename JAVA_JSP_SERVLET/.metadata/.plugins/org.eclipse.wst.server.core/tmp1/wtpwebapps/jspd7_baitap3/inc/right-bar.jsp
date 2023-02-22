<%@page import="model.bean.FriendList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.FriendListDAO"%>
<%@page import="model.dao.FriendsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="col-md-4 content-main-right">
				 <div class="search">
						 <h3>TÌM BẠN TÔI</h3>
						<form>
							<input type="text" value="" onfocus="this.value=''" onblur="this.value=''">
							<input type="submit" value="">
						</form>
				 </div>
				 
				 <div class="categories">
					 <h3>DANH MỤC BẠN BÈ</h3>
					 <%
					 	FriendListDAO listFr = new FriendListDAO();
					 	ArrayList<FriendList> listFriend = listFr.getItems();
					 	for(FriendList objFr : listFriend){
					 %>
					 <li class="active"><a href="<%=request.getContextPath()%>/danh-muc?cid=<%=objFr.getFlID()%>"><%=objFr.getFlName() %></a></li>
					<%} %>
				 </div>

				 <div class="archives">
					 <h3>Liên kết VinaEnter</h3>
					 <li class="active"><a href="http://vinaenter.edu.vn/lap-trinh-php-tu-az.html" target="_blank"><img width="100%" src="images/php.png" alt="" /></a></li>
					 <li><a href="http://vinaenter.edu.vn/lap-trinh-java-tu-az.html" target="_blank"><img width="100%" src="images/java.png" alt="" /></a></li>
					 <li><a href="http://vinaenter.edu.vn/lap-trinh-android-tu-az.html" target="_blank"><img width="100%" src="images/android.png" alt="" /></a></li>
				 </div>
			 </div>