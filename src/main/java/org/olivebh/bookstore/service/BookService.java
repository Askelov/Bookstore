package org.olivebh.bookstore.service;


import org.olivebh.bookstore.model.BookEntity;

import org.olivebh.bookstore.model.inputEntities.BookEntityInput;
import org.olivebh.bookstore.model.inputEntities.BookInput;

import java.util.List;

//@Component
public interface BookService {

    BookEntity findById(Long id);

    List<BookEntity> getAllBooks();

    BookEntity saveBook(BookEntityInput bookEntityInput);

    BookEntity updateBookById(BookInput input, Long id);

    void deleteBooks();

    void deleteBook(Long id);

}
