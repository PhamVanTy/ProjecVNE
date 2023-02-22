$(document).ready(function (){
	$("#login").validate ({
		rules: {
			username: {
				required: true,
			},
			password: {
				required: true,
				minlength: 6,
			},			
		},
		messages: {
			username: {
				required: "--Vui lòng điền tên đăng nhập--",				
			},
			password: {
				required: "--Vui lòng nhập mật khẩu--",
				minlength: "--Vui lòng nhập ít nhất 6 ký tự--",
			},			
		},
	})
});