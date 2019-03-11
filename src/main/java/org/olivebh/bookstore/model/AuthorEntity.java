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

    public AuthorEntity(String name) {
        this.name = name;
    }

    public AuthorEntity() {
    }

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
/*@ManyToOne
    @JoinTable(name = "book_author_relation",
     catalog = "", schema = "bookstore",
     joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))*/
/*@ManyToMany(mappedBy = "publishers")*/
   /* @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,
                    CascadeType.DETACH,CascadeType.REFRESH})
    @JoinTable(
            name="book_author_relation",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))*/
   @JsonBackReference
   @ManyToMany(mappedBy="authors")
    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }
}