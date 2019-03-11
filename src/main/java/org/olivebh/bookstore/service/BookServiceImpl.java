package org.olivebh.bookstore.service;

import org.olivebh.bookstore.model.BookEntity;
import org.olivebh.bookstore.model.dto.BookDto;
import org.olivebh.bookstore.model.inputEntities.BookInput;
import org.olivebh.bookstore.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

    private IBookRepository bookRepository;

    @Autowired
    public BookServiceImpl(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookEntity> getAllBooks(){
        return bookRepository.findAll();
    }


    @Override
    public BookEntity findById(Long id) {
        return bookRepository.getBookEntityById(id);
    }

    @Override
 //   @Transactional
    public BookEntity save(BookEntity bookEntity) {
      //  BookEntity bookToSave = bookDto.toPojo();
        return bookRepository.save(bookEntity);
    }
    @Override
    public BookEntity updateBookById(BookInput input, Long id){
        BookEntity foundBook= bookRepository.getBookEntityById(id);
        foundBook.setGenre(input.getGenre());
        foundBook.setTitle(input.getTitle());
        return bookRepository.save(foundBook);
    }

    @Override
    public void deleteBooks(){
        bookRepository.deleteAll();
    }

    @Override
    public void deleteBook(Long id){
        bookRepository.delete(bookRepository.getBookEntityById(id));
    }
}