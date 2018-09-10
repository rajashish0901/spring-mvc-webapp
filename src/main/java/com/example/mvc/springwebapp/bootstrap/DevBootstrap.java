package com.example.mvc.springwebapp.bootstrap;

import com.example.mvc.springwebapp.model.Author;
import com.example.mvc.springwebapp.model.Book;
import com.example.mvc.springwebapp.model.Publisher;
import com.example.mvc.springwebapp.repository.AuthorRepository;
import com.example.mvc.springwebapp.repository.BookRepository;
import com.example.mvc.springwebapp.repository.PublishRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 5/16/17.
 */
@Component
//An ApplicationListener
//This approach can be used for running logic after the Spring context has been initialized, so we are not focusing on
// any particular bean, but waiting for all of them to initialize.
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublishRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublishRepository publisherRepository) {
        System.out.println(" ## DevBootstrap::Const ##");
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("## DevBootstrap::onApplicationEvent ##");
        initData();
    }

    private void initData(){
        System.out.println("-- DevBootstrap::initData --");

        Publisher publisher = new Publisher();
        publisher.setName("foo");
        publisher.setAddress("12th Street, LA");
        publisherRepository.save(publisher);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher );
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
