$(document).ready(function(){
	$("#form-contact").validate({
		rules:{
			name: {
				required: true,
			},
			email:{
				email: true,
			},
			content:{
				required: true,
			},
			text:{
				required: true,
			}
		},
		messages:{
			name: {
				required: "--Vui lòng nhập họ tên--",
			},
			email:{
				email: "--Vui lòng nhập đúng email--",
			},
			content:{
				required: "--Vui lòng nhập chủ đề--",
			},
			text:{
				required: "--Vui lòng nhập nội dung--",
			}
		}
	})
})