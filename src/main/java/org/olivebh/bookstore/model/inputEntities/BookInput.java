package org.olivebh.bookstore.model.inputEntities;

public class BookInput {

    private String title;
    private String genre;

    //region construcotrs
    public BookInput(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public BookInput() {
    }
    //endregion
    //region getters and setters
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
    //endregion
}

