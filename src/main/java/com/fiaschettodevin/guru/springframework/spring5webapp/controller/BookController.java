package com.fiaschettodevin.guru.springframework.spring5webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fiaschettodevin.guru.springframework.spring5webapp.repository.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@RequestMapping("/books")
	public String getBooks(Model model) {
		model.addAttribute("books", this.bookRepository.findAll());

		return "books";
	}

}
