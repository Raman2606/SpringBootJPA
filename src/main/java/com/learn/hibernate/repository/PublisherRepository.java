package com.learn.hibernate.repository;

import org.springframework.data.repository.CrudRepository;

import com.learn.hibernate.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{

}
