package com.example.mvc.springwebapp.repository;

import com.example.mvc.springwebapp.model.Book;
import com.example.mvc.springwebapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublishRepository extends CrudRepository<Publisher, Long> {

}
