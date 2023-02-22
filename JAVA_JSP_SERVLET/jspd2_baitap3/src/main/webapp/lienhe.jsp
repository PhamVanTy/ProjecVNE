<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/inc/header.jsp" %>

	<div id="main-body">
		<div class="main-content">
			<%@include file="inc/left_bar.jsp" %>
			<div class="body-right fr">
				<div class="news-block">
					<h2 class="title-cat">Liên hệ</h2>
					<div class="content-cat1">
						<div class="content-detail">
							<div class="FromBox">
								<h4>Liên hệ javionline.net</h4>
								<form name="fcontact" method="post" action="" id="fcontact"
									enctype="multipart/form-data" novalidate="novalidate">
	
									<div class="FieldRow">
										<label>Họ và tên:<span class="RSM_form_star_color">(*)</span></label>
										<input type="text" value="" class="" maxlength="50"
											name="HO_VA_TEN" id="HO_VA_TEN">
									</div>
	
									<div class="FieldRow">
										<label>Email:<span class="RSM_form_star_color">(*)</span></label>
										<input type="text" value="" class="" maxlength="50"
											name="EMAIL" id="EMAIL">
									</div>
	
									<div class="FieldRow">
										<label>Điện thoại:</label> <input type="text" value="" class=""
											maxlength="50" name="PHONE" id="PHONE">
									</div>
	
									<div class="FieldRow">
										<label>Website:</label> <input type="text" value="" class=""
											maxlength="50" name="WEBSITE" id="WEBSITE">
									</div>
	
									<div class="FieldRow">
										<label>Nội dung:<span class="RSM_form_star_color">(*)</span></label>
										<textarea class="" style="width: 100%; height: 140px;"
											name="CONTENT" id="CONTENT"></textarea>
									</div>
	
	
									<div class="FieldRow" style="margin-top: 24px;">
										<input class="button_submit" type="submit" id="submit"
											name="submit" value="Gửi liên hệ"> <input
											class="button_submit" type="reset" id="submit" name="submit"
											value="Nhập lại">
									</div>
	
								</form>
							</div>
	
	
						</div>
					</div>
				</div>
	
			</div>
	
			<div class="clr"></div>
		</div>
	</div>

<%@include file="/inc/footer.jsp" %>
