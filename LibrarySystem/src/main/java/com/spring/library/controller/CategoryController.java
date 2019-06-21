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
import com.spring.library.model.Book;

@Controller
public class CategoryController {
	@Autowired
	Library li;
	@RequestMapping(value="/category.htm")
	public String Category(Model model){
		model.addAttribute("category", new com.spring.library.model.Category());
		return "category";
	}
	@RequestMapping(value="/create_category.htm",method=RequestMethod.POST)
	public String Data(Model model,@ModelAttribute(value="category")com.spring.library.model.Category category){
		li.saveCategory(category);
		model.addAttribute("categoryList", li.getCategory());
		return "categoryinfo";
	}
	
	@RequestMapping(value="/categoryinfo.htm")
	public String categoryList(Model model){
		model.addAttribute("categoryList",li.getCategory());
		return "categoryinfo";
	}
		@RequestMapping(value="/deletecategory/{id}")
		public String deletecategory(Model model,@PathVariable(value="id")int id){
			li.deletecategory(id);
			return "redirect:/categoryinfo.htm";
		}
		
		@RequestMapping(value="/updateCategory/{id}")
		public String updatecategory(Model model,@PathVariable(value="id")int id){
			//li.deletecategory(id);
			model.addAttribute("categoryList",li.getCategoryById(id));
			return "category";
		}
}
