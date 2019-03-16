package org.olivebh.bookstore.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.olivebh.bookstore.model.AuthorEntity;
import org.olivebh.bookstore.model.dto.AuthorDto;
import org.olivebh.bookstore.repository.IAuthorRepository;
import org.olivebh.bookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthorServiceImplTest {

    @Mock
    IAuthorRepository authorRepository;

    @InjectMocks
    AuthorServiceImpl authorServiceMock;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getAllAuthorsTest() {
        //When
        List<AuthorEntity> authors = new ArrayList<>();
        AuthorEntity author1 = new AuthorEntity(1L, "askee");
        AuthorEntity author2 = new AuthorEntity(2L, "askee2");
        AuthorEntity author3 = new AuthorEntity(3L, "aske33");
        authors.add(author1);
        authors.add(author2);
        authors.add(author3);
      /* when(authorRepository.findAll()).thenReturn(Stream.of(new AuthorEntity(1L,"askee"),
               new AuthorEntity(2L,"askee2"), new AuthorEntity(3L,"askeeaaaa")).collect(Collectors.toList()));*/
        //
        when(authorRepository.findAll()).thenReturn(authors);

        List<AuthorEntity> allAuthors = authorServiceMock.getAllAuthors();
        //Then
        assertEquals(3, allAuthors.size());
        assertEquals("askee2", allAuthors.get(1).getName());
    }

    @Test
    public void save() {
        AuthorEntity authotr = new AuthorEntity(1L, "Aske Aganovic");
        when(authorRepository.save(authotr));
        //AuthorDto save = authorServiceMock.save(authotr);
        //   assertEquals(save.getName(), "aske");
        assertEquals(new AuthorDto(new AuthorEntity(1L, "askee")), authorServiceMock.save(new AuthorDto(new AuthorEntity(1L, "askee"))));
    }
}