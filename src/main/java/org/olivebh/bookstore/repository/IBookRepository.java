package org.olivebh.bookstore.repository;


import org.olivebh.bookstore.model.BookEntity;
import org.olivebh.bookstore.model.PageEntity;
import org.olivebh.bookstore.model.dto.BookDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<BookEntity, Long> {

    List<BookEntity> findByIdIn(List<Integer> ids);
    BookEntity getBookEntityById(Long id);

}
