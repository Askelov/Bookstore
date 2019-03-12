package org.olivebh.bookstore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "page", schema = "bookstore", catalog = "")
public class PageEntity {

    private Long id;
    private Integer ordinalNumber;
    private String text;
    private BookEntity book_id;

    //region constructors
    public PageEntity(){

    }

    public PageEntity(Integer ordinalNumber, String text) {
        this.ordinalNumber = ordinalNumber;
        this.text = text;
    }
    //endregion
    //region getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ordinal_number")
    public Integer getOrdinalNumber() {
        return ordinalNumber;
    }

    public void setOrdinalNumber(Integer ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
    }

    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name="book_id")
    public BookEntity getBook_id() {
        return book_id;
    }

    public void setBook_id(BookEntity book_id) {
        this.book_id = book_id;
    }
    //endregion
    //region hash and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageEntity that = (PageEntity) o;
        return id == that.id &&
                book_id == that.book_id &&
                Objects.equals(ordinalNumber, that.ordinalNumber) &&
                Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ordinalNumber, text, book_id);
    }
    //endregion
    //region toString
    @Override
    public String toString() {
        return "PageEntity{" +
                "id=" + id +
                ", ordinalNumber=" + ordinalNumber +
                ", text='" + text + '\'' +
                '}';
    }
    //endregion
}
