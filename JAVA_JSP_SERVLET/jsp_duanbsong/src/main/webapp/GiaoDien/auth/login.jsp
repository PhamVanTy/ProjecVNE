<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login or Sign up</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/GiaoDien/auth/style.css" />
    
</head>
<body>
    <main>
        <div class="row">       
            <form action="" method="post" id="login">  
             <%
            	String error = request.getParameter("error");
            	if("1".equals(error)){
            		out.print("<p style=\"color: red;\">Đăng nhập không thành công.</p>");
            	}
            	String mes = request.getParameter("mes");
            	if("1".equals(mes)){
            		out.print("<p style=\"color: green;\">Đăng ký người dùng thành công.</p>");
            	}
            	String username = (String) request.getAttribute("username");
            	String password = (String) request.getAttribute("password");
            %>        
	            <div class="colm-form">
	                <div class="form-container">
	                    <input type="text" value="<%if(username != null) out.print(username);%>" placeholder="Enter your username" name="username" />
	                    <input type="password" value="<%if(password != null) out.print(password);%>" placeholder="Password" name="password" />
	                    <button type="submit" class="btn-login">Login</button>
	                    <a href="#">Forgotten password?</a>
	                   	<input type="button" class="btn-new" onclick="signup()" value="Create new Account">
	                </div>
	            </div>
            </form>           
        </div>
    </main>
<script type="text/javascript">
	function signup() {
		location.href = "<%=request.getContextPath()%>/signup";
	}
</script>
<script src="<%=request.getContextPath()%>/GiaoDien/auth/js/jquery-3.2.1.js"></script>
<script src="<%=request.getContextPath()%>/GiaoDien/auth/js/jquery.validate.min.js"></script>
<script src="<%=request.getContextPath()%>/GiaoDien/auth/js/validate_auth.js"></script>
</body>
</html>