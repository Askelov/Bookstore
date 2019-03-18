package org.olivebh.bookstore.service.impl;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;

import org.mockito.junit.MockitoJUnitRunner;

import org.olivebh.bookstore.exception.EntityAlreadyExist;
import org.olivebh.bookstore.exception.EntityNotFound;
import org.olivebh.bookstore.model.AuthorEntity;
import org.olivebh.bookstore.model.dto.AuthorDto;
import org.olivebh.bookstore.repository.IAuthorRepository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthorServiceImplTest {


    static IAuthorRepository authorRepository;

   @InjectMocks
   static AuthorServiceImpl authorServiceMock;

    @BeforeClass
    public static void setUp() {
        authorRepository = mock(IAuthorRepository.class);
        AuthorEntity author1 = new AuthorEntity(1L, "Asim1");
        AuthorEntity author2 = new AuthorEntity(2L, "Asim2");
        AuthorEntity author3 = new AuthorEntity(3L, "Asim3");
        when(authorRepository.findAll()).thenReturn(Arrays.asList(author1, author2,author3));
        when(authorRepository.save(author1)).thenReturn(author1).thenThrow(new EntityAlreadyExist("Author already exist"));
        when(authorRepository.getAuthorEntityById(1L)).thenReturn(Optional.of(author1));
        when(authorRepository.getAuthorEntityById(100L)).thenThrow(new EntityNotFound("Author not found (id:"+100L+")"));

    }

    @Test
    public void getAllAuthorsTest() {
        List<AuthorEntity> allAuthors = authorServiceMock.getAllAuthors();
        assertEquals(3, allAuthors.size());
        assertEquals("Asim2", allAuthors.get(1).getName());
    }

    @Test(expected=EntityAlreadyExist.class)
    public void saveTest() {
        AuthorEntity author1 = new AuthorEntity(1L, "Asim1");
        AuthorDto authorDto = new AuthorDto(author1);
       authorDto= authorServiceMock.save(authorDto);
       assertEquals("Asim1",authorDto.getName());
       authorDto= authorServiceMock.save(authorDto);
    }

    @Test(expected=EntityNotFound.class)
    public void findByIdTest() {
       assertEquals("Asim1",authorServiceMock.findById(1L).getName());
       authorServiceMock.findById(100L);
    }


}