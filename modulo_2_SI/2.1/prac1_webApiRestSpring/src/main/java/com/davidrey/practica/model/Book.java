package com.davidrey.practica.model;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

public class Book {

    public interface Basico {
    }

    @JsonView(Basico.class)
    private Long id;

    @JsonView(Basico.class)
    private String user;

    private String title;
    private String resume;
    private String author;
    private String editorial;
    private Integer publishYear;

    private List<Comment> commentsList;

    public Book(String user, String title, String resume, String author, String editorial, Integer publishYear, List<Comment> commentsList) {
        super();
        this.user = user;
        this.title = title;
        this.resume = resume;
        this.author = author;
        this.editorial = editorial;
        this.publishYear = publishYear;
        this.commentsList = commentsList;
    }

    public Long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitle() {return title;}

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public List<Comment> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comment> commentsList) {
        this.commentsList = commentsList;
    }

    @Override
    public String toString() {
        return "Book [id="+id+", title=" + title + ", resumen=" + resume + ", author=" + author + ", editorial=" + editorial + ", year=" + publishYear + ", comment=" + commentsList + "]";
    }

}
