<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contacts Information</title>
<!-- Bootstrap 5 CSS CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="container mt-5">
	<h1 class="mb-4 text-center">Contacts Information</h1>
	<div class="table-responsive">
		<table class="table table-striped table-hover table-bordered">
			<thead class="table-dark">
				<tr>
					<th>ID</th>
					<th>User ID</th>
					<th>Password</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Contact No</th>
					<th>Bdate</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ct" items="${contactlist}">
					<tr>
						<td>${ct.cid}</td>
						<td>${ct.uid}</td>
						<td>${ct.password}</td>
						<td>${ct.fname}</td>
						<td>${ct.lname}</td>
						<td>${ct.email}</td>
						<td>${ct.contactno}</td>
						<td>${ct.bdate}</td>
						<td><a href="edit/${ct.cid}" class="btn btn-warning btn-sm">Edit</a>
						</td>
						<td><a href="delete/${ct.cid}" class="btn btn-danger btn-sm"
							onclick="return confirm('Are you sure you want to delete this contact?');">
								Delete </a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>

	<a href="save">Add new Contact</a>
</body>
</html>
