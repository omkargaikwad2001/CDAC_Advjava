<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		${cookie.loginFailed.value}
	<form action="/P4_Shoppingapp/LoginCheck" method="post">
				
		<label>Enter UID</label>
		<input type="text" name="uid">
		
		<br>
		<br>
		
		<label>Enter PASS</label>
		<input type="password" name="pass">
		
		<br>
		<br>
		
		<input type="submit" value="Login">
		
		
	</form>

</body>
</html>