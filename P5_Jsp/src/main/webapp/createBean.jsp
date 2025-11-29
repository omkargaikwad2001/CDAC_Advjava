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
	
	<!-- 1st whay with property and param -->
	<!--<jsp:setProperty name="userifo" property="uid" param="uid"/>
	<jsp:setProperty name="userifo" property="fname" param="fname"/>
	<jsp:setProperty name="userifo" property="mname" param="mname"/>
	<jsp:setProperty name="userifo" property="lname" param="lname"/>
	<jsp:setProperty name="userifo" property="email" param="email"/>
	<jsp:setProperty name="userifo" property="contact" param="contact"/>
	<jsp:setProperty name="userifo" property="address" param="address"/>
	-->
	
	<!-- 2nd whay with only property because param are same-->
	<!--<jsp:setProperty name="userifo" property="uid"/>
	<jsp:setProperty name="userifo" property="fname"/>
	<jsp:setProperty name="userifo" property="mname"/>
	<jsp:setProperty name="userifo" property="lname"/>
	<jsp:setProperty name="userifo" property="email"/>
	<jsp:setProperty name="userifo" property="contact"/>
	<jsp:setProperty name="userifo" property="address"/>
	-->
	
	<jsp:setProperty name="userifo" property="*"/>
	
	<jsp:forward page="display.jsp"></jsp:forward>

</body>
</html>