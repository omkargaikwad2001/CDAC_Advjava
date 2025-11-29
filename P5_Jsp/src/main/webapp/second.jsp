<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Learning Demo</title>

<!-- Bootstrap (for design only) -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">

</head>
<body class="p-4">

	<%!// ======= DECLARATION TAG =========
	int visitCount = 0;

	String greet(String name) {
		return "Hello " + name + ", welcome to JSP!";
	}%>

	<div class="container">

		<h1 class="text-primary">JSP Learning Demo 🌟</h1>
		<hr>

		<!-- ====== Expression Tag ====== -->
		<h3>
			Current Time:
			<%=new Date()%></h3>

		<!-- ====== Scriptlet Tag (loops) ====== -->
		<h4>Numbers (Using Scriptlet):</h4>
		<p>
			<%
			for (int i = 1; i <= 5; i++) {
				out.print(i + " ");
			}
			%>
		</p>

		<hr>

		<!-- ====== Form Input Handling ====== -->
		<h3>Enter Your Name</h3>

		<form method="post">
			<input type="text" name="username" class="form-control w-50"
				placeholder="Enter your name">
			<button class="btn btn-success mt-2">Submit</button>
		</form>

		<%
		String uname = request.getParameter("username");
		if (uname != null && !uname.isEmpty()) {
		%>
		<div class="alert alert-info mt-3">
			<strong><%=greet(uname)%></strong>
		</div>
		<%
		}
		%>

		<hr>

		<!-- ====== Session Handling ====== -->
		<%
		session.setAttribute("demoUser", "Omkar123");
		%>

		<h4>Session Data:</h4>
		<p>
			User from session: <strong><%=session.getAttribute("demoUser")%></strong>
		</p>

	</div>

</body>
</html>
