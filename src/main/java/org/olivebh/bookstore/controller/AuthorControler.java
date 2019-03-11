package org.olivebh.bookstore.controller;

import org.olivebh.bookstore.constant.CONSTANT;
import org.olivebh.bookstore.model.AuthorEntity;
import org.olivebh.bookstore.model.BookEntity;
import org.olivebh.bookstore.model.PageEntity;
import org.olivebh.bookstore.model.dto.AuthorDto;
import org.olivebh.bookstore.model.dto.PageDto;
import org.olivebh.bookstore.model.inputEntities.AuthorInput;
import org.olivebh.bookstore.model.inputEntities.PageInput;
import org.olivebh.bookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = CONSTANT.ROOT_AUTHOR)
public class AuthorControler {

    private AuthorService authorService;

    @Autowired
    public AuthorControler(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<AuthorEntity> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping(path = "/{id}")
    public AuthorEntity findByid(@PathVariable("id") Long id) {
        return authorService.findById(id);
    }

    @PostMapping
    public AuthorDto save(@RequestBody AuthorDto authorDto) {
        return authorService.save(authorDto);
    }

    @PutMapping(path="/{id}")
    public AuthorDto updateAuthor(@RequestBody AuthorInput input, @PathVariable("id") Long id){
        return authorService.updateAuthorById(input,id);
    }
    @DeleteMapping
    public void deleteAuthors(){
        authorService.deleteAuthors();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAuthor(@PathVariable("id") Long id){
        authorService.deleteAuthor(id);
    }


}
