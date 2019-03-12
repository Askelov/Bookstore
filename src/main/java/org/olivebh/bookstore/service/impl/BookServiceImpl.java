package org.olivebh.bookstore.service.impl;

import org.olivebh.bookstore.exception.EntityNotFound;
import org.olivebh.bookstore.model.AuthorEntity;
import org.olivebh.bookstore.model.BookEntity;
import org.olivebh.bookstore.model.dto.BookDto;
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
    public BookDto save(BookDto bookDto) {
        /*
       List<AuthorEntity> authors= bookDto.getAuthors();
        for(AuthorEntity author:authors){
           Optional<AuthorEntity> authorEntity = authorRepository.getAuthorEntityByName(author.getName());
           if(authorEntity.isPresent()){
               continue;
           }else{
               authorRepository.save(author);
           }
        }*/
        return new BookDto(bookRepository.save(bookDto.toPojo()));

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
