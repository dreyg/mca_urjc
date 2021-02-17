package com.davidrey.practica.controller;

import com.davidrey.practica.model.Book;
import com.davidrey.practica.model.Comment;
import com.davidrey.practica.service.ManageLibraryService;
import com.davidrey.practica.service.UserSessionService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;


@RestController
@RequestMapping("/books")
public class LibraryRestController {

    @Autowired
    private ManageLibraryService manageLibraryService;

    @Autowired
    private UserSessionService userSessionService;

    @JsonView(Book.Basico.class)
    @GetMapping("/")
    public Collection<Book> getBooks(){
        return manageLibraryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBooksById(@PathVariable long id){

        Book book = manageLibraryService.findById(id);

        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        manageLibraryService.save(book);

        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(book.getId()).toUri();

        return ResponseEntity.created(location).body(book);
    }

    @PostMapping("/{id}/comments/")
    public ResponseEntity<Book> createNewComment(@PathVariable long id, @RequestBody Comment comment){
        Book book = manageLibraryService.findById(id);

        if (book != null) {
            manageLibraryService.saveComment(comment, id);
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}/comments/{idComments}")
    public ResponseEntity<Comment> deleteComment(@PathVariable long id, @PathVariable long idComments){
        Book book = manageLibraryService.findById(id);

        if (book != null) {
            manageLibraryService.deleteByIdComments(id, idComments);
            return ResponseEntity.ok(book.getCommentsList().get((int) idComments));
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
