package com.spring.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.library.impl.Library;
import com.spring.library.model.Book;
import com.spring.library.model.Student;
@Controller
public class StudentController {
	@Autowired
	Library li;
	@RequestMapping(value="/student.htm")
	public String Category(Model model){
		model.addAttribute("student", new Student());
		return "student";
	}
	@RequestMapping(value="/create_student.htm",method=RequestMethod.POST)
	public String Data(Model model,@ModelAttribute(value="student")Student std){
		li.saveStudent(std);
		model.addAttribute("studentList", li.getStudents());
		return "studentinfo";
	}
	@RequestMapping(value="/studentinfo.htm")
	public String addList(Model model){
		model.addAttribute("studentList",li.getStudents());
		return "studentinfo";
	}
		@RequestMapping(value="/deleteStudent/{id}")
		public String deleteStudent(Model model,@PathVariable(value="id")int id){
			li.deleteStudent(id);
			return "redirect:/studentinfo.htm";
		}
		
		@RequestMapping(value="/updateStudent/{id}")
		public String updateStudent(Model model,@PathVariable(value="id")int id){
			//li.deleteStudent(id);
			return "student";
		}
		
		
}