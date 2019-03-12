package org.olivebh.bookstore.controller;


import org.olivebh.bookstore.model.BookEntity;
import org.olivebh.bookstore.model.dto.BookDto;
import org.olivebh.bookstore.model.inputEntities.BookInput;
import org.olivebh.bookstore.service.BookService;
import org.olivebh.bookstore.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.olivebh.bookstore.util.Utils.checkValidNumber;

@RestController
@RequestMapping(path = Constant.ROOT_BOOK)
public class BookEntityControler {

    //    @Autowired
    private BookService bookService;

    @Autowired
    public BookEntityControler(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    BookEntity save(@RequestBody BookEntity bookEntity) {
        return bookService.save(bookEntity);
    }

    @GetMapping(path = "/{id}")
    public BookEntity getPageById(@PathVariable("id") String id){
        Long validId = checkValidNumber(id);
        return bookService.findById(validId);
    }

    @GetMapping
    public List<BookEntity> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PutMapping(path="/{id}")
    public BookEntity updatePage(@RequestBody BookInput input, @PathVariable("id") String id){
        Long validId = checkValidNumber(id);
        return bookService.updateBookById(input,validId);
    }

    @DeleteMapping()
    public void deleteBooks() {
        bookService.deleteBooks();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteBooks(@PathVariable("id") String id){
        Long validId = checkValidNumber(id);
        bookService.deleteBook(validId);
    }

}
