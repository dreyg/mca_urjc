package com.davidrey.practica.controller;

import com.davidrey.practica.model.Book;
import com.davidrey.practica.model.Comment;
import com.davidrey.practica.service.ManageLibraryService;
import com.davidrey.practica.service.UserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LibraryWebController {

    @Autowired
    private ManageLibraryService manageLibraryService;

    @Autowired
    private UserSessionService userSessionService;

    @GetMapping("/")
    public String showBooks(Model model, HttpSession session) {

        model.addAttribute("books", manageLibraryService.findAll());
        model.addAttribute("welcome", session.isNew());

        return "index";
    }

    @GetMapping("/book/new")
    public String newBookForm(Model model) {

        model.addAttribute("user", userSessionService.getUser());

        return "new_book";
    }

    @PostMapping("/book/new")
    public String newBook(Model model, Book book){

        manageLibraryService.save(book);

        userSessionService.setUser(book.getUser());
        userSessionService.incNumPosts();

        model.addAttribute("numBooks", userSessionService.getNumPosts());

        return "saved_book";
    }

    @GetMapping("/book/{id}")
    public String showBook(Model model, @PathVariable long id) {

        Book book = manageLibraryService.findById(id);

        model.addAttribute("book", book);

        return "show_book";
    }

    @GetMapping("/book/{id}/delete")
    public String deletePost(Model model, @PathVariable long id) throws IOException {

        manageLibraryService.deleteById(id);

        return "delete_book";
    }

    @GetMapping("/comment/new")
    public String newCommentForm(Model model) {

        model.addAttribute("user", userSessionService.getUser());

        return "show_book";
    }

    @PostMapping("/comment/new")
    public String newComment(Model model, Comment comment, Book book){

        manageLibraryService.saveComment(comment, (Long) model.getAttribute(String.valueOf(book.getId())));

        userSessionService.setUser(comment.getUser());
        userSessionService.incNumPosts();

        model.addAttribute("numComments", userSessionService.getNumPosts());

        return "saved_book";
    }

}
