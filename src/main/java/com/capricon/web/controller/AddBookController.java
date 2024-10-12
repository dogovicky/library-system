package com.capricon.web.controller;

import java.io.IOException;

import com.capricon.web.dao.DataDAO;
import com.capricon.web.model.Author;
import com.capricon.web.model.Book;
import com.capricon.web.model.Department;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@SuppressWarnings("serial")
//@WebServlet("/AddBookServlet")
public class AddBookController extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DataDAO dataDao = new DataDAO();
		
		String bookId = request.getParameter("bookId");
		String bookTitle = request.getParameter("bookTitle");
		String departmentId = request.getParameter("departmentId");
		
		
		String authorId = request.getParameter("authorId");
		String authorName = request.getParameter("authorName");
		
		Department department = new Department();
		department.setDepartmentId(departmentId);
		
		Author author = new Author();
		author.setAuthorId(authorId);
		author.setAuthorName(authorName);
		
		/*List<Author> authors = new ArrayList<Author>();
		authors.add(author);
		
		Book book = new Book();
		book.setBookId(bookId);
		book.setBookTitle(bookTitle);
		book.setDepartment(department);
		
		
		dataDao.saveAuthor(author);
		dataDao.saveBook(book);
		
		RequestDispatcher rd = request.getRequestDispatcher("books.jsp");
		rd.forward(request, response);
		
		
	}*/

}
