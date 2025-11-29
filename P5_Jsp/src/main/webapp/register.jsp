<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>This is registration form</h1>
	
	<form action="createBean.jsp">
		
		<label>Enter Uid</label>
		<input type="text" name="uid">
		<br><br>
		
		<label>Enter First name</label>
		<input type="text" name="fname">
		<br><br>
		
		<label>Enter Middle name</label>
		<input type="text" name="mname">
		<br><br>
		
		<label>Enter Last name</label>
		<input type="text" name="lname">
		<br><br>
		
		<label>Enter Email</label>
		<input type="text" name="email">
		<br><br>
		
		<label>Enter Contact</label>
		<input type="text" name="contact">
		<br><br>
		
		<label>Enter Addess</label>
		<input type="text" name="address">
		<br><br>
		
		<input type="submit" value="Submit">
	</form>

</body>
</html>