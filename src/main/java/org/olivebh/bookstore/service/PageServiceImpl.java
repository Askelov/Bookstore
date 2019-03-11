package org.olivebh.bookstore.service;

import org.olivebh.bookstore.model.PageEntity;
import org.olivebh.bookstore.model.dto.PageDto;
import org.olivebh.bookstore.model.inputEntities.PageInput;
import org.olivebh.bookstore.repository.IPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PageServiceImpl implements PageService {

    private IPageRepository pageRepository;

    @Autowired
    public PageServiceImpl(IPageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }


    @Override
    public PageDto savePage(PageEntity pageEntity) {
       return new PageDto(pageRepository.save(pageEntity));
    }

    @Override
    public PageDto getPageById(Long id){
        return new PageDto(pageRepository.getPageEntityById(id));
    }

    @Override
    public List<PageDto> getAllPages(){
        ArrayList<PageEntity> pages = new ArrayList<>((int)pageRepository.count());
        ArrayList<PageDto> pagesDto = new ArrayList<>((int)pageRepository.count());
        pageRepository.findAll().forEach(pages::add);
        for(PageEntity page : pages){
           if(page.getBook_id()!=null)
            pagesDto.add(new PageDto(page));
        }
        return pagesDto;
    }

    @Override
    public PageDto updatePageById(PageInput input, Long id){
        PageEntity that=pageRepository.getPageEntityById(id);
        that.setText(input.getText());
        that.setOrdinalNumber(input.getOrdinalNumber());
        return new PageDto (pageRepository.save(that));
    }

    @Override
    public void deletePage(Long id){
        pageRepository.delete(pageRepository.getPageEntityById(id));

    }

    @Override
    public void deletePages(){
        pageRepository.deleteAll();
    }


}
