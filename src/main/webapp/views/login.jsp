<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyWebsite</title>

<style type="text/css">
	/* General styles */
	body {
	    font-family: 'Poppins', sans-serif;
	    background-color: #f0f0f0;
	    display: flex;
	    justify-content: center;
	    align-items: center;
	    height: 100vh;
	}
	
	/* Form container */
	form {
	    max-width: 400px;
	    padding: 20px;
	    border: 1px solid #ccc;
	    border-radius: 10px;
	    box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
	    background-color: #fff;
	}
	
	/* Form elements */
	h2 {
	    text-align: center;
	    margin-bottom: 30px;
	}
	
	.alert {
	    margin-bottom: 20px;
	    padding: 15px;
	    border-radius: 10px;
	}
	
	.alert-danger {
	    background-color: #f2dede;
	    color: #a94436;
	}
	
	.input-group {
	    margin-bottom: 20px;
	}
	
	.input-group-addon {
	    background-color: #f5f5f5;
	    border: none;
	    padding: 10px;
	    font-size: 16px;
	}
	
	.form-control {
	    border-radius: 10px;
	    padding: 10px;
	}
	
	.form-control:focus {
	    border-color: #66afe9;
	    outline: none;
	}
	
	/* Submit button */
	input[type="submit"] {
	    background-color: #4CAF50;
	    color: #fff;
	    border: none;
	    padding: 12px 20px;
	    border-radius: 10px;
	    cursor: pointer;
	    transition: background-color 0.3s ease;
	}
	
	input[type="submit"]:hover {
	    background-color: #3e8e41;
	}
</style>

</head>
<body>
	<form action="/webprchieu5/login" method="post">	
		<h2>Log in</h2>
		<c:if test="${alert !=null}">
			<h3 class="alert alert danger">${alert}</h3>
		</c:if>
		<section>
			<label class="input login-input"> 
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fa-user"></i></span>
				<input type="text" placeholder="Tài khoản" name="username" class="form-control">
				</div>
			</label>
		</section>
		<section>
			<label class="input login-input"> 
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fa-user"></i></span>
				<input type="password" placeholder="Mật khẩu" name="password" class="form-control">
				</div>
			</label>
		</section>
		<section>
			<label class="input login-input"> 
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fa-user"></i></span>
				<input type="checkbox" name="rememberme" class="form-control">Nhớ tôi
				<a href="/webprchieu5/resetpassword">Forgot password</a>
				</div>
			</label>
		</section>
		<section>
			<label class="input login-input"> 
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fa-user"></i></span>
				<input type="submit" value="Login" class="form-control">
				</div>
			</label>
		</section>
	</form>
</body>
</html>