package org.olivebh.bookstore.repository;

import org.olivebh.bookstore.model.BookEntity;
import org.olivebh.bookstore.model.PageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPageRepository extends JpaRepository<PageEntity, Long> {
    public Optional<PageEntity> getPageEntityById(Long id);


}
