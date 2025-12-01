<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>This is Topics.jsp</h1>

	<c:forEach var="i" items="${topics}">
		<a href="comments?cid=${i.topicid}">${i.name}</a>
		<br>
	</c:forEach>


</body>
</html>