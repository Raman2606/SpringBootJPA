package com.learn.hibernate.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String isbn;

	@ManyToMany()
	@JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name="author_id"))
	private Set<Author> authors = new HashSet<Author>();
	
	@ManyToOne
	private Publisher publisher;
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Book)) {
			return false;
		}
		Book other = (Book) obj;
		return Objects.equals(id, other.id);
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	/**
	 * @return the authors
	 */
	public Set<Author> getAuthors() {
		return authors;
	}
	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the publisher
	 */
	public Publisher getPublisher() {
		return publisher;
	}
	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", isbn=" + isbn + "]";
	}
	public Book(String title, String isbn) {
		super();
		this.title = title;
		this.isbn = isbn;
		
	}
	public Book() {
		
		
	}
}
	