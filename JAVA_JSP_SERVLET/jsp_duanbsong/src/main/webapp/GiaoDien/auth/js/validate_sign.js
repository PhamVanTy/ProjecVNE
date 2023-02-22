$(document).ready(function (){
	$(".form").validate ({
		rules: {
			username: {
				required: true,
				minlength: 6,
				maxlength: 32,
			},
			password: {
				required: true,
				minlength: 6,
			},
			repassword: {
				equalTo: "#password",
			},
			fullname: {
				required: true,
				minlength: 6,
			},					
		},
		messages: {
			username: {
				required: "--Vui lòng nhập tên đăng nhập--",
				minlength: "--Tên truy cập ít nhất 6 ký tự--",
				maxlength: "--Tên truy cập nhiều nhất 32 ký tự--",
			},
			password: {
				required: "--Vui lòng nhập mật khẩu--",
				minlength: "--Vui lòng nhập ít nhất 6 ký tự--",
			},
			repassword: {
				equalTo: "--Không đúng mật khẩu--",
			},
			fullname: {
				required: "--Vui lòng nhập tên của bạn--",
				minlength: "--Tên ít nhất 5 ký tự--",
			},						
		},
	})
})