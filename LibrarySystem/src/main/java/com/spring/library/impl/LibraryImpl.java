package com.spring.library.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.library.dto.BookDTO;
import com.spring.library.model.Book;
import com.spring.library.model.BookRent;
import com.spring.library.model.Category;
import com.spring.library.model.Student;

@Repository
@org.springframework.transaction.annotation.Transactional
public class LibraryImpl implements Library  {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Book.class).list();
	}

	public void saveBook(Book book) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(book);
			
	}
	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.getCurrentSession();
		Book bo=(Book)s.get(Book.class,id);
		s.delete(bo);
		s.flush();
		}
	
	public List<Book> searchBook(Book book) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Book search_book=(Book) session.get(Book.class, book.getId());
		List<Book> s=new ArrayList<Book>();
		s.add(search_book);
		return s;
	}
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.getCurrentSession();
		s.saveOrUpdate(book);
	}

	
	public BookDTO getBookById(int id) {
		// TODO Auto-generated method stub
		Criteria c=sessionFactory.getCurrentSession()
				.createCriteria(Book.class)
				.createAlias("c","c",JoinType.LEFT_OUTER_JOIN).createAlias("st","s",JoinType.LEFT_OUTER_JOIN);
		c.add(Restrictions.eq("id",id));
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"),"id")
				.add(Projections.property("name"),"name")
				.add(Projections.property("author"),"author")
				.add(Projections.property("isbn"),"isbn")
				.add(Projections.property("c.id"),"categoryId")
				.add(Projections.property("s.id"),"studentId"));
		c.setResultTransformer(Transformers.aliasToBean(BookDTO.class));
				return (BookDTO)c.uniqueResult();
	}
	
	
	
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Student.class).list();	}

	
	public Serializable saveStudent(Student std) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().save(std);
	}
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.getCurrentSession();
		Student stu=(Student)s.get(Student.class,id);
		s.delete(stu);
		s.flush();

	}
	
	
	
	public void saveCategory(Category cate) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(cate);
	}

	public List<Category> getCategory() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Category.class).list();
		}
	public void deletecategory(int id) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.getCurrentSession();
		Category ca=(Category)s.get(Category.class,id);
		s.delete(ca);
		s.flush();
	}
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Category.class);
		c.add(Restrictions.eq("id",id));
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"),"id")
				.add(Projections.property("name"),"name")
				.add(Projections.property("description"),"description"));
				
		c.setResultTransformer(Transformers.aliasToBean(BookDTO.class));
				return (Category)c.uniqueResult();	}

	


	public void saveBookRent(BookRent br) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(br);
	}

	public List<BookRent>  getBookRent() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(BookRent.class).list();	}

	public void deleteBookRent(int id) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.getCurrentSession();
		BookRent b=(BookRent)s.get(BookRent.class,id);
		s.delete(b);
		s.flush();
	}
}

	

	

	

