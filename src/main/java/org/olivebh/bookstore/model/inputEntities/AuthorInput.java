package org.olivebh.bookstore.model.inputEntities;

public class AuthorInput {
    private String name;

    //region consructors
    public AuthorInput(String NAME) {
        this.name = NAME;
    }

    public AuthorInput() {
    }
    //endregion
    //region getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //endregion
}
