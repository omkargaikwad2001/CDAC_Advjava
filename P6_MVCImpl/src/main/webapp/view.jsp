<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Welcome ${user.fname} ${user.lname}</h1>
	<p>Email : ${user.email}</p>
	<p>Contact : ${requestScope.user.contact}</p>
	<p>Address:</p>
	<p>Area:${user.address.area}</p>
	<p>city:${user.address.city}</p>
	<p>pincode:${user.address.pincode}</p>
	
</body>
</html>