package org.olivebh.bookstore.model.inputEntities;

public class PageInput {

    private Integer ordinalNumber;
    private String text;

    //region consturctors
    public PageInput(Integer ordinalNumber, String text) {
        this.ordinalNumber = ordinalNumber;
        this.text = text;
    }
    public PageInput(){
    }
    //endregion
    //region getters and setters
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

}
