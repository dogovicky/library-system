<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Departments</title>
</head>
<body>

	<div class="container">
		<h4>Departments Available</h4>
		<div class="departments">
			<ul>
				<c:forEach var="department" items="${departments}">
					<li>
						<div class="dep-details">
							<span>${department.departmentId}</span>
							<span>${department.departmentName}</span>
						</div>
						<button><a href="BooksServlet?departmentId=${department.departmentId}">View Books</a></button>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>

</body>
</html>