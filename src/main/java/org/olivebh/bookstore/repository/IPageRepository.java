package org.olivebh.bookstore.repository;


import org.olivebh.bookstore.model.PageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



import java.util.Optional;

@Repository
public interface IPageRepository extends JpaRepository<PageEntity, Long> {
     Optional<PageEntity> getPageEntityById(Long id);
}
