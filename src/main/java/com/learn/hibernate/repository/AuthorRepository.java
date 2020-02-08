package com.learn.hibernate.repository;

import org.springframework.data.repository.CrudRepository;

import com.learn.hibernate.model.Author;



public interface AuthorRepository extends CrudRepository<Author, Long> {

}
