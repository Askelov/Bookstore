package org.olivebh.bookstore.service;

import org.olivebh.bookstore.exception.EntityNotFound;
import org.olivebh.bookstore.model.AuthorEntity;
import org.olivebh.bookstore.model.dto.AuthorDto;
import org.olivebh.bookstore.model.inputEntities.AuthorInput;
import org.olivebh.bookstore.repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{

    private IAuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(IAuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorEntity> getAllAuthors(){
        return authorRepository.findAll();
    }

    @Override
    public AuthorDto save(AuthorDto authorDto){
        return new AuthorDto(authorRepository.save(authorDto.toPojo()));
    }

    @Override
    public AuthorEntity findById(Long id){
        Optional<AuthorEntity> authorEntityOptional=authorRepository.getAuthorEntityById(id);
        if(authorEntityOptional.isPresent()) {
            return authorRepository.getAuthorEntityById(id).get();
        }else{
            throw new EntityNotFound("Author not found (id:"+id+")");
        }
    }

    @Override
    public void deleteAuthors(){
        authorRepository.deleteAll();
    }

    @Override
    public void deleteAuthor(Long id){
        authorRepository.delete(findById(id));
    }

    @Override
    public AuthorDto updateAuthorById(AuthorInput input, Long id){
        AuthorEntity foundAuthor=findById(id);
        foundAuthor.setName(input.getName());
        return new AuthorDto(authorRepository.save(foundAuthor));
    }
}
