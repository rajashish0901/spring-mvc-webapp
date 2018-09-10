package com.example.mvc.springwebapp.repository;

import com.example.mvc.springwebapp.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt on 5/16/17.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
