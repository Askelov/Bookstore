package org.olivebh.bookstore.service.impl;

import org.olivebh.bookstore.exception.EntityAlreadyExist;
import org.olivebh.bookstore.exception.EntityNotFound;
import org.olivebh.bookstore.model.AuthorEntity;
import org.olivebh.bookstore.model.BookEntity;
import org.olivebh.bookstore.model.dto.BookDto;
import org.olivebh.bookstore.model.inputEntities.BookEntityInput;
import org.olivebh.bookstore.model.inputEntities.BookInput;
import org.olivebh.bookstore.repository.IAuthorRepository;
import org.olivebh.bookstore.repository.IBookRepository;
import org.olivebh.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

    private final IBookRepository bookRepository;
    private final IAuthorRepository authorRepository;

    @Autowired
    public BookServiceImpl(IBookRepository bookRepository, IAuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<BookEntity> getAllBooks(){
        return bookRepository.findAll();
    }


    @Override
    public BookEntity findById(Long id) {
        Optional<BookEntity> bookEntityOptional=bookRepository.getBookEntityById(id);
        if(bookEntityOptional.isPresent()){
            return bookRepository.getBookEntityById(id).get();
        }else {
            throw new EntityNotFound("Book not found (id:"+id+")");
         }
    }


    @Override
    public BookEntity saveBook(BookEntityInput bookEntityInput) {
        Optional<BookEntity> existingBook = bookRepository.getBookEntityByTitle(bookEntityInput.getTitle());
        if(existingBook.isPresent() && existingBook.get().getGenre().equals(bookEntityInput.getGenre())){
                      throw new EntityAlreadyExist("Book with that name and genre alredy exist (id:"+existingBook.get().getId()+")");
        } else {

            List<Long> ids = bookEntityInput.getAuthors();
            List<AuthorEntity> authors = new ArrayList<>();
            for (Long id : ids) {
                Optional<AuthorEntity> authorEntityOptional = authorRepository.getAuthorEntityById(id);
                if (authorEntityOptional.isPresent()) {
                    authors.add(authorEntityOptional.get());
                } else {
                    throw new EntityNotFound("Author not found (id:" + id + ")");
                }
            }
            BookEntity bookToSave = new BookEntity();
            bookToSave.setTitle(bookEntityInput.getTitle());
            bookToSave.setGenre(bookEntityInput.getGenre());
            bookToSave.setAuthors(authors);
            return bookRepository.save(bookToSave);
        }
    }
    @Override
    public BookEntity updateBookById(BookInput input, Long id){
        BookEntity foundBook= findById(id);
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
        bookRepository.delete(findById(id));
    }
}
