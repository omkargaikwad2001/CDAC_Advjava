<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="userifo" class="beans.User" scope="request"></jsp:useBean>
	UID = <jsp:getProperty name="userifo" property="uid" /><br><br>
	First Name = <jsp:getProperty name="userifo" property="fname" /><br><br>
	Middle Name = <jsp:getProperty name="userifo" property="mname" /><br><br>
	Last Name = <jsp:getProperty name="userifo" property="lname" /><br><br>
	Email = <jsp:getProperty name="userifo" property="email" /><br><br>
	Contact = <jsp:getProperty name="userifo" property="contact" /><br><br>
	Address = <jsp:getProperty name="userifo" property="address" /><br><br>

</body>
</html>