package org.olivebh.bookstore.controller;

import org.olivebh.bookstore.constant.CONSTANT;
import org.olivebh.bookstore.model.AuthorEntity;
import org.olivebh.bookstore.model.BookEntity;
import org.olivebh.bookstore.model.PageEntity;
import org.olivebh.bookstore.model.dto.BookDto;
import org.olivebh.bookstore.model.dto.PageDto;
import org.olivebh.bookstore.model.inputEntities.PageInput;
import org.olivebh.bookstore.service.BookService;
import org.olivebh.bookstore.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.jca.cci.CciOperationNotSupportedException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.olivebh.bookstore.constant.CONSTANT.ROOT_PAGE;

@RestController
@RequestMapping(path = CONSTANT.ROOT_PAGE)
public class PageControler {

    private PageService pageService;

    @Autowired
    public PageControler(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping
    public List<PageDto> getAllPages(){
        return pageService.getAllPages();
    }

    @GetMapping(path = "/{id}")
    public PageDto getPageById(@PathVariable("id") Long id){
            return pageService.getPageById(id);

                }

    @PostMapping
    public PageDto save(@RequestBody PageEntity pageEntity) {
        return pageService.savePage(pageEntity);
    }

    @PutMapping(path="/{id}")
    public PageDto updatePage(@RequestBody PageInput input, @PathVariable("id") Long id){
         return pageService.updatePageById(input,id);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePage(@PathVariable("id") Long id){
          pageService.deletePage(id);
    }

    @DeleteMapping
    public void deletePages(){
        pageService.deletePages();
    }


}
