package org.olivebh.bookstore.service;

import org.olivebh.bookstore.model.PageEntity;
import org.olivebh.bookstore.model.dto.BookDto;
import org.olivebh.bookstore.model.dto.PageDto;
import org.olivebh.bookstore.model.inputEntities.PageInput;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PageService {

    PageDto getPageById(Long id);

    List<PageDto> getPagesByIds(List<Long> ids);

    List<PageDto> getAllPages();

    PageDto savePage(PageEntity pageEntity);

    PageDto updatePageById(PageInput input, Long id);

    void deletePage(Long id);

    void deletePages();

}
