package org.olivebh.bookstore.controller;


import org.olivebh.bookstore.model.AuthorEntity;
import org.olivebh.bookstore.model.BookEntity;
import org.olivebh.bookstore.model.PageEntity;
import org.olivebh.bookstore.model.dto.AuthorDto;
import org.olivebh.bookstore.model.dto.PageDto;
import org.olivebh.bookstore.model.inputEntities.AuthorInput;
import org.olivebh.bookstore.model.inputEntities.PageInput;
import org.olivebh.bookstore.service.AuthorService;
import org.olivebh.bookstore.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.olivebh.bookstore.util.Utils.checkValidNumber;


@RestController
@RequestMapping(path = Constant.ROOT_AUTHOR)
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
    public AuthorEntity findByid(@PathVariable("id") String id) {
        Long validId = checkValidNumber(id);
        return authorService.findById(validId);
    }

    @PostMapping
    public AuthorDto save(@RequestBody AuthorDto authorDto) {
        return authorService.save(authorDto);
    }

    @PutMapping(path="/{id}")
    public AuthorDto updateAuthor(@RequestBody AuthorInput input, @PathVariable("id") String id){
        Long validId = checkValidNumber(id);
        return authorService.updateAuthorById(input,validId);
    }
    @DeleteMapping
    public void deleteAuthors(){
        authorService.deleteAuthors();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAuthor(@PathVariable("id") String id){
        Long validId = checkValidNumber(id);
        authorService.deleteAuthor(validId);
    }


}
