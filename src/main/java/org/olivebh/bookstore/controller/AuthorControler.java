package org.olivebh.bookstore.controller;


import org.olivebh.bookstore.model.AuthorEntity;
import org.olivebh.bookstore.model.dto.AuthorDto;
import org.olivebh.bookstore.model.inputEntities.AuthorInput;
import org.olivebh.bookstore.service.AuthorService;
import org.olivebh.bookstore.service.ValidationService;
import org.olivebh.bookstore.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping(path = Constant.ROOT_AUTHOR)
public class AuthorControler {

    private AuthorService authorService;
    private ValidationService validationService;

    @Autowired
    public AuthorControler(AuthorService authorService, ValidationService validationService) {
        this.authorService = authorService;
        this.validationService=validationService;
    }

    @GetMapping
    public List<AuthorEntity> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping(path = "/{id}")
    public AuthorEntity findByid(@PathVariable("id") String id) {
        Long validId = validationService.checkValidNumber(id);
        return authorService.findById(validId);
    }

    @PostMapping
    public AuthorDto save(@RequestBody AuthorDto authorDto) {
        return authorService.save(authorDto);
    }

    @PutMapping(path="/{id}")
    public AuthorDto updateAuthor(@RequestBody AuthorInput input, @PathVariable("id") String id){
        Long validId = validationService.checkValidNumber(id);
        return authorService.updateAuthorById(input,validId);
    }
    @DeleteMapping
    public void deleteAuthors(){
        authorService.deleteAuthors();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAuthor(@PathVariable("id") String id){
        Long validId = validationService.checkValidNumber(id);
        authorService.deleteAuthor(validId);
    }


}
