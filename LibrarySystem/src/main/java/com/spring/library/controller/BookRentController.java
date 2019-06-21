package com.spring.library.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.library.impl.Library;
import com.spring.library.model.Book;

@Controller
public class BookRentController {
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,true));
	}
	@Autowired
	Library li;
	@RequestMapping(value="/bookrent.htm")
	public String BookRent(Model model){
		model.addAttribute("bookrent", new Book());
		return "bookrent";
	}
	@RequestMapping(value="/bookrent_list.htm",method=RequestMethod.POST)
	public String submitData(Model model,@ModelAttribute(value="bookrent")com.spring.library.model.BookRent br){
		li.saveBookRent(br);
		model.addAttribute("bookrentList", li.getBookRent());
		return "bookrentinfo";
	
	}
	@RequestMapping(value="/bookrentinfo.htm")
	public String bookList(Model model){
		model.addAttribute("bookrentList",li.getBookRent());
		return "bookrentinfo";
	}
		@RequestMapping(value="/deleteBookRent/{id}")
		public String deleteBookRent(Model model,@PathVariable(value="id")int id){
			li.deleteBookRent(id);
			return "redirect:/bookrentinfo.htm";
		}
}
