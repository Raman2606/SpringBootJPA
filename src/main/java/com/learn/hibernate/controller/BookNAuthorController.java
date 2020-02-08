package com.learn.hibernate.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.hibernate.model.Book;
import com.learn.hibernate.repository.BookRepository;

@RestController
@RequestMapping(value = "/bookNAuthors")
public class BookNAuthorController {

	@Autowired
	private  BookRepository bookRepository;
	@GetMapping(value = "/getBook/{bookId}")
	public Optional<Book> getBook(@PathVariable(name = "bookId") Long id) {
		return bookRepository.findById(id);
		
	}
	@GetMapping(value = "/getBooks")
	public Iterable<Book> getBook() {
		return bookRepository.findAll();
		
	}
}
