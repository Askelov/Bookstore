package org.olivebh.bookstore.model.dto;

import org.olivebh.bookstore.model.BookEntity;
import org.olivebh.bookstore.model.PageEntity;

public class PageDto {

    private Long id;
    private Integer ordinalNumber;
    private String text;
    private Long book_id;


    //region construtctors
    public PageDto() {
    }

    public PageDto(PageEntity that) {
        this.id = that.getId();
        this.ordinalNumber = that.getOrdinalNumber();
        this.text = that.getText();
        this.book_id=that.getBook_id().getId();
    }
    //endregion

    //region getters and setters


    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrdinalNumber() {
        return ordinalNumber;
    }

    public void setOrdinalNumber(Integer ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    //endregion

    public PageEntity toPojo(){
        PageEntity that= new PageEntity();
        that.setId(this.id);
        that.setOrdinalNumber(this.ordinalNumber);
        that.setText(this.text);
        that.setBook_id(new BookEntity());
        return that;
    }

}
