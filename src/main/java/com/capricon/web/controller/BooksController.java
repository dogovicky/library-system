package com.capricon.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

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


@WebServlet("/BooksServlet")
public class BooksController extends HttpServlet {

	DataDAO dataDao = new DataDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String departmentId = request.getParameter("departmentId");
		Department department = new Department();
		department.setDepartmentId(departmentId);
		
		List<Book> books = dataDao.getBooks(department);
		Set<Author> authors = new HashSet<Author>();
		for(Book book : books) {
			authors = book.getAuthors();
			
		}
		
		request.setAttribute("books", books);
		request.setAttribute("authors", authors);
		session.setAttribute("departmentId", departmentId);
		
		RequestDispatcher rd = request.getRequestDispatcher("books.jsp");
		rd.forward(request, response);
		
	}

	
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String bookId = request.getParameter("bookId");
		String bookTitle = request.getParameter("bookTitle");
		String departmentId = request.getParameter("departmentId");
		
		Session session = dataDao.session();
		Transaction transaction = session.beginTransaction();
		
		if (departmentId == null || departmentId.trim().isEmpty()) {
		    throw new IllegalArgumentException("Department ID cannot be null or empty.");
		}

		String authorNamesString = request.getParameter("authorName");
		String[] authorNames = authorNamesString.split(",");
		Book book = new Book();
		book.setBookId(bookId);
		book.setBookTitle(bookTitle);
		
		
		Department department = dataDao.getDepartmentById(departmentId, session);
		book.setDepartment(department);

		Set<Author> authors = new HashSet<Author>();
		for(String authorName : authorNames) {
			authorName = authorName.trim();
			Author author = dataDao.getAuthorByName(authorName, session);
			if(author == null) {
				author = new Author();
				author.setAuthorName(authorName);
				session.save(author);
			}
			
			authors.add(author);
		}
		
		book.setAuthors(authors);
		
		session.save(book);
		transaction.commit();
		
		response.sendRedirect("books.jsp");
		 
	}

}











