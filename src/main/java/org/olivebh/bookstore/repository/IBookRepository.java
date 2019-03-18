package org.olivebh.bookstore.repository;


import org.olivebh.bookstore.model.BookEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface IBookRepository extends JpaRepository<BookEntity, Long> {


    Optional<BookEntity> getBookEntityById(Long id);
    Optional<BookEntity> getBookEntityByTitle(String title);
}
