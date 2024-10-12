package com.capricon.web.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import com.capricon.web.model.Author;
import com.capricon.web.model.Book;
import com.capricon.web.model.Department;

//fetch all books data
public class DataDAO {
	
	//returns the session we will be working on. Fetching books, authors and departments will be carried out in one session
	public Session session() {
		
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Department.class).addAnnotatedClass(Author.class).addAnnotatedClass(Book.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		SessionFactory sf = cfg.buildSessionFactory(reg);
		Session session = sf.openSession();
		
		
		return session;
		
	}
	
	//get departments
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Department> getDepartments() {
		
		Transaction tx = session().getTransaction();
		tx.begin();
		
		Query<Department> depQuery = session().createQuery("from Department");
		List<Department> departments = depQuery.list();
		tx.commit();
		
		return departments;
		
	}
	
	//fetch books of the respective department
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Book> getBooks(Department department) {
		
		//Transaction tx = session().getTransaction();
		//tx.begin();
		
		Query<Book> booksQuery = session().createQuery("from Book where department = :id");
		booksQuery.setParameter("id", department);
		
		List<Book> books = booksQuery.list();
		//tx.commit();
		session().close();
		return books;
		
	}
	
	//save new books and the respective authors
	public void saveBook(Book book) {
		Transaction tx = session().getTransaction();
		tx.begin();
		
		//Department department = session().get(Department.class, book.getDepartment().getDepartmentId());
		
		//book.setDepartment(department);
		
		session().persist(book);
		tx.commit();

	}
	
	//save author

	public void saveAuthor(Author author) {
		Transaction tx = session().getTransaction();
		tx.begin();
		session().persist(author);
		tx.commit();
		
	}
	
	//get department by id

	public Department getDepartmentById(String departmentId, Session session) {
		
		Department department = session().get(Department.class, departmentId);
		return department;
		
	}
	
	//get author name 
	@SuppressWarnings({ "deprecation", "unchecked" })
	public Author getAuthorByName(String authorName, Session session) {
		//Transaction tx = session().getTransaction();
		//tx.begin();
		Query<Author> getAuthor = session().createQuery("from Author where authorName = :name");
		getAuthor.setParameter("name", authorName);
		
		Author author = getAuthor.uniqueResult();

		return author;
	}
	
	//delete book from department
	@SuppressWarnings({ "unchecked", "deprecation" })
	public Book getBookById(String bookId, Session session) {
		//Transaction tx = session().getTransaction();
		//tx.begin();
		
		Book book = session().get(Book.class, bookId);
		
		//tx.commit();
		return book;
	}

}






















