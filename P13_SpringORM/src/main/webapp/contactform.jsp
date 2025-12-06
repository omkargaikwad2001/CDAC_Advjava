<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="container mt-5">
	<h1 class="mb-4">Contact Form</h1>

	<f:form action="${pageContext.request.contextPath}/${ct.cid == 0 ? 'insert' : 'update'}"
        modelAttribute="ct" class="row g-3">

    <f:hidden path="cid"/> <!-- required for update -->


		<div class="col-md-6">
			<label>UID</label>
			<f:input path="uid" class="form-control" />
		</div>
		<div class="col-md-6">
			<label>Password</label>
			<f:input path="password" class="form-control" />
		</div>
		<div class="col-md-6">
			<label>First Name</label>
			<f:input path="fname" class="form-control" />
		</div>
		<div class="col-md-6">
			<label>Last Name</label>
			<f:input path="lname" class="form-control" />
		</div>
		<div class="col-12">
			<label>Email</label>
			<f:input path="email" class="form-control" />
		</div>
		<div class="col-12">
			<label>Contact No</label>
			<f:input path="contactno" class="form-control" />
		</div>
		<div class="col-12">
			<label>Birth Date</label>
			<f:input path="bdate" type="date" class="form-control" />
		</div>
		<div class="col-12">
			<button type="submit" class="btn btn-primary">Save Contact</button>
		</div>
	</f:form>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
