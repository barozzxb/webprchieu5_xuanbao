<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	h1 {
	    text-align: center;
	    margin-bottom: 30px;
	}
	
	p {
	    text-align: center;
	    margin-bottom: 20px;
	}
	
	label {
	    display: block;
	    margin-bottom: 10px;
	}
	
	input[type="text"],
	input[type="password"],
	input[type="checkbox"] {
	    width: 100%;
	    padding: 12px 20px;
	    margin: 8px 0;
	    display: inline-block;
	    border: 1px solid #ccc;
	    border-radius: 4px;
	    box-sizing: border-box;
	}
	
	input[type="checkbox"] {
	    margin-right: 5px;
	}
	
	button {
	    background-color: #4CAF50;
	    color: white;
	    padding: 14px 20px;
	    margin: 8px 0;
	    border: none;
	    cursor: pointer;
	    width: 100%;
	}
	
	button:hover {
	    opacity: 0.8;
	}
	
	.cancelbtn {
	    background-color: #f44336;
	}
	
	.clearfix {
	    overflow: auto;
	}
	
	.clearfix::after {
	    content: "";
	    clear: both;
	    display: table;
	}
</style>
</head>
<body>
	<form action="/webprchieu5/signup" style="border:1px solid #ccc" method="post">
	  <div class="container">
	  	<c:if test="${alert !=null}">
			<h3 class="alert alert danger">${alert}</h3>
		</c:if>
	    <h1>Sign Up</h1>
	    <p>Please fill in this form to create an account.</p>
	    <label for="username"><b>Username</b></label>
	    <input type="text" placeholder="Enter Username" name="username" required>
		
		<label for="fullname"><b>Full name</b></label>
	    <input type="text" placeholder="Enter full name" name="fullname" required>
		
	    <label for="email"><b>Email</b></label>
	    <input type="text" placeholder="Enter Email" name="email" required>
		    
		<label for="phone"><b>Username</b></label>
	    <input type="text" placeholder="Enter Phone number" name="phone" required>
	
	    <label for="password"><b>Password</b></label>
	    <input type="password" placeholder="Enter Password" name="password" required>
	
	    <label for="psw-repeat"><b>Repeat Password</b></label>
	    <input type="password" placeholder="Repeat Password" name="psw-repeat" required>
	
	    <label>
	      <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
	    </label>
	
	    <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>
	
	    <div class="clearfix">
	      <button type="button" class="cancelbtn">Cancel</button>
	      <button type="submit" class="signupbtn">Sign Up</button>
	    </div>
	  </div>
	</form>
</body>
</html>