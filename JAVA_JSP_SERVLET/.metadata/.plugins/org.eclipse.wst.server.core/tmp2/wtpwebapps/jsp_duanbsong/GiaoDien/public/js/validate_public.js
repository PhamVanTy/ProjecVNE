$(document).ready(function(){
	$("#sendemail").validate({
		ignore: [],
		rules:{
			name: {
				required: true,
				minlength: 5,
			},
			email:{
				email: true,
			},
			website:{
				required: true,
			},
			message: {
				required: true,
				minlenght: 5,
			}
		},
		messages:{
			name: {
				required: "--Vui lòng nhập tên--",
				minlength: "--Tên ít nhất 5 ký tự--",
			},
			email:{
				email: "--Vui lòng nhập đúng email--",
			},	
			website:{
				required: "--Vui lòng nhập website--",
			},
			message: {
				required: "--Vui lòng nhập lời nhắn--",
				minlenght: "--Lời nhắn ít nhất 5 ký tự--",
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