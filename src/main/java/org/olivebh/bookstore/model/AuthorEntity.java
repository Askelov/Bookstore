package org.olivebh.bookstore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "author", schema = "bookstore", catalog = "")
public class AuthorEntity {

    private Long id;
    private String name;
    private List<BookEntity> books;

    //region constructors
    public AuthorEntity(Long id,String name) {
        this.id=id;
        this.name = name;
    }

    public AuthorEntity() {
    }
    //endregion
    //region getters and setters with annotation
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonBackReference
    @ManyToMany(mappedBy="authors",cascade = CascadeType.ALL)
    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }
    //endregion
    //region hash and equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorEntity that = (AuthorEntity) o;
        return
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
    //endregion
}
