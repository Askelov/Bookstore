package org.olivebh.bookstore.service;


import org.olivebh.bookstore.model.BookEntity;
import org.olivebh.bookstore.model.dto.BookDto;
import org.olivebh.bookstore.model.inputEntities.BookInput;

import java.util.List;

//@Component
public interface BookService {

    BookEntity findById(Long id);

    List<BookEntity> getAllBooks();

    BookDto save(BookDto bookDto);

    BookEntity updateBookById(BookInput input, Long id);

    void deleteBooks();

    void deleteBook(Long id);

}
