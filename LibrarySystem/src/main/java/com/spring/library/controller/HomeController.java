package com.spring.library.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.library.dto.BookDTO;
import com.spring.library.impl.Library;
import com.spring.library.impl.LibraryImpl;
import com.spring.library.model.Book;

@Controller
public class HomeController {
	@Autowired
	Library li;
	@RequestMapping(value="/index.htm")
	public String welcome(Model model){
		model.addAttribute("book", new BookDTO());
		model.addAttribute("category",li.getCategory());
		model.addAttribute("student",li.getStudents());
		return "book";
	}
	/*@RequestMapping(value="/postInfo.htm",method=RequestMethod.POST)
	public String submitData(Model model,@ModelAttribute(value="book") Book book){
		li.saveBook(book);
		model.addAttribute("bookList", li.getBooks());
		return "bookinfo";
	}*/
	@RequestMapping(value="/postInfo.htm",method=RequestMethod.POST)
	public String AddBook(Model model,@ModelAttribute(value="book") BookDTO book){
		Book b=new Book();
		if(book.getId()!= 0){
			b.setId(book.getId());
		}
		b.setName(book.getName());
		b.setAuthor(book.getAuthor());
		b.setIsbn(book.getIsbn());
		b.getC().setId(book.getCategoryId());
		b.getSt().setId(book.getStudentId());
		li.saveBook(b);
		model.addAttribute("bookList", li.getBooks());
		return "redirect:/bookinfo.htm";
	}
	@RequestMapping(value="/bookinfo.htm")
	public String bookList(Model model){
		model.addAttribute("bookList",li.getBooks());
		return "bookinfo";
	}
	@RequestMapping(value="/deleteBook/{id}")
	public String deleteBook(Model model,@PathVariable(value="id")int id){
		li.deleteBook(id);
		return "redirect:/bookinfo.htm";
	}
	@RequestMapping(value="/book.htm",method=RequestMethod.POST ,params = { "search" })
	public String SearchBook(Model model,@ModelAttribute(value="book") Book book) {
		model.addAttribute("bookList",li.searchBook(book)); 
		  return "bookinfo";		
	}
	
	@RequestMapping(value="/updateBook/{id}")
	public String updateBook(Model model,@PathVariable(value="id") int id) {
		//li.getBookById(id);
		model.addAttribute("student",li.getStudents());
		model.addAttribute("category",li.getCategory());
		model.addAttribute("book",li.getBookById(id));
		  return "book";
	}
	
	
	
	
	//End Tag
	}
	


