package org.olivebh.bookstore.repository;


import org.olivebh.bookstore.model.BookEntity;
import org.olivebh.bookstore.model.PageEntity;
import org.olivebh.bookstore.model.dto.BookDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IBookRepository extends JpaRepository<BookEntity, Long> {

    List<BookEntity> findByIdIn(List<Integer> ids);
    Optional<BookEntity> getBookEntityById(Long id);

}
