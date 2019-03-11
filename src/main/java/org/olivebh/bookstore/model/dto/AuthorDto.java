package org.olivebh.bookstore.model.dto;

import org.olivebh.bookstore.model.AuthorEntity;
import org.olivebh.bookstore.model.BookEntity;

import java.util.List;

public class AuthorDto {
    private Long id;
    private String name;
    private List<BookEntity> books;


    //region construtors
    public AuthorDto() {
    }
    public AuthorDto(AuthorEntity that){
        this.id=that.getId();
        this.name=that.getName();
        this.books=that.getBooks();
    }
    //endregion
    //region getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //endregion

    public AuthorEntity toPojo() {
        AuthorEntity that = new AuthorEntity();
        that.setId(this.id);
        that.setName(this.name);
        that.setBooks(this.books);
        return that;
    }
}
