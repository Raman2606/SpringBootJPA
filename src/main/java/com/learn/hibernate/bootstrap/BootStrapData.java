package com.learn.hibernate.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learn.hibernate.model.Author;
import com.learn.hibernate.model.Book;
import com.learn.hibernate.model.Publisher;
import com.learn.hibernate.repository.AuthorRepository;
import com.learn.hibernate.repository.BookRepository;
import com.learn.hibernate.repository.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner{

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;	
	private final PublisherRepository publisherRepository;
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}
	@Override
	public void run(String... args) throws Exception {

		Publisher publisher = new Publisher("Tata McGraw Hill","AddressLine1", "Palia", 262902L, "UP");
		publisherRepository.save(publisher);
		System.out.println("Publishers added successfully : "+publisherRepository.count());
		
		Author eric = new Author("Eric", "Evans");
		Book book = new Book("cb", "1234");
		eric.getBooks().add(book);
		book.getAuthors().add(eric);
		publisher.getBooks().add(book);
		book.setPublisher(publisher);
		authorRepository.save(eric);
		bookRepository.save(book);
		publisherRepository.save(publisher);
		
		System.out.println("Data should have been saved");
		System.out.println("Number of books now : "+ bookRepository.count());
	}

}
