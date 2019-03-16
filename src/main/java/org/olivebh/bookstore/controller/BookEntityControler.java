package org.olivebh.bookstore.controller;


import org.olivebh.bookstore.model.BookEntity;
import org.olivebh.bookstore.model.dto.BookDto;
import org.olivebh.bookstore.model.inputEntities.BookEntityInput;
import org.olivebh.bookstore.model.inputEntities.BookInput;
import org.olivebh.bookstore.service.BookService;
import org.olivebh.bookstore.service.ValidationService;
import org.olivebh.bookstore.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(path = Constant.ROOT_BOOK)
public class BookEntityControler {


    private BookService bookService;
    private ValidationService validationService;

    @Autowired
    public BookEntityControler(BookService bookService, ValidationService validationService) {
        this.bookService = bookService;
        this.validationService = validationService;
    }
   
    @PostMapping
    BookEntity save(@RequestBody BookEntityInput bookEntityInput){
        return bookService.saveBook(bookEntityInput);
    }

    @GetMapping(path = "/{id}")
    public BookEntity getPageById(@PathVariable("id") String id){
        Long validId = validationService.checkValidNumber(id);
        return bookService.findById(validId);
    }

    @GetMapping
    public List<BookEntity> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PutMapping(path="/{id}")
    public BookEntity updatePage(@RequestBody BookInput input, @PathVariable("id") String id){
        Long validId = validationService.checkValidNumber(id);
        return bookService.updateBookById(input,validId);
    }

    @DeleteMapping()
    public void deleteBooks() {
        bookService.deleteBooks();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteBooks(@PathVariable("id") String id){
        Long validId = validationService.checkValidNumber(id);
        bookService.deleteBook(validId);
    }

}
