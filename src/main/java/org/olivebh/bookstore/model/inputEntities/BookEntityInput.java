package org.olivebh.bookstore.model.inputEntities;

import org.olivebh.bookstore.model.AuthorEntity;
import org.olivebh.bookstore.model.PageEntity;

import java.util.List;

public class BookEntityInput {
    private Long id;
    private String title;
    private String genre;
    private List<Long> authors;
    private List<PageEntity> pages;

    public BookEntityInput(Long id) {
    }

    public BookEntityInput(Long id, String title, String genre, List<Long> authors) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.authors = authors;
    }

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

    public List<Long> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Long> authors) {
        this.authors = authors;
    }
}
