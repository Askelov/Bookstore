package org.olivebh.bookstore.service.impl;

import javafx.application.Application;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;

import org.mockito.junit.MockitoJUnitRunner;

import org.olivebh.bookstore.BookstoreApplication;
import org.olivebh.bookstore.exception.EntityAlreadyExist;
import org.olivebh.bookstore.exception.EntityNotFound;
import org.olivebh.bookstore.exception.ExceptionHandler;
import org.olivebh.bookstore.model.AuthorEntity;
import org.olivebh.bookstore.model.dto.AuthorDto;
import org.olivebh.bookstore.model.inputEntities.AuthorInput;
import org.olivebh.bookstore.repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.xml.ws.soap.Addressing;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
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
        when(authorRepository.save(author1)).thenReturn(author1);
        when(authorRepository.getAuthorEntityById(1L)).thenReturn(Optional.of(author1));
        when(authorRepository.getAuthorEntityById(2L)).thenReturn(Optional.of(author2));
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
        when(authorRepository.save(author1)).thenThrow(new EntityAlreadyExist("Author already exist"));
        authorServiceMock.save(authorDto);
    }

    @Test(expected=EntityNotFound.class)
    public void findByIdTest() {
       assertEquals("Asim1",authorServiceMock.findById(1L).getName());
        AuthorEntity author1 = new AuthorEntity(100L, "Asim1");
       authorServiceMock.findById(100L);
    }

    @Test(expected = EntityNotFound.class)
    public void deleteAuthorTest() {
        assertEquals("Asim2", authorServiceMock.findById(2L).getName());
        authorServiceMock.deleteAuthor(2L);
        when(authorRepository.getAuthorEntityById(2L).isPresent()).thenThrow(new EntityNotFound("Author not found (id:"+2L+")"));
      //  when(!authorRepository.getAuthorEntityById(2L).isPresent()).thenThrow(new EntityNotFound("Author not found (id:"+2L+")"));
        authorServiceMock.findById(2L);
    }

    @Test(expected = EntityNotFound.class)
    public void deleteAuthorsTest() {
        assertEquals(3, authorServiceMock.getAllAuthors().size());
        assertEquals("Asim1",authorServiceMock.findById(1L).getName());
        List<AuthorEntity> authors= new ArrayList<>();
        when(authorRepository.findAll()).thenReturn(authors);
        authorServiceMock.deleteAuthors();
        assertEquals(0,authorServiceMock.getAllAuthors().size());
        when(authorRepository.getAuthorEntityById(1L)).thenThrow(new EntityNotFound("Author not found (id:"+1L+")"));
            authorServiceMock.findById(1L);
    }

    @Test
    public void updateAuthorById() {
        AuthorEntity author5 = new AuthorEntity(5L, "Asim5");
        when(authorRepository.getAuthorEntityById(5L)).thenReturn(Optional.of(author5));
       // authorServiceMock.findById(100L);
        assertEquals("Asim5", authorServiceMock.findById(5L).getName());

        AuthorInput authorInput = new AuthorInput("AsimUpdate");
        author5.setName("AsimUpdate");

      //  when(authorRepository.getAuthorEntityById(5L)).thenReturn(Optional.of(author5));
        when(authorRepository.save(author5)).thenReturn(author5);

        AuthorDto authorDto= authorServiceMock.updateAuthorById(authorInput,5L);
        assertEquals("AsimUpdate", authorDto.getName());
    }


}