package com.davidrey.practica.service;

import com.davidrey.practica.model.Book;
import com.davidrey.practica.model.Comment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class ManageLibraryService {

    private ConcurrentMap<Long, Book> books = new ConcurrentHashMap<>();
    private AtomicLong nextId = new AtomicLong();

    public ManageLibraryService() {
        save(new Book("Pedro","El Mundo Amarillo",
                "si crees en los sueños, ellos se crearán", "Albert Espinosa","Grijalbo",2010,
                new ArrayList<>(Arrays.asList(new Comment[]{new Comment(0L,"Libro TOP", "Pedro", 5)}))));
        save(new Book( "Luis", "La fuerza de uno",
                "Un niño que lucha y siempre se levanta", "Bryce Courtenay","Diagonal",2002,
                new ArrayList<>(Arrays.asList(new Comment[]{new Comment(1L, "Libro TOP", "Pedro", 5)}))));
    }

    public Collection<Book> findAll() {
        return books.values();
    }

    public Book findById(long id) {
        return books.get(id);
    }

    public void save(Book book) {

        long id = nextId.getAndIncrement();

        book.setId(id);
        this.books.put(id, book);
    }

    public void deleteById(long id) {
        this.books.remove(id);
    }

    public void deleteByIdComments(long idBook, long idComment) {
        this.books.get(idBook).getCommentsList().remove(idComment);
    }

    public void saveComment(Comment comment, Long bookId) {

        long id = nextId.getAndIncrement();
        comment.setId(id);

        // TODO pasar el bookId de alguna forma
        Book updateBook = findById(bookId);
        updateBook.getCommentsList().add(comment);
        this.books.put(id, updateBook);
    }




}
