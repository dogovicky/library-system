package com.capricon.web.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.capricon.web.dao.DataDAO;
import com.capricon.web.model.Book;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/DeleteBook")
public class DeleteBookController extends HttpServlet {

	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataDAO dataDao = new DataDAO();
		Session session = dataDao.session();
		Transaction tx = session.getTransaction();
		tx.begin();
		
		try {
			
			String bookId = request.getParameter("bookId");
			Book book = dataDao.getBookById(bookId, session);
			
			if(book != null) {
				
				book = (Book) session.merge(book);
				
				Hibernate.initialize(book.getAuthors());
				session.delete(book);
			}
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		tx.commit();
		response.sendRedirect("department.jsp");

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
