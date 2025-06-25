package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.BookDAO;
import com.example.demo.entity.Book;

// import ch.qos.logback.core.model.Model;

@Controller
public class BookController {

	@Autowired
	private BookDAO dao;
	
	
	@GetMapping("/book/insert")
	public void insertForm() {
		
	}
	
	@PostMapping("/book/insert")
	public String insertSubmit(Book book) {
		dao.save(book);
		return "redirect:/book/list";
	}
	
	@GetMapping("/book/list")
	public void list(Model model) {
		model.addAttribute("list", dao.findAll());
	}
	
}
