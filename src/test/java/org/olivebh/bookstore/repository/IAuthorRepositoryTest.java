package org.olivebh.bookstore.repository;

import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.junit.MockitoJUnitRunner;
import org.olivebh.bookstore.model.AuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


@DataJpaTest
@RunWith(SpringRunner.class)
public class IAuthorRepositoryTest {
   @Resource
    private IAuthorRepository authorRepository;

    @Test
    public void add_authors_then_delete_all(){
        AuthorEntity author1 = new AuthorEntity(1L, "aske1");
        AuthorEntity author2 = new AuthorEntity(2L, "aske2");
        authorRepository.save(author1);
        authorRepository.save(author2);
        authorRepository.deleteAll();
        List<AuthorEntity> authors = authorRepository.findAll();
        assertEquals(0, authors.size());
    }

   @Test
    public void find_saved_author() {
        AuthorEntity authorEntity = new AuthorEntity(1L, "aske");
        authorRepository.save(authorEntity);
        Optional<AuthorEntity> db =authorRepository.findById(1L);
        if(db.isPresent())
        assertEquals("aske", db.get().getName());
    }

    @Test
    public void add_author_then_delete() {
        AuthorEntity author1 = new AuthorEntity(1L, "aske1");
        AuthorEntity author2 = new AuthorEntity(2L, "aske2");
        authorRepository.save(author1);
        authorRepository.save(author2);
        authorRepository.delete(author1);
        List<AuthorEntity> authors = authorRepository.findAll();
        assertEquals(1, authors.size());
    }



    @Test
    public void add_author_then_update(){
        AuthorEntity author1 = new AuthorEntity(1L, "aske1");
        authorRepository.save(author1);
        Optional<AuthorEntity> db =authorRepository.findById(1L);
        if(db.isPresent()){
            db.get().setName("UpdateName");
        authorRepository.save(db.get());
        db=authorRepository.findById(1L);
        assertEquals("UpdateName", db.get().getName());
                }
        }

}