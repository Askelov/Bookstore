package org.olivebh.bookstore.model.inputEntities;

public class AuthorInput {
    private String name;

    //region consructors
    public AuthorInput(String name) {
        this.name = name;
    }

    public AuthorInput() {
    }
    //endregion
    //region getters and setters
    public String getName() {
        return name;
    }

    public void setName(String asim) {
        this.name = asim;
    }
    //endregion
}
