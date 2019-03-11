package org.olivebh.bookstore.service;


import org.olivebh.bookstore.model.AuthorEntity;
import org.olivebh.bookstore.model.BookEntity;
import org.olivebh.bookstore.model.dto.BookDto;
import org.olivebh.bookstore.model.inputEntities.BookInput;
import org.olivebh.bookstore.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

//@Component
public interface BookService {

    BookEntity findById(Long id);

    List<BookEntity> getAllBooks();

    BookEntity save(BookEntity bookEntity);

    BookEntity updateBookById(BookInput input, Long id);

    void deleteBooks();

    void deleteBook(Long id);


}
