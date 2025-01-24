package org.example.portcartierlibrarybackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Document {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String Author;
    private String year;
    private String category;
    private String Type;
    private String genre;
    private String description;
    private String ISBM;

    public Document() {}

    public Document(String title, String author, String year, String category, String type, String genre, String description, String ISBM) {
        this.title = title;
        this.Author = author;
        this.year = year;
        this.category = category;
        this.Type = type;
        this.genre = genre;
        this.description = description;
        this.ISBM = ISBM;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getISBM() {
        return ISBM;
    }

    public void setISBM(String ISBM) {
        this.ISBM = ISBM;
    }
}
