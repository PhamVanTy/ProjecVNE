$(document).ready(function (){
	$("#form").validate ({
		ignore: [],
		debug: false,
		rules: {
			name: {
				required: true,
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
			email:{
				email: true,
			},	
			detail:{
				required: true,
			}	
		},
		messages: {
			name: {
				required: "--Vui lòng nhập dữ liệu--",				
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
				minlength: "--Tên ít nhất 6 ký tự--",
			},
			email:{
				email: "--Nhập vào email--",
			},
			detail:{
				required: "--Vui lòng nhập chi tiết--",
			}
		},
	})
});
CKEDITOR.on('instanceReady', function () {
    $.each(CKEDITOR.instances, function (instance) {
        CKEDITOR.instances[instance].document.on("keyup", CK_jQ);
        CKEDITOR.instances[instance].document.on("paste", CK_jQ);
        CKEDITOR.instances[instance].document.on("keypress", CK_jQ);
        CKEDITOR.instances[instance].document.on("blur", CK_jQ);
        CKEDITOR.instances[instance].document.on("change", CK_jQ);
    });
});

function CK_jQ() {
    for (instance in CKEDITOR.instances) {
        CKEDITOR.instances[instance].updateElement();
    }
}