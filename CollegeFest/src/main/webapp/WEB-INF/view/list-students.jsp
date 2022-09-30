<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Student List</title>
</head>

<body>

	<div class="container">

		<h3>Student List</h3>
		<hr>

		<!-- Add a search form -->
		
		
			<!-- Add a button -->
			<a href="/CollegeFest/fest/showFormForAdd"
				class="btn btn-primary btn-sm mb-3"> Add Student </a> 
		

		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Name</th>
					<th>Country</th>
					<th>Department</th>
					<th>Action</th>
					
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${student}" var="tempStudent">
					<tr>
						<td><c:out value="${tempStudent.name}" /></td>
						<td><c:out value="${tempStudent.department}" /></td>
						<td><c:out value="${tempStudent.country}" /></td>
						<td><a href="/CollegeFest/fest/showFormForUpdate?id=${tempStudent.id}" class="btn btn-info btn-sm">Update</a>
						    <a href="/CollegeFest/fest/delete?id=${tempStudent.id}" class="btn btn-danger btn-sm">Delete</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

</body>
</html>


