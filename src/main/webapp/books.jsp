<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${departmentName} Books</title>
</head>
<body>

	<div class="container">
		<h4>${departmentId} ${departmentName}</h4>
		<div class="books">
		
			<c:if test="${books} == NULL ">
				<h4>These department does not have books currently</h4>
			</c:if>
		
			<ul>
				<c:forEach var="book" items="${books}">
					<li>
						<h4>${book.bookTitle}</h4>
						<c:forEach var="author" items="${authors}">
							<h4>${author.authorName}</h4>
						</c:forEach>
						<button><a href="DeleteBook?bookId=${book.bookId}">Delete Book</a></button>
					</li>
				</c:forEach>
			</ul>
			<button><a href="addbook.jsp">Add New Book</a></button>
		</div>
	</div>

</body>
</html>