<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Shop mua hoa</title>
		<link href="reset_css.css" type="text/css" rel="stylesheet" />
		<link href="style_bt1.css" type="text/css" rel="stylesheet" />
		<script type="text/javascript" src="jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="jquery.validate.min.js"></script>
	</head>
	<body>	
		<form id="form-data">
			<h2>Mua hoa</h2>			
			<p>Id hoa: <input id="id" type="text" name="id" value="" /> </p>
			<p>Tên hoa: <input id="name" type="text" name="name" value="" /> </p>
			<p>Số lượng: <input id="num" type="text" name="number" value="" /> </p>
			<p>Giá: <input id="price" type="text" name="price" value="" /> </p>
			<a href="javascript:void(0)" title="" class="btn" onclick="return getMuaHoa()">Mua hoa</a>
			<div class="ajax-data"></div>			
		</form>
		<script src="<%=request.getContextPath()%>/validate_bt1.js"></script>
		<script type="text/javascript">
			function getMuaHoa() {
				var id = $("#id").val();
				var name = $("#name").val();
				var number = $("#num").val();
				var price = $("#price").val();
				$.ajax({
					url: '<%=request.getContextPath()%>/xuly-hienthi',
					type: 'POST',
					cache: false,
					data: {
						aid: id,
						aname: name,
						anumber: number,
						aprice: price
					},
					success: function(data){
						$('.ajax-data').html(data);
					},
					error: function (){
						alert('Có lỗi xảy ra');
					}
				});
				return false;
			}
		</script>
		
	</body>
	
</html>