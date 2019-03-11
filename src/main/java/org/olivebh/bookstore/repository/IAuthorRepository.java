package org.olivebh.bookstore.repository;

import org.olivebh.bookstore.model.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepository extends JpaRepository<AuthorEntity, Integer> {
    AuthorEntity getAuthorEntityById(Long id);
}
