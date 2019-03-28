package org.olivebh.bookstore.repository;

import org.olivebh.bookstore.model.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAuthorRepository extends JpaRepository<AuthorEntity, Long> {
    Optional<AuthorEntity> getAuthorEntityById(Long id);
    Optional<AuthorEntity> getAuthorEntityByName(String name);
}
