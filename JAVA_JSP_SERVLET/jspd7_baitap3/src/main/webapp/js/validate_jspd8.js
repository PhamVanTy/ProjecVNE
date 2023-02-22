$(document).ready(function(){
	$("#form-contact").validate({
		rules:{
			username: {
				required: true,
			},
			email:{
				email: true,
			},
			phone:{
				required: true,
				minlength: 10,
				maxlength: 11,
			},
			mess:{
				required: true,
				minlength: 5,
			}
		},
		messages:{
			username: {
				required: "--Vui lòng nhập tên--",
			},
			email:{
				email: "--Vui lòng nhập đúng email--",
			},
			phone:{
				required: "--Vui lòng nhập SDT--",
				minlength: "--SDT ít nhất 10 chữ số--",
				maxlength: "--SDT nhiều nhất 11 chữ số--",
			},
			mess:{
				required: "--Vui lòng nhập nội dung--",
				minlength: "--Nội dung ít nhất 5 ký tự--",
			}
		},
	})
});