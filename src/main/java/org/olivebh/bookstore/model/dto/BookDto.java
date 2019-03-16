package org.olivebh.bookstore.model.dto;

import org.olivebh.bookstore.model.AuthorEntity;
import org.olivebh.bookstore.model.BookEntity;
import org.olivebh.bookstore.model.PageEntity;

import java.util.List;

public class BookDto {
    //region private properties
    private Long id;
    private String title;
    private String genre;
    private List<AuthorEntity> authors;
    private List<PageEntity> pages;
    //endregion

    //region getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<AuthorEntity> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorEntity> authors) {
        this.authors = authors;
    }

    public List<PageEntity> getPages() {
        return pages;
    }

    public void setPages(List<PageEntity> pages) {
        this.pages = pages;
    }
    //endregion

    //region constructors
    public BookDto() {}

    public BookDto(BookEntity that) {
        this.id = that.getId();
        this.title = that.getTitle();
        this.genre = that.getGenre();
       this.authors=that.getAuthors();
       this.pages=that.getPages();
    }
    //endregion

    //region toPojo() method
    public BookEntity toPojo() {
        BookEntity that = new BookEntity();
        that.setId(this.id);
        that.setTitle(this.title);
        that.setGenre(this.genre);
        that.setAuthors(this.authors);
       // that.setPages(this.pages);
        return that;
    }
    //endregion
}
