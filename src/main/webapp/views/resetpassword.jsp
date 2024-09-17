<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body {
	  font-family: Arial, sans-serif;
	  background-color: #f0f0f0;
	  display: flex;
	  flex-direction: column;
	  justify-content: center;
	  align-items: center;
	  height: 100vh;
	}
	
	h1 {
	  text-align: center;
	  margin-bottom: 20px;
	}
	
	label {
	  display: block;
	  margin-bottom: 10px;
	}
	
	input[type="text"] {
	  width: 300px;
	  padding: 12px 20px;
	  margin: 8px 0;
	  box-sizing: border-box;
	  border: 2px solid #ccc;
	  border-radius: 4px;
	}
	
	button {
	  background-color: #4CAF50;
	  color: white;
	  padding: 14px 20px;
	  margin: 8px 0;
	  border: none;
	  cursor: pointer;
	  width: 300px;
	}
	
	button:hover {
	  opacity: 0.8;
	}
</style>
</head>
<body>
	<form action="/webprchieu5/resetpassword" method="post">
		<c:if test="${alert !=null}">
			<h3 class="alert alert danger">${alert}</h3>
		</c:if>
		<h1>Forgot password</h1>
		<label for="email"><b>Enter email</b></label>
			<input type="text" placeholder="Enter Email" name="email" required>
		<label for="newpass"><b>Enter new password</b></label>
			<input type="text" placeholder="Enter New password" name="newpass" required>
		<label for="re-newpass"><b>Re-enter new password</b></label>
			<input type="text" placeholder="Re-enter New password" name="re-newpass" required>
		<button type="submit" class="resetbutton">Reset password</button>
	</form>
</body>
</html>