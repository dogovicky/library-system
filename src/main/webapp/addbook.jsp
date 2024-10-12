<%@page import="com.capricon.web.model.Department"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Book</title>
</head>
<body>
	
	<div class="container">
		<h4>Add New Book</h4>
		<div class="form-container">
			<form action="BooksServlet" method="post">
				<div class="input-box">
					<input type="text" name="bookId" placeholder="Book Id..." />
				</div>
				<div class="input-box">
					<input type="text" name="bookTitle" placeholder="Book Title..." />
				</div>
				
				<div class="input-box">
					<input type="text" name="departmentId" value="${departmentId}" />
				</div>
				
				<div class="author-box">
					<h4>Input the Author details here, specify all authors if they are more than one!</h4>
					<div class="input-box">
						<input type="text" name="authorName" placeholder="Author Names..."/>
					</div>
				</div>
								
				<button type="submit">Add Book</button>
			</form>
		</div>
	</div>
	
</body>
</html>