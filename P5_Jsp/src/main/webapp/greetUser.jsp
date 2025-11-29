<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Greeting</title>
</head>
<body>

	<%
	Calendar cal = Calendar.getInstance();
	int hr = cal.get(Calendar.HOUR_OF_DAY);
	%>

	Current Hour:
	<%=hr%>
	<br>
	<br>

	<%
	if (hr > 6 && hr < 12) {
	%>
	<%="Good Morning"%>
	<%
	} else if (hr >= 12 && hr <= 17) {
	%>
	<%="Good Afternoon"%>
	<%
	} else {
	%>
	<%="Good Night"%>
	<%
	}
	%>

</body>
</html>
