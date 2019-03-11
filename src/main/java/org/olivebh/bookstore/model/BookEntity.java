package org.olivebh.bookstore.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.annotation.sql.DataSourceDefinition;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//@Data

@Entity
@Table(name = "book", schema = "bookstore")
public class BookEntity {

    private Long id;
    private String title;
    private String genre;
    private List<AuthorEntity> authors;
    private List<PageEntity> pages;

    //region constructors
    public BookEntity(){

    }

    public BookEntity(String title,String genre, AuthorEntity... authors) {
        this.title = title;
        this.genre = genre;
     //   this.authors = Stream.of(authors).collect(Collectors.toSet());
        this.authors.forEach(x -> x.getBooks().add(this));
    }

    public BookEntity(Long id) {
        this.id = id;
    }

    public BookEntity(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }
    //endregion

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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return id == that.id &&
                Objects.equals(title, that.title) &&
                Objects.equals(genre, that.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, genre);
    }

    //@JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="book_author_relation",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
    public List<AuthorEntity> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorEntity> authors) {
        this.authors = authors;
    }

   @JsonManagedReference
    @OneToMany(mappedBy = "book_id",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    public List<PageEntity> getPages() {
        return pages;
    }

    public void setPages(List<PageEntity> pages) {
        this.pages = pages;
    }


    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    public void addPage(PageEntity tempPage){
        if(pages==null){
            pages=new ArrayList<>();
        }
        pages.add(tempPage);
    }
    public void addAuthors(AuthorEntity authorEntity){
        if(authors==null){
            authors=new ArrayList<>();
        }
        authors.add(authorEntity);
    }
}
