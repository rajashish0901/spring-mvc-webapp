package com.example.mvc.springwebapp.controller;

import com.example.mvc.springwebapp.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 5/18/17.
 */
@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        System.out.println("## BookController::Const()- Initialize BookRepository attr##");
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/getbooks")
    public String getBooks(Model model){

        model.addAttribute("books", bookRepository.findAll());

        return "bookslist";
        //name of the view that will render the data in the model.Changing the name of the
        //view throws error.
        /*2018-09-10 12:01:42.552 ERROR 10815 --- [nio-8181-exec-1] org.thymeleaf.TemplateEngine
              : [THYMELEAF][http-nio-8181-exec-1] Exception processing template "book": Error resolving template "book",
              template might not exist or might not be accessible by any of the configured Template Resolvers
        org.thymeleaf.exceptions.TemplateInputException: Error resolving template "book", template might not exist
        or might not be accessible by any of the configured Template Resolvers*/

    }
}
