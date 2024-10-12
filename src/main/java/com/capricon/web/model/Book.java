package com.capricon.web.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	@Id
	private String bookId;
	private String bookTitle;
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinTable(name = "books_authors", 
			joinColumns = @JoinColumn(referencedColumnName = "bookId"), 
			inverseJoinColumns = @JoinColumn(referencedColumnName = "authorId"))
	Set<Author> authors = new HashSet<Author>();
	@ManyToOne(cascade = CascadeType.PERSIST) 
	@JoinColumn(name = "departmentId", nullable = false)
	private Department department;

	
	
	public Book() {
		super();
	}
	public Book(String bookId, String bookTitle, Set<Author> authors, Department department) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.authors = authors;
		this.department = department;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	public Set<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	

}
