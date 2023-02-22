$(document).ready(function (){
			$("#form-data").validate({
				rules: {
					id: {
						required: true,						
					},
					name: {
						required: true,						
					},
					number: {
						required: true,						
					},
					price:{
						required: true,						
					}
				},
				messages: {
					id: {
						required: "--Vui lòng nhập ID hoa--",
					},
					name: {
						required: "--Vui lòng nhập tên hoa--",
					},
					number: {
						required: "--Vui lòng nhập số lượng hoa--",
					},
					price:{
						required: "--Vui lòng nhập giá tiền--",
					}
				},
			});
		});