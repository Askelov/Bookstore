package org.olivebh.bookstore.service;

import org.olivebh.bookstore.model.AuthorEntity;
import org.olivebh.bookstore.model.dto.AuthorDto;
import org.olivebh.bookstore.model.inputEntities.AuthorInput;

import java.util.List;

public interface AuthorService {

    List<AuthorEntity> getAllAuthors();

    AuthorDto save(AuthorDto authorDto);

    AuthorEntity findById(Long id);

    void deleteAuthors();

    void deleteAuthor(Long id);

    AuthorDto updateAuthorById(AuthorInput input, Long id);

}
