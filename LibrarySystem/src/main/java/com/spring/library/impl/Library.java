package com.spring.library.impl;

import java.io.Serializable;
import java.util.List;

import com.spring.library.dto.BookDTO;
import com.spring.library.model.Book;
import com.spring.library.model.BookRent;
import com.spring.library.model.Category;
import com.spring.library.model.Student;

public interface Library {
	public List<Book> getBooks();
	public void saveBook(Book book);
	public List<Book> searchBook(Book book);
	public void deleteBook(int id);
	public void updateBook(Book book);
	public BookDTO getBookById(int id);
	
	public Serializable saveStudent(Student std);
	public List<Student> getStudents();
	public void deleteStudent(int id);

	
	public void saveCategory(Category cate);
	public List<Category> getCategory();
	public void deletecategory(int id);
	public Category getCategoryById(int id);


	
	public void saveBookRent(com.spring.library.model.BookRent br);
	public List<BookRent> getBookRent();
	public void deleteBookRent(int id);
	
	
}
