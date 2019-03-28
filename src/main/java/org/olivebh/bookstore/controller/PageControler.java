package org.olivebh.bookstore.controller;


import org.olivebh.bookstore.model.PageEntity;
import org.olivebh.bookstore.model.dto.PageDto;
import org.olivebh.bookstore.model.inputEntities.PageInput;
import org.olivebh.bookstore.service.PageService;
import org.olivebh.bookstore.service.ValidationService;
import org.olivebh.bookstore.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping(path = Constant.ROOT_PAGE)
public class PageControler {

    private PageService pageService;
    private ValidationService validationService;

    @Autowired
    public PageControler(PageService pageService, ValidationService validationService) {
        this.pageService = pageService;
        this.validationService = validationService;
    }

    @GetMapping
    public List<PageDto> getAllPages(){
        return pageService.getAllPages();
    }

    @GetMapping(path = "/{id}")
    public PageDto getPageById(@PathVariable("id") String id){
        Long validId = validationService.checkValidNumber(id);
        return pageService.getPageById(validId);
    }

    @PostMapping(path="/ids")
    public List<PageDto> getPagesByIds(@RequestBody List<Long> ids) {
        return pageService.getPagesByIds(ids);
    }


    @PostMapping
    public PageDto save(@RequestBody PageEntity pageEntity) {
        return pageService.savePage(pageEntity);
    }

    @PutMapping(path="/{id}")
    public PageDto updatePage(@RequestBody PageInput input, @PathVariable("id") String id){
         Long validId = validationService.checkValidNumber(id);
         return pageService.updatePageById(input,validId);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePage(@PathVariable("id") String id){
          Long validId = validationService.checkValidNumber(id);
          pageService.deletePage(validId);
    }

    @DeleteMapping
    public void deletePages(){
        pageService.deletePages();
    }

}
